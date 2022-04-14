package com.projet.projet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "paiement")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Paiement implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Temporal(TemporalType.DATE)
     private Date  datepaiement;


    private String modepaiement;


     private Double montantotal;




    private Double montantpaye;

    private Double reste;


    private  String service;


    private  String departement;


    public Long getId() {
        return id != null ? id : 0 ;
    }


}
