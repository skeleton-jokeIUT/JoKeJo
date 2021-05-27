/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jo
 */
public class Film extends Oeuvre {
    public Film (String n, Artiste art, int a, int d, CategorieFilm catP, CategorieFilm catS, String s, int age)
    {
        super(TypeOeuvre.FLM, art, n, s, a, age);               //rappel :  statut = oeuvre gratuite ou payante
        {
            cpt++;                                      //incrémenté à chaque nouveau film créé
            ID = cpt;                                   //affecte un id au film 
            duree = d;
            categoriePrincipale = catP;
            categorieSecondaire = catS;

            listeFilmsGeres.add(this);                  //ajoute le film créé à la liste
        }   
    }
    
    //getters
    public int getIdFilm()                              //retourne l'id du film sous forme d'entier
    {
        return this.ID;
    }
    
    public int getDureeFilm()                           //duree en minutes
    {    
        return this.duree;
    }

    public CategorieFilm getCategoriePrincipaleDuFilm()             //retourne la categorie principale du film
    {
        return this.categoriePrincipale;
    }
    
    
    public CategorieFilm getCategorieSecondaireDufilm()             //retourne la categorie secondaire du film
    {
        return categorieSecondaire;
    }

    public static List<Film> getTousLesFilmsGeres()                 //retourne la liste de tous les films ajoutés à la liste
    {
        return listeFilmsGeres;
    }
    
    public static void afficheTousLesFilmsGeres()       //parcourt et affiche la liste des films (affiche uniquement leur nom)
    {
        System.out.println(listeFilmsGeres.toString());
    }
    
    public static int getNbFilms()                      //(non demandé) retourne le nb total de films
    {
        return cpt;
    }
    
    //setters
    public void setDureeFilm(int duree)
    {
        this.duree = duree;
    }

    public void setCategoriePrincipale(CategorieFilm categoriePrincipale)
    {
        this.categoriePrincipale = categoriePrincipale;
    }

    public void setCategorieSecondaire(CategorieFilm categorieSecondaire)
    {
        this.categorieSecondaire = categorieSecondaire;
    }
    
    @Override
    public String toString()                    //affiche le film et ses caracteristiques
    {
        String str;
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Id film: \t\t"+this.getIdFilm()+"\n"
                +"Titre: \t\t"+this.getNomOeuvre()+"\n"
                +"Realisateur: \t\t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalité: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Categorie principale: \t"+this.getCategoriePrincipaleDuFilm().getNomCategorieFilm()+"\n"
                +"Categorie secondaire: \t"+this.getCategorieSecondaireDufilm().getNomCategorieFilm()+"\n"
                +"Duree: \t\t"+this.getDureeFilm()+"\n"
                +"Annee: \t\t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t\t"+this.getStatutOeuvre()+"\n"
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+this.getNoteOeuvre();
        return str;
    }
    
    /*@Override
    public int compareTo(String str)        //à redefinir??
    {
        return 0;
    }*/
    
    public static final Comparator<Film> CATEGORIE_COMPARATOR = new Comparator<Film>() {
        @Override
        public int compare(Film p, Film q)      //compare les categories de 2 films passsés en paramètres
        {
            return p.getCategoriePrincipaleDuFilm().compareTo(q.getCategoriePrincipaleDuFilm());
        }
    };
    
    public static List<Film> getFilmsParCategoriePrincipale(CategorieFilm cat)
    {
        List<Film> liste = new ArrayList();                         //contiendra tous les films de la catégorie passée en paramètre
        Film f;
        Collections.sort(listeFilmsGeres, Film.CATEGORIE_COMPARATOR);       //trie les films par categorie
        Iterator<Film> iter = listeFilmsGeres.iterator();           //declaration d'itérateur pr parcourir la liste de films
        while(iter.hasNext())                                       //tant que la position courante dispose d'une position suivante
        {
            f = iter.next();
            while(f.getCategoriePrincipaleDuFilm() == cat)          //ajoute à la liste les films de la categorie passée en paramètre 
            {
                liste.add(f);
            } 
        }
        return liste;
    }
    

    private static int cpt=0;                                       //incrémenté à chq nv film instancié => nb total de films
    private final int ID;                                           //id du film
    private int duree;                                              //duree en minutes => int
    private CategorieFilm categoriePrincipale;                      //categorie principale du film
    private CategorieFilm categorieSecondaire;                      //categorie secondaire du film
    
    public static List<Film> listeFilmsGeres = new ArrayList();;    //liste statique accessbile partout + indpdte de tout objet 
}
