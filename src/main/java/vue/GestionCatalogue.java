/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import metier.*;
import static metier.CategorieFilm.convertToEnumCategorieFilm;
import static metier.CategorieMusiqueClip.convertToEnumCategorieClipMusique;
import static metier.ClipVideo.listeClipsGeres;
import static metier.Film.listeFilmsGeres;
import static metier.Oeuvre.listeOeuvresGerees;

/**
 *
 * @author jo
 */
public class GestionCatalogue extends javax.swing.JFrame {

    /**
     * Creates new form GestionCatalogue
     */
    public GestionCatalogue()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Catalogue");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(146, 120, 74), 3, true), "Catalogue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cantarell", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/jo/Documents/DUT/Java/Netbeans/JoKeJo/JoKeJo/src/main/java/gif/pele_mele.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setText("Rechercher une Oeuvre");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Créer une Oeuvre");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Gérer les séances publiques");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jButton5.setText("Quitter");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jButton5MousePressed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton5MousePressed
    {//GEN-HEADEREND:event_jButton5MousePressed
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        //clic sur bouton Rechercher une Oeuvre => instanciation d'une fenetre RechercheOeuvre
        RechercheOeuvre recherche = new RechercheOeuvre();
        recherche.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        //clic sur bouton Créer une Oeuvre => instanciation d'une fenetre CreerOeuvre
        CreerOeuvre oeuvre = new CreerOeuvre();
        oeuvre.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        GestionSeancePublique seanceP = new GestionSeancePublique();
        seanceP.setVisible(true);
        seanceP.pack();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GestionCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GestionCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GestionCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GestionCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new GestionCatalogue().setVisible(true);
            }
        });
    }
    
    public void lireFichierCsv() throws FileNotFoundException, IOException      //incremente la liste de toutes les oeuvres du fichier csv
    {
        String ligne;
        String typeOeuvre;
        String titre;
        String nomArtiste;
        String nationalite;
        String categorieP;
        String categorieS;
        int duree;
        int annee;
        String statut;
        int age;
       
        try
        {
            FileReader fichier = new FileReader("liste_oeuvres.csv"); 
            LineNumberReader lecteur = new LineNumberReader(fichier);
            ligne = lecteur.readLine();
            while(ligne != null)
            {
                typeOeuvre = ligne.split(";")[0];                       //type d'oeuvre
                nomArtiste = ligne.split(";")[1];
                titre = ligne.split(";")[2];                            //titre
                nationalite = ligne.split(";")[3];                      //nationalite
                annee = Integer.parseInt(ligne.split(";")[4]);          //année
                
                categorieP = ligne.split(";")[6];                       //categorie principale
                categorieS = ligne.split(";")[7];                       //categorie secondaire
                statut = ligne.split(";")[8];                           //statut (payant simple, premium ou gratuit)
                age = Integer.parseInt(ligne.split(";")[9]);
                    
                if(typeOeuvre.equals("FLM"))                            //si l'eouvre est un film
                {
                    duree = Integer.parseInt(ligne.split(";")[5]);          //durée
                    Artiste real = new Artiste(nomArtiste, nationalite, TypeOeuvre.FLM, MetierArtiste.RSR);
                    Film film = new Film(titre, real, annee, duree, convertToEnumCategorieFilm(categorieP), 
                            convertToEnumCategorieFilm(categorieS), statut, age);                   
                }
                
                if(typeOeuvre.equals("CVO"))                            //si l'eouvre est un clip video
                {
                    duree = Integer.parseInt(ligne.split(";")[5]);          //durée
                    
                    Artiste interprete = new Artiste(nomArtiste, nationalite, TypeOeuvre.CVO, MetierArtiste.IPT);
                    ClipVideo clip = new ClipVideo(titre, interprete, annee, duree, convertToEnumCategorieClipMusique(categorieP), 
                            convertToEnumCategorieClipMusique(categorieS), statut, age);                    
                }
                
                ligne = lecteur.readLine();                                 //passage à la ligne suivante
            }
            
            System.out.println(listeOeuvresGerees.toString());         //<=> Oeuvre.afficheToutesLesOeuvresGerees() => console
            System.out.println("Nombre d'oeuvres lues: \t"+listeOeuvresGerees.size());       //affiche dans la console le nombre d'oeuvres lues
            
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("Erreur fichier csv non trouvé");
        }
        catch(IOException e)
        {
            System.out.println("Erreur lecture fichier csv");
        }
    }
    

    


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton3;
    javax.swing.JButton jButton5;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}