package com.example.jojakartaapi.model;

import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @ManyToOne
    @JoinColumn(name = "visiteur")
    private Visiteur visiteur;

    @Id
    @ManyToOne
    @JoinColumn(name = "epreuve")
    private Epreuve epreuve;

    @Column(name = "nbPlaceReserv")
    private Integer nbPlaceReserv;

    public Reservation(Visiteur visiteur, Epreuve epreuve, Integer nbPlaceReserv) {
        this.visiteur = visiteur;
        this.epreuve = epreuve;
        this.nbPlaceReserv = nbPlaceReserv;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Integer getNbPlaceReserv() {
        return nbPlaceReserv;
    }

    public void setNbPlaceReserv(Integer nbPlaceReserv) {
        this.nbPlaceReserv = nbPlaceReserv;
    }
}
