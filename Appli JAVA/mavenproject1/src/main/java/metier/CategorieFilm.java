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
public enum CategorieFilm {
    
    COM("Comédie"), DRM("Drame"), THR("Thriller"), SF("Science-fiction"), AVE("Aventure"), DYS("Dystopie"),HIS("Historique"),POL("Politique");

    private String nomCat;
    
    private CategorieFilm(String nomCat){
        this.nomCat= nomCat;
    }
    
    public String getNomCat(){
        return this.nomCat;
    }
   
    public static ArrayList<String> getCat(){
        
        ArrayList<String> Cat = new ArrayList<>();
        
        for (CategorieFilm cat : CategorieFilm.values()){
         
            Cat.add(cat.getNomCat());
   
            }
        
        return Cat;
    }
    
    
}
