package com.clustering.cluster.service;

import com.clustering.cluster.repository.ServeurRepository;
import com.clustering.cluster.model.Serveur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ServeurService {
    @Autowired
    private ServeurRepository repo;

    public Serveur addServeur(Serveur serveur) {
        Serveur savedServeur = repo.save(serveur);
        updateHaproxyConfig(savedServeur);
        return savedServeur;
    }

    private void updateHaproxyConfig(Serveur serveur) {
        String haproxyConfig = "/etc/haproxy/haproxy.cfg";
        String backendConfig = "";
        if (serveur.getStatus().equals("0")) {
            backendConfig = String.format(
                "    server %s %s:%s check",
                 serveur.getName() ,serveur.getIpAddress(), serveur.getPort()
            );
        }else{
            backendConfig = String.format(
                "    server %s %s:%s check backup",
                 serveur.getName() ,serveur.getIpAddress(), serveur.getPort()
            );
        }
        

        try (FileWriter writer = new FileWriter(haproxyConfig, true)) {
            writer.write(backendConfig);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
