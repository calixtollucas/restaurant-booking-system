package dev.ruka.restaurantbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateTableDto {
    private String numero;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Integer numCadeiras;
}
