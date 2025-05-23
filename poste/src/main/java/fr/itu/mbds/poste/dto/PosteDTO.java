package fr.itu.mbds.poste.dto;

import fr.itu.mbds.poste.model.Competence;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosteDTO {
    private String id;
    private String nom;
    private List<Long> competenceIds;
    private List<Competence> competences; // Peut être null si non récupéré
}
