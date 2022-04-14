package com.projet.projet.controller;

import com.projet.projet.model.User;
import com.projet.projet.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class UserController {

    public UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //  get All users
    // http://localhost:8080/api/v1/users
    @GetMapping("/users")
    public List<User> getAllUsers() {return this.service.getAllUsers();}

    @GetMapping("/users/{idUser}")
    public User getUser(@PathVariable("idUser") Long idUser) {
        return this.service.getUser(idUser);
    }


    // user/prenom
    //http://localhost:8080/api/v1/userByPrenom/prenom
    @GetMapping("/userByPrenom/{prenom}")
    public User findUserByPrenom(@PathVariable String prenom) {
        return this.service.getUserByPrenom(prenom);
    }



    //Add user
    //http://localhost:8080/api/v1/addUser
    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user ){
        System.out.println(user);
        return this.service.saveUser(user);
    }


    //Update
    //http://localhost:8080/api/v1/update
     @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user){
         User update = this.service.update(user);
         if (update.getId() > 0) {
             return new ResponseEntity<>(update, HttpStatus.OK);
         }
         return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);
     }



     //Delete
    //http://localhost:8080/api/v1/delete/id
     @DeleteMapping("/delete/{id}")
    public  String deleteUser(@PathVariable("id") Long id){
        System.out.println(id);
        return this.service.deleteUser(id);
     }

}
