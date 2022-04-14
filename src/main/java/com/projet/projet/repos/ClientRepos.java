package com.projet.projet.repos;

import com.projet.projet.model.Client;
import com.projet.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepos  extends JpaRepository<Client,Long> {

        Client findByPrenom(String prenom);

    Optional<Client> findById(Long id);

}
