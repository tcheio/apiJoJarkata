package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.Services.ReservationService;
import com.example.jojakartaapi.Services.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("getReservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("updateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        try {
            Reservation updatedReservation = reservationService.updateReservation(id, reservationDetails);
            return ResponseEntity.ok(updatedReservation);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
