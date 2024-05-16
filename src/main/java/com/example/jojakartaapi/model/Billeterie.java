package com.example.jojakartaapi.model;

import com.example.jojakartaapi.model.Epreuve;
import jakarta.persistence.*;
@Entity
public class Billeterie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    private Epreuve epreuve;
    @Column
    private Long prix;
    @Column
    private Integer nbPlace;

    public Billeterie(Long id, Epreuve epreuve, Long prix, Integer nbPlace) {
        this.id = id;
        this.epreuve = epreuve;
        this.prix = prix;
        this.nbPlace = nbPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }
}
