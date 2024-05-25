package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.Services.ReservationService;
import com.example.jojakartaapi.Services.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private VisiteurService visiteurService;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestParam Long visiteurId,
                                                    @RequestParam Long epreuveId,
                                                    @RequestParam int nbPlaces,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        Visiteur visiteur = visiteurService.getVisiteurById(visiteurId);
        if (visiteur == null) {
            return ResponseEntity.badRequest().body("Visiteur not found");
        }

        boolean reservationCreated = reservationService.createReservation(visiteur, epreuveId, nbPlaces, date);
        if (reservationCreated) {
            return ResponseEntity.ok("Reservation created successfully");
        } else {
            return ResponseEntity.badRequest().body("Reservation could not be created due to constraints");
        }
    }
}
