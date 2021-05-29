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
    public Artiste(String n, String nat,TypeOeuvre t, MetierArtiste met)
    {
        cpt++;
        id = cpt;
        nom = n;
        nationalite = nat;
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
    public String getNationaliteArtiste()
    {
        return this.nationalite;
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
    public void setNationaliteArtiste(String n)
    {
        this.nationalite = n;
    }
    
    @Override
    public String toString()
    {
        String str;
        str = "\nId artiste: \t"+this.getIdArtiste()+"\n"
                +"Nom: \t\t"+this.getNomArtiste()+"\n"
                +"Nationalité: \t\t"+this.getNationaliteArtiste()+"\n"
                +"Metier: \t\t"+this.getMetierArtiste().getNomMetierArtiste()
                +"Type d'oeuvre: \t"+this.getTypeOeuvreArtiste().getNomTypeOeuvre()+"\n";
        return str;
    }

    
    private String nom;
    private int cpt = 0;
    private final int id;
    private String nationalite;
    private TypeOeuvre type;
    private MetierArtiste metier;
}