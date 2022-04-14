package com.projet.projet.service;

import com.projet.projet.model.RendezVous;
import com.projet.projet.model.Supportechnique;
import com.projet.projet.model.User;

import java.util.List;

public interface SupportechniqueService {

    List<Supportechnique> getAllSupportechniques();

    Supportechnique saveSupportechnique (Supportechnique supportechnique);

    Supportechnique  update (Supportechnique supportechnique);

    Supportechnique getSupportechnique(Long idSupportechnique);

    List<Supportechnique> getByClient(Long id);

    Supportechnique getSupportechniqueByProblematique(String problematique);


    String deleteSupportechnique  (Long id);

}
