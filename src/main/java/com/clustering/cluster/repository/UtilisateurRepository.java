package com.clustering.cluster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clustering.cluster.model.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long>{
    
}
