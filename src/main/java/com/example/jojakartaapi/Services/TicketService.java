package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Ticket;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private VisiteurService visiteurService;

    @Autowired
    private ReservationService reservationService;

    public Ticket createTicket(Visiteur visiteur, Reservation reservation) {
        Ticket ticket = new Ticket(visiteur, reservation);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(String id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(String id, Ticket ticketDetails) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setVisiteur(ticketDetails.getVisiteur());
                    ticket.setReservation(ticketDetails.getReservation());
                    return ticketRepository.save(ticket);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }
}
