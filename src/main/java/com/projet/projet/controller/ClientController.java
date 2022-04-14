package com.projet.projet.controller;

import com.projet.projet.model.Client;
import com.projet.projet.model.User;
import com.projet.projet.repos.ClientRepos;
import com.projet.projet.service.ClientService;
import com.projet.projet.service.UserService;
import net.sf.jasperreports.engine.JRException;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v6")
public class ClientController {


    private ClientRepos clientRepos;



    public ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    //Generate Report
    @GetMapping("Client/clients/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException{
        return service.exportReport(format);
    }


    //  get All clients
    // http://localhost:8080/api/v6/clients
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return this.service.getAllClients();
    }



    @GetMapping("/clients/{idClient}")
    public Client getClient(@PathVariable("idClient") Long idClient) {
        return this.service.getClient(idClient);
    }

    // client/prenom
    //http://localhost:8080/api/v6/clientByPrenom/prenom
    @GetMapping("/clientByPrenom/{prenom}")
    public Client findClientByPrenom(@PathVariable String prenom) {
        return this.service.getClientByPrenom(prenom);
    }



    //Add user
    //http://localhost:8080/api/v6/addClient
    @PostMapping("/addClient")
    public Client saveClient(@RequestBody Client client ){
        System.out.println(client);
        return this.service.saveClient(client);
    }


    //Update
    //http://localhost:8080/api/v6/update
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Client client){
        Client update = this.service.update(client);
        if (update.getId() > 0) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);
    }



    //Delete
    //http://localhost:8080/api/v6/delete/id
    @DeleteMapping("/delete/{idClient}")
    public  String deleteClient(@PathVariable("idClient") Long idClient){
        System.out.println(idClient);
        return this.service.deleteClient(idClient);
    }

}
