package dev.ruka.restaurantbookingsystem.dto;


import dev.ruka.restaurantbookingsystem.model.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TableDto {
    @NotBlank
    private String numero;
    @Min(value = 1L, message = "Uma mesa deve ter no mínimo uma cadeira")
    @NotBlank
    private Integer num_cadeiras;

    public Table toEntity(){
        Table table = new Table();
        table.setId(UUID.randomUUID().toString());
        table.setNumero(this.numero);
        table.setNum_cadeiras(this.num_cadeiras);
        return table;
    }
}
