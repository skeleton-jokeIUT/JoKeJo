/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author johan
 */
public class Musique extends Oeuvre {
    
    private final static TypeOeuvre type = TypeOeuvre.MUS;
    private Artiste compositeur;
    private Artiste musiciens;
    private String Parole; 
    private CategorieMusique categoriePrincipale;
    private CategorieMusique categorieSecondaire;
    private static ArrayList<Musique> listeMusique = new ArrayList<>();
    
    public static final Comparator<Musique> COMPARATOR_CAT = new Comparator<Musique>(){
        @Override
        public int compare(Musique m1, Musique m2){
            return m1.getCategoriePrincipale().compareTo(m2.getCategoriePrincipale());
        }
    }; 

    public Musique(String titre, int age, float prixAchat, float prixLoc, CategorieMusique  categoriePrincipale, CategorieMusique  categorieSecondaire, Artiste compositeur, Artiste musiciens) {
        
        super(titre, age, prixAchat, prixLoc);
        
        this.categoriePrincipale = categoriePrincipale;
        this.categorieSecondaire = categorieSecondaire;
        this.compositeur =compositeur;
        this.musiciens = musiciens;
        
        listeMusique.add(this);
        
    }
    
    @Override
    public String toString() {
        String str=super.toString();
        return "Film : "+ str + "\ncategoriePrincipale = " + categoriePrincipale.getNomCat() + "\ncategorieSecondaire = " + categorieSecondaire.getNomCat() + "\nCompositeur = " + compositeur + "\nMusiciens = " + musiciens;
    }
    
    @Override
    public boolean equals(Object musique){
        
        if(this==musique) return true;
        if(this.getClass()!=musique.getClass()) return false;
        if(musique==null) return false;
        
        Musique m = (Musique)musique;
        
        if(super.equals(musique)){
            return(this.categoriePrincipale.equals(m.categoriePrincipale)
                    && this.categorieSecondaire.equals(m.categorieSecondaire)
                    &&this.compositeur.equals(m.compositeur)
                    &&this.musiciens.equals(m.musiciens));
        }
        else return false; 
    }
    
    public static ArrayList<Musique> getFilmParCategoriePrincipale(CategorieMusique cat){
        
        Iterator<Musique> iter = listeMusique.iterator();
        
        ArrayList<Musique> MusiqueParCategorie = new ArrayList<>();
        
        while(iter.hasNext()){
            
           Musique m= iter.next();
           
           if(m.getCategoriePrincipale().equals(cat)){
               
               MusiqueParCategorie.add(m);
               
           } 
            
        }
        
        return MusiqueParCategorie;
        
    }

    public void setCompositeur(Artiste compositeur) {
        this.compositeur = compositeur;
    }

    public void setMusiciens(Artiste musiciens) {
        this.musiciens = musiciens;
    }

    public void setParole(String Parole) {
        this.Parole = Parole;
    }

    public void setCategoriePrincipale(CategorieMusique categoriePrincipale) {
        this.categoriePrincipale = categoriePrincipale;
    }

    public void setCategorieSecondaire(CategorieMusique categorieSecondaire) {
        this.categorieSecondaire = categorieSecondaire;
    }

    public static void setListeMusique(ArrayList<Musique> listeMusique) {
        Musique.listeMusique = listeMusique;
    }

    public static TypeOeuvre getType() {
        return type;
    }

    public Artiste getCompositeur() {
        return compositeur;
    }

    public Artiste getMusiciens() {
        return musiciens;
    }

    public String getParole() {
        return Parole;
    }

    public CategorieMusique getCategoriePrincipale() {
        return categoriePrincipale;
    }

    public CategorieMusique getCategorieSecondaire() {
        return categorieSecondaire;
    }

    public static ArrayList<Musique> getListeMusique() {
        return listeMusique;
    }

    public static Comparator<Musique> getCOMPARATOR_CAT() {
        return COMPARATOR_CAT;
    }
    
    
    
}
