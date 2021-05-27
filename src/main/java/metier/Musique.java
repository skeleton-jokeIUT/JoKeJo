/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jo
 */
public class Musique extends Oeuvre {
    public Musique(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini, 
            CategorieMusiqueClip catP, CategorieMusiqueClip catS, int d)
    {
        super(TypeOeuvre.MSQ, art, nom, statut, a, ageMini);
        cpt++;
        ID = cpt;
        duree = d;
        categoriePrincipale = catP;
        categorieSecondaire = catS;
        
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
                +"Note moyenne: \t"+this.getNoteOeuvre()+"\n";
        return str;
    }
    private int duree;
    private int cpt = 0;
    private final int ID;
    private CategorieMusiqueClip categoriePrincipale;
    private CategorieMusiqueClip categorieSecondaire;
}
