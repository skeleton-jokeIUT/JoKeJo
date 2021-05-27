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
public class JeuVideo extends Oeuvre {
    public JeuVideo(TypeOeuvre t, Artiste art, String nom, String statut, int a, int ageMini)
    {
        super(TypeOeuvre.JEU, art, nom, statut, a, ageMini);
    }
}
