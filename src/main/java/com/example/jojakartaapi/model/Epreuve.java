package com.example.jojakartaapi.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String lieu;
    private Date date;
    private Integer nbPlaces;

    public Epreuve() {
        // Constructeur par défaut requis par JPA
    }

    public Epreuve(String libelle, String lieu, Date date, Integer nbPlaces) {
        this.libelle = libelle;
        this.lieu = lieu;
        this.date = date;
        this.nbPlaces = nbPlaces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }
}
