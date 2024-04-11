package dev.ruka.restaurantbookingsystem.repositories;

import dev.ruka.restaurantbookingsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query("SELECT b FROM Booking b WHERE b.reservante = ?1")
    Booking findByReservante(String reservante);

    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.reservante= ?1")
    Boolean existsByReservante(String reservante);
}
