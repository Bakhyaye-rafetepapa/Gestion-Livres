package sn.isep.dbe.livre.Gestion.Livre.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.livre.Gestion.Livre.models.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
