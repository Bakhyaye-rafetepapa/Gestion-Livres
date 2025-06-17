package sn.isep.dbe.livre.Gestion.Livre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.isep.dbe.livre.Gestion.Livre.models.Utilisateur;
import sn.isep.dbe.livre.Gestion.Livre.services.UtilisateurService;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String afficherUtilisateurs(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
        return "utilisateurs";
    }

    @GetMapping("/editer")
    public String editerUtilisateur(@RequestParam Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        model.addAttribute("utilisateur", utilisateur != null ? utilisateur : new Utilisateur());
        model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
        return "utilisateurs";
    }

    @PostMapping("/save")
    public String enregistrerUtilisateur(@ModelAttribute Utilisateur utilisateur, RedirectAttributes redirectAttributes) {
        utilisateurService.saveUtilisateur(utilisateur);
        String action = (utilisateur.getId() == null ? "ajouté" : "modifié");
        redirectAttributes.addFlashAttribute("message", "Utilisateur " + action + " avec succès !");
        return "redirect:/utilisateurs";
    }

    @PostMapping("/supprimer")
    public String supprimerUtilisateur(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        utilisateurService.deleteUtilisateur(id);
        redirectAttributes.addFlashAttribute("message", "Utilisateur supprimé avec succès !");
        return "redirect:/utilisateurs";
    }
}
