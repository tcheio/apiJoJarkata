package com.example.jojakartaapi.repository;

import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.model.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByVisiteurAndDate(Visiteur visiteur, Date date);
}
