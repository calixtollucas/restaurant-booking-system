package dev.ruka.restaurantbookingsystem.services;

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
        repository.deleteByNumero(numero);
    }

    public void setBookingId(List<String> mesas, Booking booking){
            for (String mesa : mesas){
                Table toBeUpdated= repository.findByNumero(mesa);
                toBeUpdated.setReserva(booking);
                repository.save(toBeUpdated);
            }

    }

//    public void unsubscribeTableBookingId(Booking booking){
//        List<Table> tables = repository.findByBookingId(booking);
//        for (Table table : tables){
//            table.setReserva(null);
//            repository.save(table);
//        }
//    }


}
