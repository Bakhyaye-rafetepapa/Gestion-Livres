package sn.isep.dbe.livre.Gestion.Livre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.livre.Gestion.Livre.models.Auteur;
import sn.isep.dbe.livre.Gestion.Livre.services.AuteurService;

@Controller
@RequestMapping("/auteurs")
public class AuteurController {

    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    // Liste des auteurs + formulaire vide (ajout)
    @GetMapping
    public String afficherAuteurs(Model model) {
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        model.addAttribute("auteur", new Auteur());
        return "auteurs";
    }

    // Pré-remplit le formulaire pour modification
    @GetMapping("/editer")
    public String editerAuteur(@RequestParam Long id, Model model) {
        Auteur auteur = auteurService.getAuteurById(id);
        model.addAttribute("auteur", auteur != null ? auteur : new Auteur());
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        return "auteurs";
    }

    // Formulaire d'ajout explicite (optionnel, redirige simplement vers /auteurs)
    @GetMapping("/ajouter")
    public String formulaireAjoutAuteur() {
        return "redirect:/auteurs";
    }

    // Traitement de l'ajout ou de la modification
    @PostMapping("/save")
    public String enregistrerAuteur(@ModelAttribute Auteur auteur) {
        auteurService.saveAuteur(auteur);
        return "redirect:/auteurs";
    }

    // Suppression sécurisée via POST
    @PostMapping("/supprimer")
    public String supprimerAuteur(@RequestParam Long id) {
        auteurService.deleteAuteur(id);
        return "redirect:/auteurs";
    }
}
