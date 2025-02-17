package com.clustering.cluster.repository;

import com.clustering.cluster.model.Serveur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServeurRepository extends JpaRepository<Serveur, Long> {
    
}
