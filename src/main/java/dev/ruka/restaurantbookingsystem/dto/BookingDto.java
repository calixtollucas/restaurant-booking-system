package dev.ruka.restaurantbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.ruka.restaurantbookingsystem.model.Booking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {

    @NotEmpty
    private String reservante;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer numPessoas;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate data;

    @JsonFormat(pattern = "HH:mm")
    @NotNull
    private LocalTime hora;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @NotNull
    private List<String> mesas;

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
