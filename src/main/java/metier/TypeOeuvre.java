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
public enum TypeOeuvre {
    IMG("Image"),          //index 0
    ECR("Ecrit"),          //index 1
    MSQ("Musique"),        //2
    CVO("Clip Video"),     //3
    FLM("Film"),           //4
    JEU("Jeu Video"),      //5
    ACN("Aucun");          //6
    
    TypeOeuvre(String nom)
    {
        this.nom = nom;
    }
    
    public static List<String> getTousLesTypes() 
    {
        List<String> liste = new ArrayList();
        
        for(TypeOeuvre type: TypeOeuvre.values())
        {
            liste.add(type.getNomTypeOeuvre());
        }
        return liste;
    }
    
    public String getNomTypeOeuvre()
    {
        return nom;
    }
    
    public static TypeOeuvre convertStringToTypeOuvre(String s)    //conversion d'une chaine String en CategorieFilm (enum)
    {
        TypeOeuvre type = null;
        switch(s) {
            case "IMG":
                type = TypeOeuvre.valueOf("IMG");
                break;
            case "ECR":
                type = TypeOeuvre.valueOf("ECR");
                break;
            case "MSQ":
                type = TypeOeuvre.valueOf("MSQ");
                break;
            case "CVO":
                type = TypeOeuvre.valueOf("CVO");
                break;
            case "FLM":
                type = TypeOeuvre.valueOf("FLM");
                break;
            case "JEU":
                type = TypeOeuvre.valueOf("JEU");
                break;
            case "ACN":
                type = TypeOeuvre.valueOf("ACN");
                break;
            default:
                System.out.println("Type oeuvre inconnu");
        }
        return type;
    }
    
    public static String convertTypeOeuvreToString(int i)            //conversion d'un int en String
    {
        String s = "";
        switch(i) {
            case 0:
                s = "IMG";
                break;
            case 1:
                s = "ECR";
                break;
            case 2:
                s = "MSQ";
                break;
            case 3:
                s = "CVO";
                break;
            case 4:
                s = "FLM";
                break;
            case 5:
                s = "JEU";
                break;
            case 6:
                s = "ACN";
                break;
            default:
                System.out.println("Index TypeOeuvre inconnu");
        }
        return s; 
    }

    private final String nom;
}
