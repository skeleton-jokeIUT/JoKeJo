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

    private final String nom;
}
