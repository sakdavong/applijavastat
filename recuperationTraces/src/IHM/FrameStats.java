/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import Ecouteurs.EcouteurMenu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import recuperationtraces.Racine;

/**
 *
 * @author Matthieu
 */
public class FrameStats extends javax.swing.JFrame {
    
    Racine r;
    /**
     * Creates new form FrameStats
     * @param r
     */
    public FrameStats(Racine r) {
        this.r=r;
        initComponents();
        EcouteurMenu eMenu = new EcouteurMenu(r);
        CreerGroupe.addActionListener(eMenu);
        SupprGroupe.addActionListener(eMenu);
        CreerIndicateur.addActionListener(eMenu);
        SupprimerIndicateur.addActionListener(eMenu);
        AfficherDonnees.addActionListener(eMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Fichier = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        AfficherDonnees = new javax.swing.JMenuItem();
        GestionInd = new javax.swing.JMenu();
        CreerGroupe = new javax.swing.JMenuItem();
        SupprGroupe = new javax.swing.JMenuItem();
        CreerIndicateur = new javax.swing.JMenuItem();
        SupprimerIndicateur = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fichier.setText("Fichier");

        jMenuItem3.setText("Effectuer une mise à jour des données");
        Fichier.add(jMenuItem3);

        AfficherDonnees.setText("Afficher les données");
        AfficherDonnees.setActionCommand("AfficherDonnees");
        Fichier.add(AfficherDonnees);

        jMenuBar1.add(Fichier);

        GestionInd.setText("Gestion des indicateurs");

        CreerGroupe.setText("Créer un groupe");
        CreerGroupe.setActionCommand("CréerGroupe");
        GestionInd.add(CreerGroupe);

        SupprGroupe.setText("Supprimer un groupe");
        SupprGroupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprGroupeActionPerformed(evt);
            }
        });
        GestionInd.add(SupprGroupe);

        CreerIndicateur.setText("Créer un nouvel indicateur");
        CreerIndicateur.setActionCommand("CréerIndicateurs");
        GestionInd.add(CreerIndicateur);

        SupprimerIndicateur.setText("Supprimer un indicateur");
        SupprimerIndicateur.setActionCommand("SupprimerIndicateur");
        GestionInd.add(SupprimerIndicateur);

        jMenuBar1.add(GestionInd);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SupprGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprGroupeActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_SupprGroupeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Racine r = new Racine();
                    new FrameStats(r).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrameStats.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AfficherDonnees;
    private javax.swing.JMenuItem CreerGroupe;
    private javax.swing.JMenuItem CreerIndicateur;
    private javax.swing.JMenu Fichier;
    private javax.swing.JMenu GestionInd;
    private javax.swing.JMenuItem SupprGroupe;
    private javax.swing.JMenuItem SupprimerIndicateur;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
