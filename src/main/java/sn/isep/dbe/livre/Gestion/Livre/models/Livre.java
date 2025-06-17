package sn.isep.dbe.livre.Gestion.Livre.models;

import jakarta.persistence.*;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;



    @Column(length = 1000)
    private String description;

    // Constructeurs
    public Livre() {}

    public Livre(String titre, Auteur auteur, Categorie categorie, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.description = description;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
