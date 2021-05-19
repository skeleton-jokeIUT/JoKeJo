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
public enum CategorieMusique {
    
    JAZ("Jazz"), ROK("Rock"), CLS("Classique"), RAP("Rap"),ELC("Electro");
    
    private String nomCat;
    
    private CategorieMusique(String nomCat){
        this.nomCat=nomCat;
    }
    
    public String getNomCat(){
        return this.nomCat;
    }
   
    public static ArrayList<String> getCat(){
        
        ArrayList<String> Cat = new ArrayList<>();
        
        for (CategorieMusique cat : CategorieMusique.values()){
         
            Cat.add(cat.getNomCat());
   
            }
        
        return Cat;
    }
    
    
            
}
