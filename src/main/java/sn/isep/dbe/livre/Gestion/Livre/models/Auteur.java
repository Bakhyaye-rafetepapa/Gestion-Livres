package sn.isep.dbe.livre.Gestion.Livre.models;

import jakarta.persistence.*;

@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(length = 100)
    private String biographies;

    // Getters et Setters
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

    public String getBiographies() {
        return biographies;
    }

    public void setBiographies(String biographies) {
        this.biographies = biographies;
    }

}
