/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import Ecouteurs.EcouteurMenu;
import Ecouteurs.EcouteurRecherche;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import recuperationtraces.IndicateursImpl;
import recuperationtraces.Racine;

/**
 *
 * @author Matthieu
 */
public class FrameStats extends javax.swing.JFrame {
    DefaultListModel dlm2;
    DefaultListModel dlm1;
    DefaultListModel dlm3;
    List<String> listelements;
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
        
        //liste des indicateurs
        dlm1= new DefaultListModel();
        listelements=new ArrayList<>();
        lesIndicateurs.setModel(dlm1);
        //List<String> lst=new ArrayList<>();
        for (String key : r.getTracesEtIndicateursCalcules().getTr().keySet()){
            //lst.add(key);
            dlm1.addElement(key);
        }
        dlm2= new DefaultListModel();
        dlm3 = new DefaultListModel();
        Liste1.setModel(dlm2);
        Liste2.setModel(dlm3);
        
        //liste des groupes
        lesGroupes.setModel(r.arbreModele);
       
        
        EcouteurRecherche EcoutRech= new EcouteurRecherche(r, jPanel1,"Accueil");
        textRecherche.addKeyListener(EcoutRech);
       
    }


    public JList getLesIndicateurs() {
        return lesIndicateurs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        lesGroupes = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        lesIndicateurs = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        Liste1 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        Liste2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        textRecherche = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Corrélation linéaire");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("ANOVA");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Régréssion linéaire multiple");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("MANOVA");

        jLabel1.setText("Veuillez choisir un traitement statistique à effectuer :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Traitements Statistiques");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jRadioButton1)
                .addGap(30, 30, 30)
                .addComponent(jRadioButton2)
                .addGap(28, 28, 28)
                .addComponent(jRadioButton4)
                .addGap(27, 27, 27)
                .addComponent(jRadioButton3)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Variables");

        jScrollPane3.setViewportView(lesGroupes);

        jTabbedPane2.addTab("Les groupes", jScrollPane3);

        jScrollPane2.setViewportView(lesIndicateurs);

        jTabbedPane2.addTab("Tous les indicateurs", jScrollPane2);

        Liste1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Liste1);

        Liste2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(Liste2);

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Veuillez choisir une (des) variable(s)");

        jLabel5.setText("Veuillez choisir une (des) variable(s) ");

        jButton5.setText("Lancer le calcul");

        jLabel6.setText("Recherche :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(150, 150, 150)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jTabbedPane1.addTab("Traitements statistiques", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleParent(this);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SupprGroupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprGroupeActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_SupprGroupeActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     //si l'utilisateur a sélectionné une valeur
        if(!lesIndicateurs.isSelectionEmpty()){
            //on le change de liste
            dlm2.addElement(lesIndicateurs.getSelectedValue());

           // ((DefaultListModel)lesIndicateurs.getModel()).removeElement(lesIndicateurs.getSelectedValue());

        }else if (!lesGroupes.isSelectionEmpty()){
            System.out.println(lesGroupes.getSelectionPath().getPathCount());

            //si lobjet choisi est un groupe
            if (lesGroupes.getSelectionPath().getPathCount()==2){
                //on cherche la hashmap du groupe
                for(String key:r.getGroupe().keySet()){
                    if (key.equals(lesGroupes.getSelectionPath().getLastPathComponent().toString())){
                        //on parcours la hashmap du groupe
                        for (String keyInd : r.getGroupe().get(key).getTr().keySet()){
                            dlm2.addElement(keyInd);
                        }
                    }
                }
            } else {
                dlm2.addElement(lesGroupes.getSelectionPath().getLastPathComponent().toString());
            }
        }else {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//si l'utilisateur a sélectionné une valeur
        if(!lesIndicateurs.isSelectionEmpty()){
            //on le change de liste
            dlm3.addElement(lesIndicateurs.getSelectedValue());
           // ((DefaultListModel)lesIndicateurs.getModel()).removeElement(lesIndicateurs.getSelectedValue());
            
        }else if (!lesGroupes.isSelectionEmpty()){
            System.out.println(lesGroupes.getSelectionPath().getPathCount());

            //si lobjet choisi est un groupe
            if (lesGroupes.getSelectionPath().getPathCount()==2){
                //on cherche la hashmap du groupe
                for(String key:r.getGroupe().keySet()){
                    if (key.equals(lesGroupes.getSelectionPath().getLastPathComponent().toString())){
                        //on parcours la hashmap du groupe
                        for (String keyInd : r.getGroupe().get(key).getTr().keySet()){
                            dlm3.addElement(keyInd);
                        }
                    }
                }           
            }else{
                dlm3.addElement(lesGroupes.getSelectionPath().getLastPathComponent().toString());
            }
        }else {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //si l'utilisateur a sélectionné une valeur
        if(!Liste1.isSelectionEmpty()){
            //on la change de liste
            dlm1.addElement(Liste1.getSelectedValue()); 
            ((DefaultListModel)Liste1.getModel()).removeElement(Liste1.getSelectedValue());
            
    }else JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  //si l'utilisateur a sélectionné une valeur
        if(!Liste2.isSelectionEmpty()){
            //on la change de liste
            dlm1.addElement(Liste2.getSelectedValue()); 
            ((DefaultListModel)Liste2.getModel()).removeElement(Liste2.getSelectedValue());
            
    }else JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JList Liste1;
    private javax.swing.JList Liste2;
    private javax.swing.JMenuItem SupprGroupe;
    private javax.swing.JMenuItem SupprimerIndicateur;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTree lesGroupes;
    private javax.swing.JList lesIndicateurs;
    private javax.swing.JTextField textRecherche;
    // End of variables declaration//GEN-END:variables
}
