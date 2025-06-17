package sn.isep.dbe.livre.Gestion.Livre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.livre.Gestion.Livre.models.Categorie;
import sn.isep.dbe.livre.Gestion.Livre.services.CategorieService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public String afficherCategories(Model model) {
        model.addAttribute("categories", categorieService.getAllCategories());
        model.addAttribute("categorie", new Categorie());
        return "categories";
    }

    @GetMapping("/editer")
    public String editerCategorie(@RequestParam Long id, Model model) {
        Categorie categorie = categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie != null ? categorie : new Categorie());
        model.addAttribute("categories", categorieService.getAllCategories());
        return "categories";
    }

    @PostMapping("/save")
    public String enregistrerCategorie(@ModelAttribute Categorie categorie, RedirectAttributes redirectAttributes) {
        categorieService.saveCategorie(categorie);
        String message = (categorie.getId() == null ? "Catégorie ajoutée" : "Catégorie modifiée") + " avec succès !";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/categories";
    }

    @PostMapping("/supprimer")
    public String supprimerCategorie(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        categorieService.deleteCategorie(id);
        redirectAttributes.addFlashAttribute("message", "Catégorie supprimée avec succès !");
        return "redirect:/categories";
    }
}
