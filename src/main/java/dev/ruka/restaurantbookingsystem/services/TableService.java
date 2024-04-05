package dev.ruka.restaurantbookingsystem.services;

import dev.ruka.restaurantbookingsystem.exceptions.ServerSideException;
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
            throw new ServerSideException("Uma mesa com este número já existe");
        } else {
            repository.save(table);
        }
    }

    public Table getTableByNumero(String numero){
        Table table = repository.findByNumero(numero);

        if(table == null){
            throw new ServerSideException("Esta mesa não existe");
        } else {
            return table;
        }
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
}
