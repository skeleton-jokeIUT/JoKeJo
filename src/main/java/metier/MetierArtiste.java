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
public enum MetierArtiste {
    
    RSR("Realisateur"),
    ECN("Ecrivain"),
    DSR("Dessinateur"),
    IPT("Interprete"),
    EDT("Editeur"),
    ATE("Autre");
    
    MetierArtiste(String nom)
    {
        this.nom = nom;
    }
    
    public String getNomMetierArtiste()
    {
        return this.nom;
    }
    
    public static List<String> getTousLesMetiers()
    {
        List<String> liste = new ArrayList();
        
        for(MetierArtiste metier: MetierArtiste.values())
        {
            liste.add(metier.getNomMetierArtiste());
        }
        return liste;        
    }
    
    private final String nom;
}
