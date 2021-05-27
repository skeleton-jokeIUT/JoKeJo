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
public class Image extends Oeuvre {
    public Image(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini, String f)
    {
        super(TypeOeuvre.IMG, art, nom, statut, a, ageMini);
        cpt++;
        ID = cpt;
        format = f;
    }
    //getters
    public String getFormatImage()
    {
        return this.format;
    }
    public int getIdImage()
    {
        return this.ID;
    }
    
    //setter
    public void setFormatImage(String f)
    {
        this.format = f;
    }
    
    @Override
    public String toString()
    {
        String str;
        str = "\nId oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Format: \t"+this.getFormatImage()+"\n"
                +"Annee: \t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+this.getNoteOeuvre()+"\n";
        return str;
    }
            
        
    
    private int cpt = 0;
    private final int ID;
    private String format;
    
}
