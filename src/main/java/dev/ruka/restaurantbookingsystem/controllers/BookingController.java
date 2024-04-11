package dev.ruka.restaurantbookingsystem.controllers;

import dev.ruka.restaurantbookingsystem.dto.BookingDto;
import dev.ruka.restaurantbookingsystem.model.Booking;
import dev.ruka.restaurantbookingsystem.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingService service;

    @GetMapping("/{reservante}")
    public @ResponseBody Booking getBookingByReservante(@PathVariable("reservante") String reservante){
        return service.getBookingByReservante(reservante);
    }

    @PostMapping
    public ResponseEntity<String> postBooking(@Valid @RequestBody BookingDto bookingDto){
        service.createBooking(bookingDto);
        return ResponseEntity.ok().body("Reservado com sucesso!");
    }

    @DeleteMapping("/delete/{reservante}")
    public void deleteBookingByReservante(@PathVariable("reservante") String reservante){
        service.deleteBookingByReservante(reservante);
    }
}
