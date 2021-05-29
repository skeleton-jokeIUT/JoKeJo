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
public abstract class Musique extends Oeuvre {
    public Musique(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini, 
            CategorieMusiqueClip catP, CategorieMusiqueClip catS, int d)
    {
        super(TypeOeuvre.MSQ, art, nom, statut, a, ageMini);
        cpt++;
        ID = cpt;
        duree = d;
        categoriePrincipale = catP;
        categorieSecondaire = catS;
        
        listeMusiquesGerees.add(this);    
    }
    
    //getters
    public int getIdMusique()
    {
        return this.ID;
    }
    public int getDureeMusique()
    {
        return this.duree;
    }
    public CategorieMusiqueClip getCategoriePrincipaleMusique()
    {
        return this.categoriePrincipale;
    }
    public CategorieMusiqueClip getCategorieSecondaireMusique()
    {
        return this.categorieSecondaire;
    }
    
    public static List<String> getNomsListeMusiques (List<Musique> listeMusique)
    {
        List<String> liste = new ArrayList();
        for(Musique m: listeMusique)
        {
            liste.add(m.getNomOeuvre());
        }
        return liste;
    }
    
    //setters
    public void setDureeMusique(int d)
    {
        this.duree = d;
    }
    public void setCategoriePrincipaleMusique(CategorieMusiqueClip c)
    {
        this.categoriePrincipale = c;
    }
    public void setCategorieSecondaireMusique(CategorieMusiqueClip c)
    {
        this.categorieSecondaire = c;
    } 
    
    @Override
    public String toString()
    {
        double note2 = this.getNoteOeuvre();
        
        String str;
        str = "\nId oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Id musique: \t"+this.getIdMusique()+"\n"
                +"Titre: \t"+this.getNomOeuvre()+"\n"
                +"Interprete: \t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Categorie principale: \t"+this.getCategoriePrincipaleMusique().getNomCategorieClipMusique()+"\n"
                +"Categorie secondaire: \t"+this.getCategorieSecondaireMusique().getNomCategorieClipMusique()+"\n"               
                +"Duree: \t\t"+this.getDureeMusique()+"\n"                
                +"Annee: \t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+String.format(java.util.Locale.US,"%.1f", note2)+"\n";
        return str;
    }
    private int duree;
    private int cpt = 0;
    private final int ID;
    private CategorieMusiqueClip categoriePrincipale;
    private CategorieMusiqueClip categorieSecondaire;
    
    public static List<Musique> listeMusiquesGerees = new ArrayList(); 
}
