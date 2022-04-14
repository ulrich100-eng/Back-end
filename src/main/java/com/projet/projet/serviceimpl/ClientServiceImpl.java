package com.projet.projet.serviceimpl;

import com.projet.projet.model.Client;
import com.projet.projet.model.User;
import com.projet.projet.repos.ClientRepos;
import com.projet.projet.repos.UserRepos;
import com.projet.projet.service.ClientService;
import com.projet.projet.service.UserService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Service
public class ClientServiceImpl implements ClientService {



     ClientRepos clientRepos;

    public ClientServiceImpl(ClientRepos clientRepos) {
        this.clientRepos = clientRepos;
    }

      public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path ="C:\\Users\\acer\\Spring Boot\\Report";
        List<Client> clients = clientRepos.findAll();

          File file = ResourceUtils.getFile("classpath:reports\\ClientReport.jrxml");
          JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
          JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);

          Map<String, Object> parameters = new HashMap<>();
          parameters.put("createdBy","Holmetech");
          JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

          //Create for HTML
          if (reportFormat.equalsIgnoreCase("html")){
              JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\ClientReport.html");
          }

          //Create for PDF
          if (reportFormat.equalsIgnoreCase("pdf")){
              JasperExportManager.exportReportToPdfFile(jasperPrint,path + "\\ClientReport.pdf");
          }
          return "Report generated in path:" + path;
      }



    @Override
    public List<Client> getAllClients() {
        return clientRepos.findAll();
    }

    @Override
    public Client getClient(Long idClient) {
        try {
            Optional<Client> optional = clientRepos.findById(idClient);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new Client();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new Client();
        }
    }

    @Override
    public Client getClientByPrenom(String prenom) {
        return clientRepos.findByPrenom(prenom);
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        try {
            Client bean = clientRepos.findByPrenom(client.getPrenom());
            if (bean != null && bean.getId() > 0) {
                return new Client();
            }
            return clientRepos.save(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Client();
        }
    }

    @Override
    public Client update(Client client) {
        try {
            System.out.println(client.toString());
            return clientRepos.save(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Client();
        }
    }


    @Override
    public String deleteClient(Long id) {
        Client bean = clientRepos.findById(id).orElse(new Client());
        clientRepos.findById(id);
        if (bean.getId() > 0) {
            clientRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }



}
