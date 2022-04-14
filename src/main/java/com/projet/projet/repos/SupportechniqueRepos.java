package com.projet.projet.repos;


import com.projet.projet.model.Facture;
import com.projet.projet.model.RendezVous;
import com.projet.projet.model.Supportechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupportechniqueRepos extends JpaRepository <Supportechnique, Long> {

    List<Supportechnique> getByClient(Long id);

    Supportechnique findByProblematique(String problematique);

    Optional<Supportechnique> findById(Long id);
}

