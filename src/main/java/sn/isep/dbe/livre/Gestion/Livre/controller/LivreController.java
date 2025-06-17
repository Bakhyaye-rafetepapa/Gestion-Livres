package sn.isep.dbe.livre.Gestion.Livre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sn.isep.dbe.livre.Gestion.Livre.models.Livre;
import sn.isep.dbe.livre.Gestion.Livre.services.LivreService;

import java.util.List;

@Controller
@RequestMapping("/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    // Affiche tous les livres + formulaire vide (ajout)
    @GetMapping
    public String afficherLivres(Model model) {
        model.addAttribute("livres", livreService.getAllLivres());
        model.addAttribute("livre", new Livre());
        return "livres"; // jsp: livres.jsp
    }

    // Préremplit le formulaire pour édition
    @GetMapping("/editer")
    public String editerLivre(@RequestParam Long id, Model model) {
        Livre livre = livreService.getLivreById(id);
        model.addAttribute("livre", livre != null ? livre : new Livre());
        model.addAttribute("livres", livreService.getAllLivres());
        return "livres";
    }


    @PostMapping("/save")
    public String enregistrerLivre(@ModelAttribute Livre livre, RedirectAttributes redirectAttributes) {
        livreService.saveLivre(livre);
        redirectAttributes.addFlashAttribute("message", (livre.getId() == null ? "Livre ajouté" : "Livre modifié") + " avec succès !");
        return "redirect:/livres";
    }

    @PostMapping("/supprimer")
    public String supprimerLivre(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        livreService.deleteLivre(id);
        redirectAttributes.addFlashAttribute("message", "Livre supprimé avec succès !");
        return "redirect:/livres";
    }

}
