package fr.itu.mbds.poste.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PosteDTO {
    private String id;
    private String nom;
    private List<Long> competenceIds;
}
