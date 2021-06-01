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
public class SeancePubliqueFilm {
    public SeancePubliqueFilm(String n, String d, Film f) 
    {
        cpt++;
        ID = cpt;
        nom = n;
        film = f;
        date = d;
        
        listeSeancesPubliquesFilms.add(this);                               //seance ajoutée à la liste des seance existantes
        
        System.out.println(listeSeancesPubliquesFilms);                     //on verifie la liste à chaque instanciantion
    }
    public int getIdSeance()
    {
        return this.ID;
    }
    
    public String getNomSeance()
    {
        return this.nom;
    }
    
    public String getDateSeance()
    {
        return this.date;
    }
    
    public Film getFilmSeance()
    {
        return film;
    }

    
    public static List<String> getToutesLesSeancesPubliques()
    {
        List<String> liste = new ArrayList();
        
        for(SeancePubliqueFilm seance : listeSeancesPubliquesFilms)
            liste.add(seance.getNomSeance());
        
        return liste;   
    }
        
    public void setNomSeance(String s)
    {
        this.nom = s;
    }
    
    public void setDateSeance(String s)
    {
        this.date = s;
    }
    
    public void setFilmSeance(Film f)
    {
        this.film = f;
    }
    
    
    
    @Override
    public String toString()
    {
        String str;
        str =  "\nID de la séance: \t"+this.getIdSeance()+"\n"
                +"Nom de la seance: \t"+this.getNomSeance()+"\n"
                +"Date de projection: \t"+this.getDateSeance()+"\n"
                +"Film projeté: \t\t"+this.getFilmSeance().getNomOeuvre()+"\n";       
        return str;
    }
    

            
    private static int cpt = 0 ;
    private final int ID;
    private String nom;
    private String date;
    private Film film;
    
    public static List<SeancePubliqueFilm> listeSeancesPubliquesFilms = new ArrayList();
}
