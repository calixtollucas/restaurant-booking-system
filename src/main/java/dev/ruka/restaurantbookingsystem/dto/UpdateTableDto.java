package dev.ruka.restaurantbookingsystem.dto;

import dev.ruka.restaurantbookingsystem.model.Booking;
import dev.ruka.restaurantbookingsystem.model.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateTableDto {
    private String numero;
    private Integer numCadeiras;
    private Booking BookingId;
}
