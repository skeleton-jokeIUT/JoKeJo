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
public class ClipVideo extends Oeuvre {
    public ClipVideo (String n, Artiste art, String nat, int a, int d, CategorieClip catP, CategorieClip catS, String s, int age)
    {
        super(TYPE_OEUVRE, art, nat, n, s, a, age);
        {
            cpt++;                                      //incrémenté à chaque nouveau clip créé
            ID = cpt;                                   //affecte un id au clip 
            duree = d;
            categoriePrincipale = catP;
            categorieSecondaire = catS;
            
            listeClipsGeres.add(this);                  //ajoute le clip instancié à la liste de clip (et donc à la liste d'oeuvres)
        }   
    }
    
    //getters
    public int getIdClip()
    {
        return ID;
    }

    public int getDureeClip()
    {
        return duree;
    }

    public CategorieClip getCategoriePrincipaleDuClip()
    {
        return categoriePrincipale;
    }

    public CategorieClip getCategorieSecondaireDuClip()
    {
        return categorieSecondaire;
    }
    
    //setters
    public void setDureeClip(int duree)
    {
        this.duree = duree;
    }

    public void setCategoriePrincipale(CategorieClip categoriePrincipale)
    {
        this.categoriePrincipale = categoriePrincipale;
    }

    public void setCategorieSecondaire(CategorieClip categorieSecondaire)
    {
        this.categorieSecondaire = categorieSecondaire;
    }
    
    public static void afficheTousLesClipsGeres()
    {
        System.out.println(listeClipsGeres.toString());
    }
    
    @Override
    public String toString()
    {
        String str;
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"+
                "Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"+
                "Id clip: \t\t"+this.getIdClip()+"\n"+
                "Nom: \t\t"+this.getNomOeuvre()+"\n"+
                "Artiste: \t\t"+this.getArtisteOeuvre().getNomArtiste()+"\n"+
                "Categorie principale: \t"+this.getCategoriePrincipaleDuClip().getNomCategorieClip()+"\n"+
                "Categorie secondaire: \t"+this.getCategorieSecondaireDuClip().getNomCategorieClip()+"\n"+
                "Annee: \t\t"+this.getAnneeOeuvre()+"\n"+
                "Duree: \t\t"+this.getDureeClip()+"\n"+
                "Statut: \t\t"+this.getStatutOeuvre()+"\n"+
                "Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n";
        return str;
    }
    
    /*@Override
    public int compareTo(String str)        //à redefinir??
    {
        return 0;
    }*/
    
    
    
    public static final Comparator<ClipVideo> CATEGORIE_CLIP_COMPARATOR = new Comparator<ClipVideo>() {
        @Override
        public int compare(ClipVideo t, ClipVideo t1)       //compare les categories de 2 clips passsés en paramètres
        {
            return t.getCategoriePrincipaleDuClip().compareTo(t1.getCategoriePrincipaleDuClip()); //throw new UnsupportedOperationException)"Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    public static List<ClipVideo> getClipsParCategoriePrincipale(CategorieClip cat)
    {
        List<ClipVideo> liste = new ArrayList();                         //contiendra tous les clips de la catégorie passée en paramètre
        ClipVideo c;
        Collections.sort(listeClipsGeres, ClipVideo.CATEGORIE_CLIP_COMPARATOR);       //trie les clips par categorie
        Iterator<ClipVideo> iter = listeClipsGeres.iterator();      //declaration d'itérateur pr parcourir la liste de films
        while(iter.hasNext())                                       //tant que la position courante dispose d'une position suivante
        {
            c = iter.next();
            while(c.getCategoriePrincipaleDuClip() == cat)          //ajoute à la liste les clips de la categorie passée en paramètre 
            {
                liste.add(c);
            }
        }
        return liste;
    }
    
    
    private static int cpt = 0;                                     //incrémenté à chq nv clip instancié => nb total de clips
    private final int ID;                                           //id du clip
    private int duree;                                       //duree en minutes => int
    private CategorieClip categoriePrincipale;                      //categorie principale du clip    private String nom;                                             //nom du clip
    private CategorieClip categorieSecondaire;                      //categorie secondaire
    
    //champs statiques
    private static final TypeOeuvre TYPE_OEUVRE = TypeOeuvre.CVO;
    public static List<ClipVideo> listeClipsGeres = new ArrayList();; 
}
