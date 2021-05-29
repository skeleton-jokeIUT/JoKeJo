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
public class Image extends Oeuvre {
    public Image(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini, String f)
    {
        super(TypeOeuvre.IMG, art, nom, statut, a, ageMini);
        cpt++;
        ID = cpt;
        format = f;
        
        listeImagesGerees.add(this);

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
    
    public static List<String> getNomsListeImages (List<Image> listeImage)
    {
        List<String> liste = new ArrayList();
        for(Image i: listeImage)
        {
            liste.add(i.getNomOeuvre());
        }
        return liste;
    }
    
    //setter
    public void setFormatImage(String f)
    {
        this.format = f;
    }
    
    @Override
    public String toString()
    {
        double note2 = this.getNoteOeuvre();
        
        String str;
        str = "\nId de l'oeuvre: \t"+this.getIdOeuvre()+"\n"
                +"Type d'oeuvre: \t"+this.getTypeOeuvre().getNomTypeOeuvre()+"\n"
                +"Nom de l'oeuvre: \t"+this.getNomOeuvre()+"\n"
                +"Artiste: \t\t"+this.getArtisteOeuvre().getNomArtiste()+"\n"
                +"Nationalite: \t\t"+this.getArtisteOeuvre().getNationaliteArtiste()+"\n"
                +"Format: \t\t"+this.getFormatImage()+"\n"
                +"Annee: \t\t"+this.getAnneeOeuvre()+"\n"
                +"Statut: \t\t"+this.getStatutOeuvre()
                +"Age requis: \t\t"+this.getAgeMiniOeuvre()+"\n"
                +"Note moyenne: \t"+String.format(java.util.Locale.US,"%.1f", note2)+"\n";
        return str;
    }
            
        
    
    private int cpt = 0;
    private final int ID;
    private String format;
    
    public static List<Image> listeImagesGerees = new ArrayList(); 
    
}
