/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author johan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Artiste r1 = new Artiste("Dujardin");
        Artiste a1 = new Artiste("Cassel");    
        
        Film f1 = new Film("StarWars",18,10,3,CategorieFilm.SF,CategorieFilm.AVE,r1,a1);
        Film f2 = new Film("StarWar",18,10,3,CategorieFilm.SF,CategorieFilm.AVE,r1,a1);
        Film f3 = new Film("StarW",18,10,3,CategorieFilm.SF,CategorieFilm.AVE,r1,a1);
        
        System.out.println(f1.toString());
        
       
        
        System.out.println(f2.compareTo(f1));
        
        
     
    }
    
}
