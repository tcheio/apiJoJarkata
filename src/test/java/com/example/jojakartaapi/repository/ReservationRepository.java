package com.example.jojakartaapi.repository;

import com.example.jojakartaapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
