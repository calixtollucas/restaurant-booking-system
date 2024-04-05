package dev.ruka.restaurantbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.ruka.restaurantbookingsystem.model.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BookingDto {

    @NotBlank
    private String reservante;

    @NotBlank
    private int numPessoas;

    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotBlank
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora;

    public Booking toBooking(){
        Booking booking = new Booking();
        booking.setId(UUID.randomUUID().toString());
        booking.setReservante(this.reservante);
        booking.setNumPessoas(this.numPessoas);
        booking.setData(this.data);
        booking.setHora(this.hora);

        return booking;
    }
}
