package dev.ruka.restaurantbookingsystem.repositories;

import dev.ruka.restaurantbookingsystem.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, String> {
}
