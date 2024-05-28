package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.Services.ReservationService;
import com.example.jojakartaapi.Services.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
                                                    @RequestParam String dateString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = sdf.parse(dateString);
        System.out.println("Received request with visiteurId: " + visiteurId + ", epreuveId: " + epreuveId + ", nbPlaces: " + nbPlaces + ", date: " + date);

        Visiteur visiteur = visiteurService.getVisiteurById(visiteurId);
        if (visiteur == null) {
            return ResponseEntity.badRequest().body("Visiteur pas trouvé");
        }

        boolean reservationCreated = reservationService.createReservation(visiteur, epreuveId, nbPlaces, date);
        if (reservationCreated) {
            return ResponseEntity.ok("Reservation créée");
        } else {
            return ResponseEntity.badRequest().body("Reservation ne peut pas être créée");
        }
    }

}

