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
public class BandeDessinee extends Ecrit {
    public BandeDessinee(TypeOeuvre t, Artiste art, String nat, String nom, String statut,
            int annee, int ageMini, int nombreP, TypeEcrit cat)
    {
        super(TypeOeuvre.ECR, art, nat, nom, statut, annee, ageMini, nombreP, TypeEcrit.BDS);
        cpt++;
        ID = cpt;
    }
    
    public int getIdBD()
    {
        return this.ID;
    }
    


    @Override
    public String toString()
    {
        String str;
        str = "\nId oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Type d'ecrit: \t"+this.getCategorieEcrit().getNomCategorieEcrit()
                +"Id BD: \t\t"+this.getIdBD()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Categorie: \t"+this.getCategorieEcrit().getNomCategorieEcrit()+"\n"
                +"Annee: \t"+this.getAnneeOeuvre()+"\n"
                +"Nombre de pages: \t"+this.getNombrePagesEcrit()+"\n"
                +"Statut: \t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+this.getNoteOeuvre()+"\n";
        return str;
    }    
    
    
    private int cpt = 0;
    private final int ID;
    
}
