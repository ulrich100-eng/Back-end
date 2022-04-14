package com.projet.projet.repos;

import com.projet.projet.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaiementRepos extends JpaRepository<Paiement, Long> {

    List<Paiement> getByClient(Long id);

    List<Paiement> findByClientAndService(Client client, String service );

    Optional<Paiement> findById(Long id);


    Paiement findByModepaiement(String modepaiement);
}
