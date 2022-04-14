package com.projet.projet.service;

import com.projet.projet.model.User;

import java.util.List;

public interface UserService {

      List<User> getAllUsers();


        User getUser(Long idUser);

    User getUserByPrenom(String prenom);

    User saveUser (User user);

        User update(User user);

       String deleteUser  (Long id);


}
