package sn.isep.dbe.livre.Gestion.Livre.services;

import org.springframework.stereotype.Service;
import sn.isep.dbe.livre.Gestion.Livre.dao.LivreRepository;
import sn.isep.dbe.livre.Gestion.Livre.models.Livre;

import java.util.List;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}

