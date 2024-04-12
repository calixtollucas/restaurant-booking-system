package dev.ruka.restaurantbookingsystem.controllers;

import dev.ruka.restaurantbookingsystem.dto.TableDto;
import dev.ruka.restaurantbookingsystem.dto.UpdateTableDto;
import dev.ruka.restaurantbookingsystem.exceptions.BusinessException;
import dev.ruka.restaurantbookingsystem.model.Table;
import dev.ruka.restaurantbookingsystem.services.TableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tables")
public class TableController {

    @Autowired
    TableService service;

    @PostMapping
    public void createTable(@Valid @RequestBody TableDto tableDto){
        service.create_table(tableDto.toEntity());
    }

    @GetMapping
    public @ResponseBody List<TableDto> getAllTables(){
        List<Table> tables = service.getAllTables();

        return tables.stream()
                .map(t -> new TableDto(t.getNumero(), t.getNum_cadeiras()))
                .collect(Collectors.toList());
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<TableDto> getTableByNumero(@PathVariable("numero") String numero){
        Table table = service.getTableByNumero(numero);
        if(table == null){
            throw new BusinessException("Esta mesa não existe");
        } else {
            return ResponseEntity.ok().body(new TableDto(table.getNumero(), table.getNum_cadeiras()));
        }

    }

    //retorna 0 se a mesa não estiver ocupada e 1 se estiver.
    @GetMapping("/isoccupied/{numero}")
    public @ResponseBody Integer isTableOccupied(@PathVariable("numero") String numero){
        boolean resposta = service.isTableOccupied(numero);
        if (resposta == true){
            return 1;
        } else {
            return 0;
        }
    }

    @PutMapping("/{tableNumber}")
    public ResponseEntity<String> updateTable(@RequestBody UpdateTableDto updateTableDto,
                                              @PathVariable String tableNumber){
        service.updateTable(updateTableDto, tableNumber);
        return ResponseEntity.ok().body("Mesa "+tableNumber+" atualizada com sucesso");
    }

    @PutMapping("/unsubscribe/{tableNumber}")
    public ResponseEntity<String> unsubscribeTable(@PathVariable String tableNumber){
        service.unsubscribeTableByNumero(tableNumber);
        return ResponseEntity.ok().body("Mesa "+tableNumber+" liberada com sucesso");
    }

    @DeleteMapping("/delete/{numero}")
    public ResponseEntity<String> deleteTableByNumero(@PathVariable("numero") String numero){
        service.deleteTableByNumero(numero);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }
}
