package sn.isep.dbe.livre.Gestion.Livre.services;

import org.springframework.stereotype.Service;
import sn.isep.dbe.livre.Gestion.Livre.dao.AuteurRepository;
import sn.isep.dbe.livre.Gestion.Livre.models.Auteur;

import java.util.List;

@Service
public class AuteurService{
    private final AuteurRepository auteurRepository;

    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    public Auteur getAuteurById(Long id) {
        return auteurRepository.findById(id).orElse(null);
    }

    public Auteur saveAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public void deleteAuteur(Long id) {
        auteurRepository.deleteById(id);
    }
}
