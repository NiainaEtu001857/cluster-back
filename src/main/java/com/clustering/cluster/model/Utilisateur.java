package com.clustering.cluster.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "utilisateur") // Assure que l'entité est bien mappée à la table "utilisateur"
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String prenom;

    private Date dtn;

    private String travail;

    private Double experience;

    public Utilisateur() {
    }

    public Utilisateur(String name, String prenom, Date dtn, String travail, Double experience) {
        this.name = name;
        this.prenom = prenom;
        this.dtn = dtn;
        this.travail = travail;
        this.experience = experience;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience2) {
        this.experience = experience2;
    }
}
