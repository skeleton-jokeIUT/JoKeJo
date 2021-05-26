/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author jo
 */
public abstract class Oeuvre {
    public Oeuvre(TypeOeuvre t, String n, String s)
    {
        cpt++;
        ID = cpt;
        nom = n;
        type = t;
        statut = s;                                         //false => oeuvre payante, true => oeuvre gratuite
        
        listeOeuvresGerees.add(this);                       //ajoute l'Oeuvre instanciée à la liste statique
    }
    
    //getters
    public int getIdOeuvre()
    {
        return ID;
    }

    public String getNomOeuvre()
    {
        return nom;
    }
    
    public List<Oeuvre> getToutesLesOeuvres()
    {
        return listeOeuvresGerees;
    }
    
    public TypeOeuvre getTypeOeuvre()
    {
        return type;
    }
    
    public String getNomTypeOeuvre()
    {
        return type.getNomTypeOeuvre();     //??
    }
    
    public String getStatutOeuvre()
    {
        return this.statut;
    }
    
    //setters
    public void setType(TypeOeuvre type)
    {
        this.type = type;
    }
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    public void setStatut(String statut)
    {
        this.statut = statut;
    }

    public static List<String> getNomsListeOeuvres(List<Oeuvre> listeOeuvre)
    {
        List<String> liste = new ArrayList();
        for(Oeuvre o: listeOeuvre)
        {
            liste.add(o.getNomOeuvre());
        }
        return liste;
    }
    
    
    public static void afficheToutesLesOeuvresGerees()       //parcourt et affiche la liste des films
    {
        System.out.println(listeOeuvresGerees.toString());
    }
    
    @Override
    public String toString()
    {
        String str;
        str = "\nId oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getNomTypeOeuvre()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Statut: \t"+this.getStatutOeuvre();
        return str;
    }

    private TypeOeuvre type;
    private String nom;
    private static int cpt = 0;
    private final int ID;
    String statut;                                         //oeuvre payante ou gratuite
    
    //liste statique d'oeuvre = ensembles de toutes les oeuvres (films + clips +...)
    public static List<Oeuvre> listeOeuvresGerees = new ArrayList();    
}
