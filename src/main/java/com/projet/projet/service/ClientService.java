package com.projet.projet.service;

import com.projet.projet.model.Client;
import net.sf.jasperreports.engine.JRException;


import java.io.FileNotFoundException;
import java.util.List;

public interface ClientService {

    List<Client> getAllClients();


    Client getClient(Long idClient);

    Client getClientByPrenom(String prenom);

    Client saveClient (Client client);

    Client update(Client client);

    String deleteClient  (Long idClient);

    String exportReport(String format) throws FileNotFoundException, JRException;
}
