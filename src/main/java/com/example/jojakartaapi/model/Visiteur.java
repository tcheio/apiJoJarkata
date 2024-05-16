package com.example.jojakartaapi.model;

import jakarta.persistence.*;

import java.sql.Struct;

@Entity
@Table(name = "visiteur")
public class Visiteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    public Visiteur() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Visiteur(Long id, String nom, String tel, String mail, String password) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.mail = mail;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

