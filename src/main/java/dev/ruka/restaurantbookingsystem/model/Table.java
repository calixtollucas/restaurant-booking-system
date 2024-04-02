package dev.ruka.restaurantbookingsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@jakarta.persistence.Table(name = "tbl_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private Integer num_cadeiras;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking reserva;
}
