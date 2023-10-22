package com.project;

public class PR450Producte {
    private int id;
    private String nom;


    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        System.out.println("El id del producto ha cambiado de "+oldId+" a "+id);
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        System.out.println("El nombre del producto ha cambiado de "+oldNom+" a "+nom);
       
    }
}