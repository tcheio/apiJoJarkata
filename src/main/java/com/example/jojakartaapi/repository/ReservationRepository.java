package com.example.jojakartaapi.repository;

import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.model.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.visiteur = :visiteur AND r.epreuve.date = :date")
    List<Reservation> findByVisiteurAndEpreuveDate(Visiteur visiteur, Date date);
}
