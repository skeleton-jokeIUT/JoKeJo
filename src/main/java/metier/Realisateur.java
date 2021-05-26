/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;



/**
 *
 * @author jo
 */
public class Realisateur extends Artiste {
    public Realisateur(String n, String nat)        
    {
        super(n);
        nationalite = nat;
    }
    
    //getters    
    public String getNationaliteRealisateur()
    {
        return this.nationalite;
    }
    
    //setters
    public void setNationaliteRealisateur(String nationalite)
    {
        this.nationalite = nationalite;
    }

    
    private String nationalite;

}
