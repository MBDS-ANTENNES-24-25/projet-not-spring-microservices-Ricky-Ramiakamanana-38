package fr.itu.mbds.poste.service;

import fr.itu.mbds.poste.dto.PosteDTO;

import java.util.List;

public interface PosteService {
    List<PosteDTO> findAll();

    PosteDTO findById(String id);
}
