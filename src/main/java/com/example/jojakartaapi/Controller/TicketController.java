package com.example.jojakartaapi.Controller;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.Services.TicketService;
import com.example.jojakartaapi.Services.VisiteurService;
import com.example.jojakartaapi.Services.ReservationService;
import com.example.jojakartaapi.model.Ticket;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private VisiteurService visiteurService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestParam Long visiteurId, @RequestParam Long reservationId) {
        Visiteur visiteur = visiteurService.getVisiteurById(visiteurId);
        Optional<Reservation> reservation = reservationService.getReservationById(reservationId);

        if (visiteur == null) {
            return ResponseEntity.badRequest().body(null);
        }

        if (!reservation.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Ticket newTicket = ticketService.createTicket(visiteur, reservation.get());
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("getTicket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("updateTicket/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody Ticket ticketDetails) {
        try {
            Ticket updatedTicket = ticketService.updateTicket(id, ticketDetails);
            return ResponseEntity.ok(updatedTicket);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteTicket/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
