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
public class Ecrit extends Oeuvre {
    public Ecrit(TypeOeuvre t, Artiste art, String nat, String nom, String statut, int annee, int ageMini, int nombreP, CategorieEcrit cat)
    {
        super(TypeOeuvre.ECR, art, nom, statut, annee, ageMini);
        nombrePages = nombreP;
        categorie = cat;
        
        listeEcritsGeres.add(this);
    }
    
    public int getNombrePagesEcrit()
    {
        return this.nombrePages;
    }
    
    public CategorieEcrit getCategorieEcrit()
    {
        return this.categorie;
    }
    
    public static List<String> getNomsListeEcrits (List<Ecrit> listeEcrit)
    {
        List<String> liste = new ArrayList();
        for(Ecrit e: listeEcrit)
        {
            liste.add(e.getNomOeuvre());
        }
        return liste;
    }
    
    public void setNombrePagesEcrit(int n)
    {
        this.nombrePages = n;
    }
    
    public void setCategorieEcrit(CategorieEcrit c )
    {
        this.categorie = c;
    }
    
    @Override
    public String toString()
    {
        double note2 = this.getNoteOeuvre();
        
        String str;
        str = "\nId oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Categorie d'écrit: "+this.getCategorieEcrit().getNomCategorieEcrit()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Annee: \t"+this.getAnneeOeuvre()+"\n"
                +"Nombre de pages: \t"+this.getNombrePagesEcrit()+"\n"
                +"Statut: \t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+String.format(java.util.Locale.US,"%.1f", note2)+"\n";
        return str;
    }
            
     
    private int nombrePages;
    private CategorieEcrit categorie;
    
    public static List<Ecrit> listeEcritsGeres = new ArrayList();
    
}
