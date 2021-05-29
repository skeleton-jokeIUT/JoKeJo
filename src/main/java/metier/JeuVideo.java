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
public class JeuVideo extends Oeuvre {
    public JeuVideo(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini)
    {
        super(TypeOeuvre.JEU, art, nom, statut, a, ageMini);
        cpt++;
        ID = cpt;
        
        listeJeuxVideosGeres.add(this);
    }
    
    public int getIdJeuVideo()
    {
        return this.ID;
    }
    
    public static List<String> getNomsListeJeuxVideos (List<JeuVideo> listeJeu)
    {
        List<String> liste = new ArrayList();
        for(JeuVideo j: listeJeu)
        {
            liste.add(j.getNomOeuvre());
        }
        return liste;
    }
    
    private int cpt = 0;
    private final int ID;
    
    public static List<JeuVideo> listeJeuxVideosGeres = new ArrayList(); 
}
