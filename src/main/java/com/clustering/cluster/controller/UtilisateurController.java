package com.clustering.cluster.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clustering.cluster.model.Utilisateur;
import com.clustering.cluster.service.UtilisateurService;


@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    // Méthode pour récupérer tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return service.find();
    }

    // Méthode pour sauvegarder un utilisateur
    /*@PostMapping
    public ResponseEntity<?> save(@RequestBody Utilisateur u) {
        try {
            if (u.getName() == null || u.getPrenom() == null || u.getDtn() == null) {
                return ResponseEntity.badRequest().body("Tous les champs sont requis !");
            }

            Utilisateur savedUser = service.save(u);
            return ResponseEntity.ok(savedUser); // Retourne l'utilisateur sauvegardé
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }**/
    @PostMapping("/add")
    public ResponseEntity<?> save(
        @RequestParam String name,
        @RequestParam String prenom,
        @RequestParam String dtn,
        @RequestParam String travail,
        @RequestParam int experience
    ) {
        try {
            if (name.isEmpty() || prenom.isEmpty() || dtn.isEmpty()) {
                return ResponseEntity.badRequest().body("Tous les champs sont requis !");
            }
            Date d = Date.valueOf(dtn);

            Utilisateur user = new Utilisateur();
            user.setName(name);
            user.setPrenom(prenom);
            user.setDtn(d);
            user.setTravail(travail);
            user.setExperience((double) experience);

            Utilisateur savedUser = service.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }



    // Méthode pour supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // On vérifie d'abord si l'utilisateur existe
        
        service.delete(id);
        return ResponseEntity.noContent().build(); // Si la suppression réussit, on retourne une réponse 204 (No Content)
    }
}
