package com.projet.projet.controller;


import com.projet.projet.model.Paiement;
import com.projet.projet.model.RendezVous;
import com.projet.projet.service.PaiementService;
import com.projet.projet.service.RendezVousService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v3")

public class PaiementController {

    public PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }


    //  get All paiements
    // http://localhost:8080/api/v3/paiements
    @GetMapping("/paiements")
    public List<Paiement> getAllPaiements() {return this.service.getAllPaiements();}


    @GetMapping("/paiements/{idPaiement}")
    public Paiement getPaiement(@PathVariable("idPaiement") Long idPaiement) {
        return this.service.getPaiement(idPaiement);
    }


    @PostMapping("/addPaiement")
    public Paiement savePaiement(@RequestBody Paiement paiement){
        return this.service.savePaiement(paiement);
    }


    @GetMapping("/paiementByModepaiement/{modepaiement}")
    public Paiement findPaiementByModepaiement(@PathVariable String modepaiement) {
        return this.service.getPaiementByModepaiement(modepaiement);
    }

    @GetMapping("/factureByClient/{id}")
    public List<Paiement> findByClient(@PathVariable("id") Long id){
        return this.service.getByClient(id);
    }

    @GetMapping("/service/{service}/client/{id}")
    public List<Paiement> findByClientAndService(@PathVariable("id") Long id , @PathVariable("service") String service){
        return this.service.getByClientAndService(id,service);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Paiement paiement){
        Paiement update = this.service.update(paiement);
        if (update.getId() > 0) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);
    }



    @DeleteMapping("/delete/{id}")
    public  String deletePaiement(@PathVariable("id") Long id){
        System.out.println(id);
        return this.service.deletePaiement(id);
    }

}
