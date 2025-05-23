package fr.itu.mbds.poste.repository;

import fr.itu.mbds.poste.entity.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, String> {
}
