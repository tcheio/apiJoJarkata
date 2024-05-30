package com.example.jojakartaapi.Services;

import com.example.jojakartaapi.Error.ResourceNotFoundException;
import com.example.jojakartaapi.model.Epreuve;
import com.example.jojakartaapi.model.Reservation;
import com.example.jojakartaapi.model.Visiteur;
import com.example.jojakartaapi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EpreuveService epreuveService;  // Assuming you have this service to manage Epreuve

    public boolean createReservation(Visiteur visiteur, Long epreuveId, int nbPlaces, Date date) {
        Optional<Epreuve> epreuveOpt = epreuveService.getEpreuveById(epreuveId);
        if (epreuveOpt.isPresent()) {
            Epreuve epreuve = epreuveOpt.get();
            if (epreuve.getNbPlaces() >= nbPlaces) {
                epreuve.setNbPlaces(epreuve.getNbPlaces() - nbPlaces);
                epreuveService.updateEpreuve(epreuveId, epreuve);
                Reservation reservation = new Reservation(visiteur, date);
                reservationRepository.save(reservation);
                return true;
            }
        }
        return false;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setVisiteur(reservationDetails.getVisiteur());
                    reservation.setDate(reservationDetails.getDate());
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id " + id));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
