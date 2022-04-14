package com.projet.projet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import  javax.persistence.TemporalType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Table(name = "rendezvous")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous implements Serializable {

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
    @Column(name="jour")
    private Date jour;

  @Temporal(TemporalType.TIME)
    @Column(name="heure")
    private Date heure;

    private String lieu;

    private String departement;


    private String statut;

    public Long getId() {
        return id != null ? id : 0 ;
    }

}
