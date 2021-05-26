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
    public Film (String n, Realisateur real, String nat, int a, int d, CategorieFilm catP, CategorieFilm catS, String s)
    {
        super(TYPE_OEUVRE, n, s);               //rappel :  statut = oeuvre gratuite ou payante
        {
            cpt++;                                      //incrémenté à chaque nouveau film créé
            ID = cpt;                                   //affecte un id au film 
            nom = n;
            realisateur = real;
            nationalite = nat;
            annee = a;
            duree = d;
            categoriePrincipale = catP;
            categorieSecondaire = catS;

            //listeFilmsGeres = new ArrayList();
            listeFilmsGeres.add(this);                  //ajoute le film créé à la liste
        }   
    }
    
    //getters
    public int getIdFilm()                      //retourne l'id du film sous forme d'entier
    {
        return this.ID;
    }
    
    public Realisateur getRealisateurFilm()      //retourne le nom du realisteur sous forme de chaine de caracteres
    {
        return this.realisateur;
    }
    public String getNationalite()
    {
        return this.nationalite;
    }
    
    public int getAnneeFilm()
    {
        return this.annee;
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
    public void setAnnee(int annee)
    {
        this.annee = annee;
    }

    public void setDuree(int duree)
    {
        this.duree = duree;
    }

    public void setRealisateur(Realisateur realisateur)
    {
        this.realisateur = realisateur;
    }
    public void setNationalite(String nationalite)
    {
        this.nationalite = nationalite;
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
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"+
                "Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"+
                "Id film: \t\t"+this.getIdFilm()+"\n"+
                "Nom: \t\t"+this.getNomOeuvre()+"\n"+
                "Realisateur: \t\t"+this.getRealisateurFilm().getNomArtiste()+"\n"+
                "Categorie principale: \t"+this.getCategoriePrincipaleDuFilm().getNomCategorie()+"\n"+
                "Categorie secondaire: \t"+this.getCategorieSecondaireDufilm().getNomCategorie()+"\n"+
                "Statut: \t\t"+this.getStatutOeuvre()+"\n";
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
    private int annee, duree;                                       //duree en minutes => int
    private String nom;                                             //nom du film
    private Realisateur realisateur;                                //nom du realisateur du film
    private String nationalite;
    private CategorieFilm categoriePrincipale;                      //categorie principale du film
    private CategorieFilm categorieSecondaire;                      //categorie secondaire du film
    
    //champs statiques
    private static final TypeOeuvre TYPE_OEUVRE = TypeOeuvre.FLM;   //TypeOeuvre.valueOf(TypeOeuvre.class, "FLM");
    public static List<Film> listeFilmsGeres = new ArrayList();;    //liste statique accessbile partout + indpdte de tout objet 
}
