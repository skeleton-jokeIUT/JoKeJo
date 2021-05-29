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
public enum CategorieEcrit {
    LVR("Livre"),
    BDS("Bande dessinée"), 
    MGA("Manga"), 
    DVR("Divers");
    
    CategorieEcrit(String nom)
    {
        this.nom = nom;
    }

    public static List<String> getLesCategoriesEcrits() 
    {
        List<String> liste = new ArrayList<>();
        
        for(CategorieEcrit cat: CategorieEcrit.values())
        {
            liste.add(cat.getNomCategorieEcrit());
        }
        return liste;
    }
    
    public String getNomCategorieEcrit()
    {
        return nom;
    }
     public static CategorieEcrit convertToEnumCategorieEcrit(String s)    //conversion d'une chaine String en CategorieFilm (enum)
    {
        CategorieEcrit cat = null;
        switch(s) {
            case "LVR":
                cat = CategorieEcrit.valueOf("LVR");
                break;
            case "BDS":
                cat = CategorieEcrit.valueOf("BDS");
                break;
            case "MGA":
                cat = CategorieEcrit.valueOf("MGA");
                break;
            case "DVR":
                cat = CategorieEcrit.valueOf("DVR");
                break;
            default:
                System.out.println("Categorie inconnue");
        }
        return cat;
    }
    
    public static String convertToStringCategorieEcrit(int i)            //conversion d'un int en String
    {
        String s = "";
        switch(i) {
            case 0:
                s = "LVR";
                break;
            case 1:
                s = "BDS";
                break;
            case 2:
                s = "MGA";
                break;
            case 3:
                s = "DVR";
                break;
            default:
                System.out.println("Index CategorieFilm inconnu");
        }
        return s; 
    }

    
    private final String nom;
}
