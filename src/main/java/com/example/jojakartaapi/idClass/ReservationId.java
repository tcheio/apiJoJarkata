package com.example.jojakartaapi.idClass;

import java.io.Serializable;

public class ReservationId implements Serializable {
    private Long visiteur;
    private Long epreuve;

    public Long getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Long visiteur) {
        this.visiteur = visiteur;
    }
}
