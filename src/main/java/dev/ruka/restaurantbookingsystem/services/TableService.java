package dev.ruka.restaurantbookingsystem.services;

import dev.ruka.restaurantbookingsystem.dto.TableDto;
import dev.ruka.restaurantbookingsystem.dto.UpdateTableDto;
import dev.ruka.restaurantbookingsystem.exceptions.BusinessException;
import dev.ruka.restaurantbookingsystem.model.Booking;
import dev.ruka.restaurantbookingsystem.model.Table;
import dev.ruka.restaurantbookingsystem.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    TableRepository repository;

    public void create_table(Table table){
        if(getTableByNumero(table.getNumero()) != null){
            throw new BusinessException("Uma mesa com este número já existe");
        } else {
            repository.save(table);
        }
    }

    public Table getTableByNumero(String numero){
        Table table = repository.findByNumero(numero);
            return table;
    }

    public List<Table> getAllTables(){
        return repository.findAll();
    }

    public boolean existsByNumero(String numero){
        return repository.existsByNumero(numero);
    }

    public boolean isTableOccupied(String numero){
        return repository.isTableOccupied(numero);
    }

    public void deleteTableByNumero(String numero){
        Table table = repository.findByNumero(numero);
        if(table.getReserva()!= null){
            throw new BusinessException("Esta mesa está ocupada, desocupe-a para que possa ser excluída da base");
        }
        if(table == null){
            throw new BusinessException("Esta mesa não exsite");
        } else {
            repository.delete(table);
        }
    }

    public void setBookingId(List<String> mesas, Booking booking){
            for (String mesa : mesas){
                Table toBeUpdated= repository.findByNumero(mesa);
                toBeUpdated.setReserva(booking);
                repository.save(toBeUpdated);
            }

    }

    public void unsubscribeTableByNumero(String numero){
        Table table = getTableByNumero(numero);
        if(table.getReserva() == null){
            throw new BusinessException("Esta mesa já está livre");
        } else {
            table.setReserva(null);
            repository.save(table);
        }
    }

    //UPDATE TABLE
    public void updateTable(UpdateTableDto updateTable, String numero){
        Table toBeUpdated = getTableByNumero(numero);
        if(toBeUpdated.getReserva() != null){
            throw new BusinessException("Esta mesa está ocupada, desocupe ela para que possa atualizar");
        }
        if(updateTable.getNumero() != null){
            toBeUpdated.setNumero(updateTable.getNumero());
        } else if(updateTable.getNumCadeiras() != null){
            toBeUpdated.setNum_cadeiras(updateTable.getNumCadeiras());
        }
        repository.save(toBeUpdated);
    }


}
