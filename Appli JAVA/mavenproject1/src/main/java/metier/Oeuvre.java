/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class Oeuvre implements Comparable{
    
    private int idOeuvre;
    private static int idMax=1;
    private String titre;
    private int ageAcces;
    private float prixAchat;
    private float prixLocation;
    private String cheminAcces;
    private String Miniature;
    private ArrayList<Oeuvre> listeOeuvre= new ArrayList<>();
    
    
    public Oeuvre(String titre, int age, float prixAchat, float prixLoc){
        
        this.idOeuvre=idMax;
        idMax++;
        
        this.titre=titre;
        this.ageAcces=age;
        this.prixAchat=prixAchat;
        this.prixLocation=prixLoc;
        
        listeOeuvre.add(this);
        
    }
    

    @Override
    public String toString() {
        return "\nidOeuvre = " + idOeuvre + "\ntitre = " + titre + "\nageAcces = " + ageAcces + "\nprixAchat = " + prixAchat + "\nprixLocation = " + prixLocation + "\ncheminAcces = " + cheminAcces + "\nMiniature = " + Miniature;
    }
    
    /**
     *
     * @param oeuvre
     * @return
     */
    @Override
    public boolean equals(Object oeuvre){
        
        if(this==oeuvre) return true;
        if(this.getClass()!=oeuvre.getClass()) return false;
        if(oeuvre==null) return false;
        
        Oeuvre o = (Oeuvre)oeuvre;
        
        return (this.titre==o.titre 
                && this.ageAcces==o.ageAcces 
                && this.prixAchat==o.prixAchat 
                 && this.prixLocation==o.prixLocation);
    }
    
    @Override
    public int compareTo(Object oeuvre) {
        
        Oeuvre o=(Oeuvre)oeuvre;
        
        return (this.titre.compareTo(o.titre));
        
    }
    
    
    

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public int getIdMax() {
        return idMax;
    }

    public String getTitre() {
        return titre;
    }


    public int getAgeAcces() {
        return ageAcces;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public float getPrixLocation() {
        return prixLocation;
    }

    public String getCheminAcces() {
        return cheminAcces;
    }

    public String getMiniature() {
        return Miniature;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public void setIdMax(int idMax) {
        this.idMax = idMax;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAgeAcces(int ageAcces) {
        this.ageAcces = ageAcces;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }

    public void setCheminAcces(String cheminAcces) {
        this.cheminAcces = cheminAcces;
    }

    public void setMiniature(String Miniature) {
        this.Miniature = Miniature;
    }

    
   
}
