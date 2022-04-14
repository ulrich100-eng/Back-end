package com.projet.projet.repos;

import com.projet.projet.model.Client;
import com.projet.projet.model.RendezVous;
import com.projet.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RendezVousRepos extends JpaRepository<RendezVous, Long> {

    List<RendezVous> findByJour(Date jour);

    List<RendezVous> findByHeure(Date heure);

    List<RendezVous> findByLieu(String lieu);

    List<RendezVous> getByClient(Long id);

    List<RendezVous> findByClientAndJour(Date jour , Client client);

    Optional<RendezVous> findById(Long id);




}
