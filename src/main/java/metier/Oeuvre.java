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
    public Oeuvre(TypeOeuvre t, Artiste art, String nat, String nom, String statut, int a, int ageMini)
    {
        cpt++;
        ID = cpt;
        artiste = art;
        nationalite = nat;
        this.nom = nom;
        type = t;
        this.statut = statut;
        annee = a;
        age = ageMini;
        
        switch(type){                                          //metier de l'artiste initialiser en fonction du type d'eouvre
            case IMG:
                metier = MetierArtiste.DSR;
                break;
            case ECR:
                metier = MetierArtiste.ECN;
                break;
            case MSQ:
                metier = MetierArtiste.IPT;
                break;
            case CVO:
                metier = MetierArtiste.IPT;
                break;
            case FLM:
                metier = MetierArtiste.RSR;
                break;
            case JEU:
                metier = MetierArtiste.EDT;
                break;
            default:
                metier = MetierArtiste.ATE;
        }
        
        listeOeuvresGerees.add(this);                       //ajoute l'Oeuvre instanciée à la liste statique
    }
    
    //getters
    public int getIdOeuvre()
    {
        return ID;
    }
    public Artiste getArtisteOeuvre()
    {
        return artiste;
    }
    public String getNationaliteOeuvre()
    {
        return nationalite;
    }

    public String getNomOeuvre()
    {
        return nom;
    }
    
    public TypeOeuvre getTypeOeuvre()
    {
        return type;
    }
    
    
    public String getStatutOeuvre()
    {
        return this.statut;
    }
    public int getAnneeOeuvre()
    {
        return this.annee;
    }
    
    public MetierArtiste getMetierArtisteOeuvre()
    {
        return this.metier;
    }
    public int getAgeMiniOeuvre()
    {
        return this.age;
    }
    
    public List<Oeuvre> getToutesLesOeuvres()
    {
        return listeOeuvresGerees;
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
    

    
    //setters
    public void setTypeOeuvre(TypeOeuvre type)
    {
        this.type = type;
    }
    
    public void setNomOeuvre(String nom)
    {
        this.nom = nom;
    }
    public void setArtisteOeuvre(Artiste art)
    {
        this.artiste = art;
    }
    public void setNationaliteOeuvre(String nat)
    {
        this.nationalite = nat;
    }
    
    public void setStatutOeuvre(String statut)
    {
        this.statut = statut;
    }
    public void setAnneeOeuvre(int a)
    {
        this.annee = a;
    }
    public void setAgeMiniOeuvre(int a)
    {
        this.age = a;
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
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Nationalite: \t"+this.getNationaliteOeuvre()+"\n"
                +"Artiste: \t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Type d'artiste: \t"+this.getMetierArtisteOeuvre().getNomMetierArtiste()+"\n"
                +"Annee de sortie: \t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n";
        return str;
    }

    private TypeOeuvre type;
    private Artiste artiste;                                //auteur, interprete, ...
    private MetierArtiste metier;                           //metier de l'auteur (dessinateur, realisateur,...)
    private String nom;                                     //nom de l'auteur, interprete, ...
    private String nationalite;                             //pays d'origine de l'oeuvre
    private static int cpt = 0;
    private final int ID;                                   //id de l'oeuvre
    String statut;                                          //oeuvre payante, premium ou gratuite
    private int annee;                                      //annee de sortie
    private int age;

    //liste statique d'oeuvre = ensembles de toutes les oeuvres (films + clips +...)
    public static List<Oeuvre> listeOeuvresGerees = new ArrayList();    
}
