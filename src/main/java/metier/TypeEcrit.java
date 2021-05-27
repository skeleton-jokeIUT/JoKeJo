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
public enum TypeEcrit {
    LVR("Livre"),
    BDS("Bande dessinée"), 
    MGA("Manga"), 
    DVR("Divers");
    
    TypeEcrit(String nom)
    {
        this.nom = nom;
    }

    public static List<String> getLesCategoriesEcrits() 
    {
        List<String> liste = new ArrayList<>();
        
        for(TypeEcrit cat: TypeEcrit.values())
        {
            liste.add(cat.getNomCategorieEcrit());
        }
        return liste;
    }
    
    public String getNomCategorieEcrit()
    {
        return nom;
    }
     public static TypeEcrit convertToEnumCategorieEcrit(String s)    //conversion d'une chaine String en CategorieFilm (enum)
    {
        TypeEcrit cat = null;
        switch(s) {
            case "LVR":
                cat = TypeEcrit.valueOf("LVR");
                break;
            case "BDS":
                cat = TypeEcrit.valueOf("BDS");
                break;
            case "MGA":
                cat = TypeEcrit.valueOf("MGA");
                break;
            case "DVR":
                cat = TypeEcrit.valueOf("DVR");
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
