package dev.ruka.restaurantbookingsystem.services;

import dev.ruka.restaurantbookingsystem.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    TableRepository repository;
}
