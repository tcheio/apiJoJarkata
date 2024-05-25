package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.model.Ticket;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.repository.EpreuveRepository;
import com.example.jojakartaapi.repository.ReservationRepository;
import com.example.jojakartaapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EpreuveRepository epreuveRepository;

    @Transactional
    public boolean createReservation(Visiteur visiteur, Long epreuveId, int nbPlaces, Date date) {
        List<Reservation> existingReservations = reservationRepository.findByVisiteurAndDate(visiteur, date);
        if (!existingReservations.isEmpty()) {
            return false;
        }

        Epreuve epreuve = epreuveRepository.findById(epreuveId).orElse(null);
        if (epreuve == null || epreuve.getNbPlaces() < nbPlaces) {
            return false;
        }
        epreuve.setNbPlaces(epreuve.getNbPlaces() - nbPlaces);
        epreuveRepository.save(epreuve);

        Reservation reservation = new Reservation(visiteur, date);
        reservationRepository.save(reservation);
        for (int i = 0; i < nbPlaces; i++) {
            Ticket ticket = new Ticket(visiteur, reservation);
            ticketRepository.save(ticket);
        }

        return true;
    }
}
