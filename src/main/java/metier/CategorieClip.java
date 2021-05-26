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
public enum CategorieClip {
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
    
    CategorieClip(String nom)
    {
        this.nom = nom;
    }

    public static List<String> getLesCategoriesPrincipalesDeClips() 
    {
        List<String> liste = new ArrayList<>();
        
        for(CategorieClip cat: CategorieClip.values())
        {
            liste.add(cat.getNomCategorieClip());
        }
        return liste;
    }
    
    public String getNomCategorieClip()
    {
        return nom;
    }
    
    public static String convertToStringCategorieClip(int i)            //conversion d'un int en String    
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
    
    public static CategorieClip convertToEnumCategorieClip(String s)    //conversion d'une chaine String en CategorieClip (enum)
    {
        CategorieClip cat = null;
        switch(s) {
            case "POP":
                cat = CategorieClip.valueOf("POP");
                break;
            case "MTL":
                cat = CategorieClip.valueOf("MTL");
                break;
            case "HIP":
                cat = CategorieClip.valueOf("HIP");
                break;
            case "RCK":
                cat = CategorieClip.valueOf("RCK");
                break;
            case "SOL":
                cat = CategorieClip.valueOf("SOL");
                break;
            case "JAZ":
                cat = CategorieClip.valueOf("JAZ");
                break;
            case "ELO":
                cat = CategorieClip.valueOf("ELO");
                break;
            case "BLS":
                cat = CategorieClip.valueOf("BLS");
                break;
            case "CTY":
                cat = CategorieClip.valueOf("CTY");
                break;
            case "DVR":
                cat = CategorieClip.valueOf("DVR");
                break;              
            default:
                System.out.println("Categorie inconnue");
        }
        return cat;
    }
    
    
    private final String nom;
}
