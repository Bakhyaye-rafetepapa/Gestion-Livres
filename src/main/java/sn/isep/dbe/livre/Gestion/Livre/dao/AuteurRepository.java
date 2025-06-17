package sn.isep.dbe.livre.Gestion.Livre.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.dbe.livre.Gestion.Livre.models.Auteur;


public interface AuteurRepository extends JpaRepository<Auteur, Long> {}

