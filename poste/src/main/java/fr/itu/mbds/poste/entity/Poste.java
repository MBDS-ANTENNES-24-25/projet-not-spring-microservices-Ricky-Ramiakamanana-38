package fr.itu.mbds.poste.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Poste {
    @Id
    private String id; // Acronyme : CTO, PDG, etc.
    private String nom;

    @ElementCollection
    private List<Long> competenceIds; // Stocke uniquement les IDs des compétences
}
