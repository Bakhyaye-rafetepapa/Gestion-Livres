package sn.isep.dbe.livre.Gestion.Livre.services;

import org.springframework.stereotype.Service;
import sn.isep.dbe.livre.Gestion.Livre.dao.CategorieRepository;
import sn.isep.dbe.livre.Gestion.Livre.models.Categorie;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
