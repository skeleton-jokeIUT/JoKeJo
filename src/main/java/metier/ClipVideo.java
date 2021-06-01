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
public class ClipVideo extends Musique {
    public ClipVideo (String n, Artiste art, int a, int d, CategorieMusiqueClip catP, CategorieMusiqueClip catS, String s, int age)
    {
        super(TypeOeuvre.CVO, art, n, s, a, age, catP, catS, d);
        {
            cpt++;                                      //incrémenté à chaque nouveau clip créé
            ID = cpt;                                   //affecte un id au clip 
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

    public static List<String> getNomsListeClips (List<ClipVideo> listeClip)
    {
        List<String> liste = new ArrayList();
        for(ClipVideo c: listeClip)
        {
            liste.add(c.getNomOeuvre());
        }
        return liste;
    }
    
    //setters
    public void setDureeClip(int duree)
    {
        this.duree = duree;
    }

    public void setCategoriePrincipale(CategorieMusiqueClip categoriePrincipale)
    {
        this.categoriePrincipale = categoriePrincipale;
    }

    public void setCategorieSecondaire(CategorieMusiqueClip categorieSecondaire)
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
        double note2 = this.getNoteOeuvre();
        
        String str;
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Id clip: \t\t"+this.getIdClip()+"\n"
                +"Titre: \t\t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t\t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalité: \t\t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Categorie principale: \t"+this.getCategoriePrincipaleMusique().getNomCategorieClipMusique()+"\n"
                +"Categorie secondaire: \t"+this.getCategorieSecondaireMusique().getNomCategorieClipMusique()+"\n"
                +"Duree: \t\t"+this.getDureeMusique()+"\n"
                +"Annee: \t\t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t\t"+this.getStatutOeuvre()+"\n"
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+String.format(java.util.Locale.US,"%.1f", note2)+"\n";
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
            return t.getCategoriePrincipaleMusique().compareTo(t1.getCategoriePrincipaleMusique()); //throw new UnsupportedOperationException)"Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    public static List<ClipVideo> getClipsParCategoriePrincipale(CategorieMusiqueClip cat)
    {
        List<ClipVideo> liste = new ArrayList();                         //contiendra tous les clips de la catégorie passée en paramètre
        ClipVideo c;
        Collections.sort(listeClipsGeres, ClipVideo.CATEGORIE_CLIP_COMPARATOR);       //trie les clips par categorie
        Iterator<ClipVideo> iter = listeClipsGeres.iterator();      //declaration d'itérateur pr parcourir la liste de films
        while(iter.hasNext())                                       //tant que la position courante dispose d'une position suivante
        {
            c = iter.next();
            while(c.getCategoriePrincipaleMusique() == cat)          //ajoute à la liste les clips de la categorie passée en paramètre 
            {
                liste.add(c);
            }
        }
        return liste;
    }
    

    
    private static int cpt = 0;                                     //incrémenté à chq nv clip instancié => nb total de clips
    private final int ID;                                           //id du clip
    private int duree;                                              //duree en minutes => int
    private CategorieMusiqueClip categoriePrincipale;                      //categorie principale du clip    private String nom;                                             //nom du clip
    private CategorieMusiqueClip categorieSecondaire;                      //categorie secondaire
    
    public static List<ClipVideo> listeClipsGeres = new ArrayList();
    
    
}
