package com.clustering.cluster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clustering.cluster.model.Utilisateur;
import com.clustering.cluster.repository.UtilisateurRepository;

import ch.qos.logback.classic.pattern.Util;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository repository;

    public List<Utilisateur> find(){

        return repository.findAll();
    }

    public Utilisateur save(Utilisateur u) {
        return repository.save(u);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
