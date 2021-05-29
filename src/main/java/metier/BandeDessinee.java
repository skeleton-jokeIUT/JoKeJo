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
public class BandeDessinee extends Ecrit {
    
    public BandeDessinee(TypeOeuvre t, Artiste art, String nat, String nom, String statut,
            int annee, int ageMini, int nombreP, CategorieEcrit cat)
    {
        super(TypeOeuvre.ECR, art, nat, nom, statut, annee, ageMini, nombreP, CategorieEcrit.BDS);
        cpt++;
        ID = cpt;
        
        listeBdGerees.add(this);
    }
    
    public int getIdBD()
    {
        return this.ID;
    }
    


    @Override
    public String toString()
    {
        double note2 = this.getNoteOeuvre();
        
        String str;
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'ecrit: \t\t"+this.getCategorieEcrit().getNomCategorieEcrit()
                +"Id BD: \t\t"+this.getIdBD()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t\t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Catégorie: \t\t"+this.getCategorieEcrit().getNomCategorieEcrit()+"\n"
                +"Annee: \t\t"+this.getAnneeOeuvre()+"\n"
                +"Nombre de pages: \t"+this.getNombrePagesEcrit()+"\n"
                +"Statut: \t\t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+String.format(java.util.Locale.US,"%.1f", note2)+"\n";
        return str;
    }    
    
    
    private int cpt = 0;
    private final int ID;
    
    public static List<BandeDessinee> listeBdGerees = new ArrayList(); 
    
}
