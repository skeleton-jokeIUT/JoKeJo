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
    public Artiste(String n, TypeOeuvre t, MetierArtiste met)
    {
        cpt++;
        id = cpt;
        nom = n;
        type = t;
        metier = met;
    }
    
    //getters
    public int getIdArtiste()
    {
        return this.id;
    }
    
    public String getNomArtiste()
    {
        return this.nom;
    }
    
    public TypeOeuvre getTypeOeuvreArtiste()
    {
        return this.type;
    }
    
    public MetierArtiste getMetierArtiste()
    {
        return metier;
    }

    //setters
    public void setNomArtiste(String nom)
    {
        this.nom = nom;
    }
    
    public void setTypeOeuvreArtiste(TypeOeuvre t)
    {
        this.type = t;
    }
    
    public void setMetierArtiste(MetierArtiste m)
    {
        this.metier = m;
    }
    
    private String nom;
    private int cpt = 0;
    private final int id;
    private TypeOeuvre type;
    private MetierArtiste metier;
}