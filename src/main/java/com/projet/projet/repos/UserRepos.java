package com.projet.projet.repos;

import com.projet.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepos extends JpaRepository<User, Long> {

    User findByPrenom(String prenom);

    Optional<User> findById(Long id);
}
