/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jo
 */
public class Artiste {                      //utilisé pour le type clip video 
    public Artiste(String n)
    {
        cpt++;
        id = cpt;
        nom = n;
        
    }
    public int getIdArtiste()
    {
        return this.id;
    }
    
    public String getNomArtiste()
    {
        return this.nom;
    }

    public void setNomArtiste(String nom)
    {
        this.nom = nom;
    }

    
    private String nom;
    private int cpt = 0;
    private final int id;
}