package com.project;

import java.util.ArrayList;
import java.util.List;

public class PR450Magatzem {
    private List<PR450Producte> productes;
    private int capacitat;


    public PR450Magatzem() {
        productes = new ArrayList<>();
        capacitat = 10;

    }

    public void addProducte(PR450Producte producte) {
        if (capacitat > 0) {
            capacitat--;
            productes.add(producte);
            System.out.println("Se ha añadido el producto con id "+producte.getId()+" al magatzem, Capacidad: "+ capacitat);
  
        }
    }

    public void removeProducte(int id,PR450Entregues entregues) {
        PR450Producte removedProducte = null;
        for (PR450Producte producte : productes) {
            if (producte.getId() == id) {
                capacitat++;
                System.out.println("Se ha borrado el producto con id "+id+" al magatzem, Capacidad: "+ capacitat);
                entregues.addProducte(producte);
                removedProducte = producte;
                break;
            }
        }

        if (removedProducte != null) {
            productes.remove(removedProducte);
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Magatzem:[");
        for (PR450Producte producte : productes) {
            result.append(producte.getId()).append(" : ").append(producte.getNom()).append(","); 
        }
        result.delete(result.length()-1, result.length());
        result.append("]");
        return result.toString();
    }
}