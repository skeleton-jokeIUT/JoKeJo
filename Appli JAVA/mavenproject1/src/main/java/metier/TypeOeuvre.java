/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;


/**
 *
 * @author johan
 */
public enum TypeOeuvre {
    
   
    FIL("Film"), MUS("Musique"), ECR("Ecrit"), JV("Jeux-Vidéo"), IMG("Image");
    
    private String nomOeuvre;
    
    private TypeOeuvre(String type){
        this.nomOeuvre=type;
    }
    
    public String getNom(){
        return this.nomOeuvre;
    }
    
 
    public static ArrayList<String> getListeOeuvre(){
        
        ArrayList<String> listeOeuvre = new ArrayList<>();
        
       for (TypeOeuvre oeuvre : TypeOeuvre.values()){
           
           listeOeuvre.add(oeuvre.getNom());
         
       }
       
       return listeOeuvre;
        
    }
    
}
