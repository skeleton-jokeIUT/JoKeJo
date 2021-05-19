/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author johan
 */
public class Film extends Oeuvre {
    
    private final static TypeOeuvre type = TypeOeuvre.FIL;
    private CategorieFilm categoriePrincipale;
    private CategorieFilm categorieSecondaire;
    private Artiste realisateur;
    private Artiste acteur;
    private int annee;
    private String duree;
    private static ArrayList<Film> listeFilm = new ArrayList<>();
    
    public static final Comparator<Film> COMPARATOR_CAT = new Comparator<Film>(){
        @Override
        public int compare(Film f1, Film f2){
            return f1.getCategoriePrincipale().compareTo(f2.getCategoriePrincipale());
        }
    };
    
  

    public Film(String titre, int age, float prixAchat, float prixLoc, CategorieFilm  categoriePrincipale, CategorieFilm  categorieSecondaire, Artiste realisateur, Artiste acteur, int annee, String duree) {
        super(titre, age, prixAchat, prixLoc);
        this.categoriePrincipale = categoriePrincipale;
        this.categorieSecondaire = categorieSecondaire;
        this.realisateur =realisateur;
        this.acteur = acteur;
        this.annee=annee;
        this.duree=duree;
        
        listeFilm.add(this);
        
    }

    @Override
    public String toString() {
        String str=super.toString();
        return "Film : "+ str + "\ncategoriePrincipale = " + categoriePrincipale.getNomCat() + "\ncategorieSecondaire = " + categorieSecondaire.getNomCat() + "\nRealisateur = " + realisateur.getNom() + "\nActeurs = " + acteur.getNom();
    }
    
    @Override
    public boolean equals(Object film){
        
        if(this==film) return true;
        if(this.getClass()!=film.getClass()) return false;
        if(film==null) return false;
        
        Film f = (Film)film;
        
        if(super.equals(film)){
            return(this.categoriePrincipale.equals(f.categoriePrincipale)
                    && this.categorieSecondaire.equals(f.categorieSecondaire)
                    &&this.realisateur.equals(f.realisateur)
                    &&this.acteur.equals(f.acteur));
        }
        else return false; 
    }
    
    
    
    
    public static ArrayList<Film> getFilmParCategoriePrincipale(CategorieFilm cat){
        
        Iterator<Film> iter = listeFilm.iterator();
        
        ArrayList<Film> filmParCategorie = new ArrayList<>();
        
        while(iter.hasNext()){
            
           Film f= iter.next();
           
           if(f.getCategoriePrincipale().equals(cat)){
               
               filmParCategorie.add(f);
               
           } 
            
        }
        
        return filmParCategorie;
        
    }

    public int getAnnee() {
        return annee;
    }

    public String getDuree() {
        return duree;
    }
    
    public void setCategoriePrincipale(CategorieFilm categoriePrincipale) {
        this.categoriePrincipale = categoriePrincipale;
    }

    public void setCategorieSecondaire(CategorieFilm categorieSecondaire) {
        this.categorieSecondaire = categorieSecondaire;
    }

    public void setMusiciens(Artiste acteur) {
        this.acteur = acteur;
    }

    public void setCompositeur(Artiste realisateur) {
        this.realisateur = realisateur;
    }

    public static void setListeFilm(ArrayList<Film> listeFilm) {
        Film.listeFilm = listeFilm;
    }
    

    public static TypeOeuvre getType() {
        return type;
    }

    public CategorieFilm getCategoriePrincipale() {
        return categoriePrincipale;
    }

    public CategorieFilm getCategorieSecondaire() {
        return categorieSecondaire;
    }

    public Artiste getActeur() {
        return acteur;
    }

    public Artiste getRealisateur() {
        return realisateur;
    }

    public static ArrayList<Film> getListeFilm() {
        return listeFilm;
    }
     
    
    
    
    
    
    
    
}
