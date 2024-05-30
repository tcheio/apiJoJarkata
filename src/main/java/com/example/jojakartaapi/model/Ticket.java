package com.example.jojakartaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @ManyToOne
    private Visiteur visiteur;

    @ManyToOne
    @JoinColumn(name = "reservation", nullable = false)
    @JsonBackReference
    private Reservation reservation;

    public Ticket() {
    }

    public Ticket(Visiteur visiteur, Reservation reservation) {
        this.visiteur = visiteur;
        this.reservation = reservation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
