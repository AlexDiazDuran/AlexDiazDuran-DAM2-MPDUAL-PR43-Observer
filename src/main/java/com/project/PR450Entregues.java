package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class PR450Entregues {
    private List<PR450Producte> productes;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public PR450Entregues() {
        productes = new ArrayList<>();
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        llistaObservers.firePropertyChange("entreguesAdd", null, producte);
    }

    public void removeProducte(int id) {
        PR450Producte removedProduct = null;
        for (PR450Producte producte : productes) {
            if (producte.getId() == id) {
                removedProduct = producte;
                productes.remove(producte);
                propertyChangeSupport.firePropertyChange("entreguesRemove", null, removedProduct.getId());
                break;
            }
        }
        if (removedProduct == null) {
            System.out.println("Producte amb ID " + id + " no trobat a les entregues.");
        }
    }

     private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(10);
    // funciones de propertyChangeSupport
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Entregues:[");
        for (PR450Producte producte : productes) {
            result.append(producte.getId()).append(" : ").append(producte.getNom()).append(",");
        }
        result.delete(result.length()-1, result.length());
        result.append("]");
        return result.toString();
    }
}

