package com.example.jojakartaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String nomVisiteur;
    @Column(nullable = false)
    private String prenomVisiteur;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "visiteur", referencedColumnName = "visiteur"),
            @JoinColumn(name = "epreuve", referencedColumnName = "epreuve")
    })
    @JsonBackReference
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "epreuve_id", nullable = false)
    @JsonBackReference
    private Epreuve epreuve;


    public Ticket(String id, String nomVisiteur, String prenomVisiteur, Reservation reservation, Epreuve epreuve) {
        this.id = id;
        this.nomVisiteur = nomVisiteur;
        this.prenomVisiteur = prenomVisiteur;
        this.reservation = reservation;
        this.epreuve = epreuve;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomVisiteur() {
        return nomVisiteur;
    }

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    public String getPrenomVisiteur() {
        return prenomVisiteur;
    }

    public void setPrenomVisiteur(String prenomVisiteur) {
        this.prenomVisiteur = prenomVisiteur;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}
