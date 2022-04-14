package com.projet.projet.controller;

import com.projet.projet.model.Facture;
import com.projet.projet.model.Paiement;
import com.projet.projet.service.FactureService;
import com.projet.projet.service.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v4")
public class FactureController {

    public FactureService service;

    public FactureController(FactureService service) {
        this.service = service;
    }

    //  get All factures
    // http://localhost:8080/api/v4/factures
    @GetMapping("/factures")
    public List<Facture> getAllFactures() {
        return this.service.getAllFactures();}


    @GetMapping("/factures/{idFacture}")
    public Facture getFacture(@PathVariable("idFacture") Long idFacture) {
        return this.service.getFacture(idFacture);
    }

    @PostMapping("/addFacture")
    public Facture saveFacture(@RequestBody Facture facture){
        return this.service.saveFacture(facture);
    }


    @GetMapping("/factureByDepartement/{departement}")
    public Facture findFactureByDepartement(@PathVariable String departement) {
        return this.service.getFactureByDepartement(departement);
    }



    @GetMapping("/factureByClient/{id}")
    public List<Facture> getByClient(@PathVariable("id") Long id){
        return  this.service.getByClient(id);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Facture facture){
        Facture update = this.service.update(facture);
        if (update.getId() > 0) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete/{idFacture}")
    public  String deleteFacture(@PathVariable("idFacture") Long idFacture){
        return this.service.deleteFacture(idFacture);
    }

}
