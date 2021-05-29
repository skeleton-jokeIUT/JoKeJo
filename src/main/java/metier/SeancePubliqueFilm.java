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
    public SeancePubliqueFilm(String n, String d, Film...f) 
    {
        cpt++;
        ID = cpt;
        nom = n;
        listeFilms = new ArrayList();
        for(Film film: f)
        {
            listeFilms.add(film);
        }
        nbFilm = listeFilms.size();
        date = d;
        
        listeSeancesPubliquesFilms.add(this);                               //seance ajoutée à la liste des seance existantes
        
        System.out.println(listeSeancesPubliquesFilms);                     //on verifie la liste à chaque instanciantion
    }
    public int getIdSeance()
    {
        return this.ID;
    }
    
    public int getNbFilmSeance()
    {
        return this.nbFilm;
    }
    
    public String getNomSeance()
    {
        return this.nom;
    }
    
    public String getDateSeance()
    {
        return this.date;
    }
    
    public List<Film> getListeFilmSeance()
    {
        return listeFilms;
    }
    
    public List<String> getTousLesFilmsSeance()
    {
        List<String> liste = new ArrayList();
        for(Film f: listeFilms)
            liste.add(f.getNomOeuvre());
        
        return liste;
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
    
    public void setNbFilmsSeance(int n)
    {
        this.nbFilm = n;
    }
    
    public void setListeFilmsSeance(List<Film> liste)
    {
        this.listeFilms = liste;
    }
    
    public void ajouterFilmsASeance(Film...f)        //on peut ajouter un ou plusieurs films
    {
        for(Film film : f)
        {
            listeFilms.add(film);
            nbFilm = nbFilm + 1;
        }        
    }
    
    public void supprimerFilmsASeance(Film...f)        //on peut ajouter un ou plusieurs films
    {
        for(Film film : f)
        {
            listeFilms.remove(film);
            nbFilm = nbFilm - 1;
        }        
    }
    
    public void supprimerFilmASeance(SeancePubliqueFilm seance, Film...f)
    {
         for(Film film : f)
            listeFilms.remove(film);       
    }
    
    
    @Override
    public String toString()
    {
        String str;
        str =  "ID de la séance: \t"+this.getIdSeance()+"\n"
                +"Nom de la seance: \t"+this.getNomSeance()+"\n"
                +"Nombre de films: \t"+this.getNbFilmSeance()+"\n"
                +"Date de projection: \t"+this.getDateSeance()+"\n"
                +"Films projetés: \t"+this.getTousLesFilmsSeance()+"\n";       
        return str;
    }
    

            
    private static int cpt = 0 ;
    private final int ID;
    private String nom;
    private int nbFilm;
    private String date;
    private List<Film> listeFilms;
    
    public static List<SeancePubliqueFilm> listeSeancesPubliquesFilms = new ArrayList();
}
