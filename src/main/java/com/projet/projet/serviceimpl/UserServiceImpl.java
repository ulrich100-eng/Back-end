package com.projet.projet.serviceimpl;

import com.projet.projet.model.User;
import com.projet.projet.repos.UserRepos;
import com.projet.projet.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepos userRepos;

    public UserServiceImpl(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepos.findAll();
    }


    @Override
    public User getUserByPrenom(String prenom) {
        return userRepos.findByPrenom(prenom);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        try {
            User bean = userRepos.findByPrenom(user.getPrenom());
            if (bean != null && bean.getId() > 0) {
                return new User();
            }
            return userRepos.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new User();
        }
    }


    @Override
    public User update(User user) {
        try {
            System.out.println(user.toString());
            return userRepos.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new User();
        }
    }


    @Override
    public String deleteUser(Long id) {
        User bean = userRepos.findById(id).orElse(new User());
        userRepos.findById(id);
        if (bean.getId() > 0) {
            userRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }

    @Override
    public User getUser(Long idUser) {
        try {
            Optional<User> optional = userRepos.findById(idUser);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new User();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new User();
        }
    }
}
