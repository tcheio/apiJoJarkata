package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.*;
import com.example.jojakartaapi.repository.EpreuveRepository;
import com.example.jojakartaapi.repository.VisiteurRepository;
import com.example.jojakartaapi.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Autowired
    private EpreuveRepository epreuveRepository;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestParam Long visiteurId,
            @RequestParam Long epreuveId,
            @RequestBody List<Ticket> tickets) {

        // Récupérez les entités visiteur et épreuve à partir de leurs ID
        Visiteur visiteur = visiteurRepository.findById(visiteurId)
                .orElseThrow(() -> new IllegalArgumentException("Visiteur non trouvé avec l'ID : " + visiteurId));
        Epreuve epreuve = epreuveRepository.findById(epreuveId)
                .orElseThrow(() -> new IllegalArgumentException("Epreuve non trouvée avec l'ID : " + epreuveId)).getEpreuve();

        // Créez la réservation
        Reservation reservation = reservationService.createReservation(visiteur, epreuve, tickets);

        return ResponseEntity.ok(reservation);
    }
}
