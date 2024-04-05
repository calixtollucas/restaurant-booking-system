package dev.ruka.restaurantbookingsystem.services;
import dev.ruka.restaurantbookingsystem.model.Booking;
import dev.ruka.restaurantbookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingService {
    @Autowired
    private BookingRepository repository;

    public void createBooking(Booking booking){

    }
}
