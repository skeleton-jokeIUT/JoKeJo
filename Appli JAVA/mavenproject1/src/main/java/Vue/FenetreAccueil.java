/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import metier.Artiste;
import metier.CategorieFilm;
import metier.Film;

/**
 *
 * @author johan
 */
public class FenetreAccueil extends javax.swing.JFrame {

    /**
     * Creates new form FenetreAccueil
     */
    public FenetreAccueil() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        creerOeuvre = new javax.swing.JButton();
        rechercherOeuvre = new javax.swing.JButton();
        gererType = new javax.swing.JButton();
        gererOeuvre = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Accueil");

        creerOeuvre.setText("Créer une Oeuvre");
        creerOeuvre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerOeuvreActionPerformed(evt);
            }
        });

        rechercherOeuvre.setText("Rechercher une Oeuvre");
        rechercherOeuvre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherOeuvreActionPerformed(evt);
            }
        });

        gererType.setText("Gérer type Oeuvre");
        gererType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gererTypeActionPerformed(evt);
            }
        });

        gererOeuvre.setText("Gérer groupe Oeuvre");

        quitter.setText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\CourIUTLyon1\\IHM\\TP3\\mavenproject1\\src\\main\\java\\Vue\\Image\\fond.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(quitter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(creerOeuvre)
                        .addGap(18, 18, 18)
                        .addComponent(rechercherOeuvre)
                        .addGap(89, 89, 89)
                        .addComponent(gererType)
                        .addGap(18, 18, 18)
                        .addComponent(gererOeuvre)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creerOeuvre)
                    .addComponent(rechercherOeuvre)
                    .addComponent(gererType)
                    .addComponent(gererOeuvre))
                .addGap(25, 25, 25)
                .addComponent(quitter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rechercherOeuvreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherOeuvreActionPerformed
        new Rechercher().setVisible(true);
    }//GEN-LAST:event_rechercherOeuvreActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void gererTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gererTypeActionPerformed
       
    }//GEN-LAST:event_gererTypeActionPerformed

    private void creerOeuvreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerOeuvreActionPerformed
         try {
                this.GestionCatalogue("D:/CourIUTLyon1/IHM/TP3/mavenproject1/src/main/java/Vue/listeFilms_pointVirgule.csv");
            } catch (IOException ex) {
                Logger.getLogger(FenetreAccueil.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_creerOeuvreActionPerformed

    public void GestionCatalogue(String cheminFichier) throws FileNotFoundException, IOException{
        
        FileReader fichier = new FileReader(cheminFichier);
        
        LineNumberReader lecteur = new LineNumberReader(fichier);
        String line = lecteur.readLine();
        int i=0;
        while (line != null){
                     System.out.println("OK");
            Artiste real = new Artiste(line.split(";")[1],line.split(";")[2]);
            CategorieFilm catPrincipale=getCat(line.split(";")[3]);
            CategorieFilm catSecondaire=getCat(line.split(";")[3]);
            
            Film film = new Film(line.split(";")[0],18,20,10,catPrincipale,catSecondaire, real, real,Integer.parseInt(line.split(";")[4]),line.split(";")[5]);
     
            line = lecteur.readLine();
            
        }     
        
    }
    
    public static CategorieFilm getCat(String cat){
        switch(cat){
            case"AVE":
                return CategorieFilm.AVE;
                
            case"POL":
                return CategorieFilm.POL;
                
            case"HIS":
                return CategorieFilm.HIS;
                
            case"DYS":
                return CategorieFilm.DYS;
                
            case"COM":
                return CategorieFilm.COM;
                
            default:return CategorieFilm.THR;
        }
        
       
    }
    
    
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creerOeuvre;
    private javax.swing.JButton gererOeuvre;
    private javax.swing.JButton gererType;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton quitter;
    private javax.swing.JButton rechercherOeuvre;
    // End of variables declaration//GEN-END:variables
}