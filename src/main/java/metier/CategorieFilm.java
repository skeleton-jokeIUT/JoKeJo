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
public enum CategorieFilm {
    THR("Thriller"),
    WSN("Western"), 
    HOR("Horreur"), 
    GSR("Ganster"),
    CDI("Comédie"),
    ACT("Action"),
    IFR("Inspiré de faits réels"),
    SFI("Science Fiction"),
    DVR("Divers");
    
    CategorieFilm(String nom)
    {
        this.nom = nom;
    }

    public static List<String> getLesCategoriesPrincipalesDeFilms() 
    {
        List<String> liste = new ArrayList<>();
        
        for(CategorieFilm cat: CategorieFilm.values())
        {
            liste.add(cat.getNomCategorieFilm());
        }
        return liste;
    }
    
    public String getNomCategorieFilm()
    {
        return nom;
    }
    
    public static CategorieFilm convertToEnumCategorieFilm(String s)    //conversion d'une chaine String en CategorieFilm (enum)
    {
        CategorieFilm cat = null;
        switch(s) {
            case "THR":
                cat = CategorieFilm.valueOf("THR");
                break;
            case "WSN":
                cat = CategorieFilm.valueOf("WSN");
                break;
            case "HOR":
                cat = CategorieFilm.valueOf("HOR");
                break;
            case "GSR":
                cat = CategorieFilm.valueOf("GSR");
                break;
            case "CDI":
                cat = CategorieFilm.valueOf("CDI");
                break;
            case "ACT":
                cat = CategorieFilm.valueOf("ACT");
                break;
            case "IFR":
                cat = CategorieFilm.valueOf("IFR");
                break;
            case "SFI":
                cat = CategorieFilm.valueOf("SFI");
                break;
            case "DVR":
                cat = CategorieFilm.valueOf("DVR");
                break;
            default:
                System.out.println("Categorie inconnue");
        }
        return cat;
    }
    
    public static String convertToStringCategorieFilm(int i)            //conversion d'un int en String
    {
        String s = "";
        switch(i) {
            case 0:
                s = "THR";
                break;
            case 1:
                s = "WSN";
                break;
            case 2:
                s = "HOR";
                break;
            case 3:
                s = "GSR";
                break;
            case 4:
                s = "CDI";
                break;
            case 5:
                s = "ACT";
                break;
            case 6:
                s = "IFR";
                break;
            case 7:
                s = "SFI";
                break;
            case 8:
                s = "DVR";
                break;
            default:
                System.out.println("Index CategorieFilm inconnu");
        }
        return s; 
    }

    
    private final String nom;
}
