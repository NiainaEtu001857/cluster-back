package com.clustering.cluster.controller;


import com.clustering.cluster.model.Serveur;
import com.clustering.cluster.model.Utilisateur;
import com.clustering.cluster.service.ServeurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class SeveurController {
    @Autowired
    private ServeurService service;

    /*@PostMapping
    public ResponseEntity<Serveur> createServer(@RequestBody Serveur server) {
        Serveur created = service.addServeur(server);
        return ResponseEntity.ok(created);
    }/* */
    @PostMapping
    public ResponseEntity<?> save(
        @RequestParam String name,
        @RequestParam String type,
        @RequestParam String ipAddress,
        @RequestParam String port,
        @RequestParam String status
    ) {
        try {
            
           
            Serveur user = new Serveur();
            user.setName(name);
            user.setIpAddress(ipAddress);
            user.setPort(port);
            user.setType(type);
            user.setStatus(status);

            Serveur savedUser = service.addServeur(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

}
