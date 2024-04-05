package dev.ruka.restaurantbookingsystem.repositories;

import dev.ruka.restaurantbookingsystem.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table, String> {
    @Query("SELECT t FROM Table t WHERE t.numero = ?1")
    Table findByNumero(String numero);

    @Query("SELECT CASE WHEN t.reserva IS NOT NULL THEN true ELSE false END FROM Table t WHERE t.numero = ?1")
    boolean isTableOccupied(String numero);

    @Query("DELETE FROM Table t WHERE t.reserva = ?1")
    void deleteByNumero(String numero);

    @Query("SELECT CASE WHEN t IS NOT NULL THEN true ELSE false FROM Table t WHERE t.numero = ?1")
    boolean existsByNumero(String numero);
}
