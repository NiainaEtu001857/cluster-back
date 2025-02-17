package com.clustering.cluster.model;

import jakarta.persistence.*;

@Entity
public class Serveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; 
    private String port;
    private String ipAddress;
    private String status; 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to import data
    public static Serveur fromData(String name, String type, String ipAddress, String status , String port) {
        Serveur serveur = new Serveur();
        serveur.setName(name);
        serveur.setType(type);
        serveur.setIpAddress(ipAddress);
        serveur.setStatus(status);
        serveur.setPort(port);
        return serveur;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
}
