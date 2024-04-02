package dev.ruka.restaurantbookingsystem.services;

import dev.ruka.restaurantbookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;
}
