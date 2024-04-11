package dev.ruka.restaurantbookingsystem.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import dev.ruka.restaurantbookingsystem.model.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableDto {
    @NotBlank
    private String numero;
    @Min(value = 1L, message = "Uma mesa deve ter no mínimo uma cadeira")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Integer num_cadeiras;

    public Table toEntity(){
        Table table = new Table();
        table.setId(UUID.randomUUID().toString());
        table.setNumero(this.numero);
        table.setNum_cadeiras(this.num_cadeiras);
        return table;
    }
}
