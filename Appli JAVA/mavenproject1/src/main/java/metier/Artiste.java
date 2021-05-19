/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Objects;

/**
 *
 * @author johan
 */
public class Artiste {
    
    private String nom;
    private String nationalite;

    public Artiste(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite=nationalite;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artiste other = (Artiste) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }
    
    
}
