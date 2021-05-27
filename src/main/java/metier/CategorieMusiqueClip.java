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
public enum CategorieMusiqueClip {
    POP("Pop"),
    MTL("Metal"), 
    HIP("Hip Hop"), 
    RCK("Rock"),
    SOL("Soul"),
    JAZ("Jazz"),
    ELO("Electro"),
    BLS("Blues"),
    CTY("Country"),
    DVR("Divers");
    
    CategorieMusiqueClip(String nom)
    {
        this.nom = nom;
    }

    public static List<String> getLesCategoriesPrincipalesDeClips() 
    {
        List<String> liste = new ArrayList<>();
        
        for(CategorieMusiqueClip cat: CategorieMusiqueClip.values())
        {
            liste.add(cat.getNomCategorieClipMusique());
        }
        return liste;
    }
    
    public String getNomCategorieClipMusique()
    {
        return nom;
    }
    
    public static String convertToStringCategorieClipMusique(int i)            //conversion d'un int en String    
    {
        String s = "";
        switch(i) {
            case 0:
                s = "POP";
                break;
            case 1:
                s = "MTL";
                break;
            case 2:
                s = "HIP";
                break;
            case 3:
                s = "RCK";
                break;
            case 4:
                s = "SOL";
                break;
            case 5:
                s = "JAZ";
                break;
            case 6:
                s = "ELO";
                break;
            case 7:
                s = "BLS";
                break;
            case 8:
                s = "CTY";
            case 9:
                s = "DVR";
                break;
            default:
                System.out.println("Index categorieClip inconnu");
        }
        return s;
    }
    
    public static CategorieMusiqueClip convertToEnumCategorieClipMusique(String s)    //conversion d'une chaine String en CategorieMusiqueClip (enum)
    {
        CategorieMusiqueClip cat = null;
        switch(s) {
            case "POP":
                cat = CategorieMusiqueClip.valueOf("POP");
                break;
            case "MTL":
                cat = CategorieMusiqueClip.valueOf("MTL");
                break;
            case "HIP":
                cat = CategorieMusiqueClip.valueOf("HIP");
                break;
            case "RCK":
                cat = CategorieMusiqueClip.valueOf("RCK");
                break;
            case "SOL":
                cat = CategorieMusiqueClip.valueOf("SOL");
                break;
            case "JAZ":
                cat = CategorieMusiqueClip.valueOf("JAZ");
                break;
            case "ELO":
                cat = CategorieMusiqueClip.valueOf("ELO");
                break;
            case "BLS":
                cat = CategorieMusiqueClip.valueOf("BLS");
                break;
            case "CTY":
                cat = CategorieMusiqueClip.valueOf("CTY");
                break;
            case "DVR":
                cat = CategorieMusiqueClip.valueOf("DVR");
                break;              
            default:
                System.out.println("Categorie inconnue");
        }
        return cat;
    }
    
    
    private final String nom;
}
