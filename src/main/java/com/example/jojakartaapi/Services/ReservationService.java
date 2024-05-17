package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.model.*;
import com.example.jojakartaapi.repository.ReservationRepository;
import com.example.jojakartaapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional
    public Reservation createReservation(Visiteur visiteur, Epreuve epreuve, List<Ticket> tickets) {
        List<Reservation> existingReservations = reservationRepository.findByVisiteurAndEpreuveDate(visiteur, epreuve.getDate());
        if (!existingReservations.isEmpty()) {
            throw new IllegalStateException("Le visiteur a déjà une réservation pour une épreuve le même jour.");
        }

        Reservation reservation = new Reservation(visiteur, epreuve, tickets.size());
        reservationRepository.save(reservation);

        for (Ticket ticket : tickets) {
            ticket.setReservation(reservation);
            ticketRepository.save(ticket);
        }

        return reservation;
    }
}
