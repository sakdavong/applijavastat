/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import recuperationtraces.*;

/**
 *
 * @author Tigro
 */
public class AjouterIndicateur extends javax.swing.JPanel {
      
    /**
     * Creates new form AjouterIndicateur
     */
    Racine r;
    public AjouterIndicateur(Racine r) {
        initComponents();
        this.r=r;
        DefaultListModel dlm1= new DefaultListModel();
        JListAllIndicateurs.setModel(dlm1);
        List<String> lst=new ArrayList<>();
        for (String key : r.getTracesEtIndicateursCalcules().getTr().keySet()){
            lst.add(key);
            dlm1.addElement(key);
        }
        DefaultListModel dlm2= new DefaultListModel();
        JListIndicateurUtilise.setModel(dlm2);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListIndicateurUtilise = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListAllIndicateurs = new javax.swing.JList();
        textRecherche = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TxtNomNewIndicateur = new javax.swing.JTextField();
        CalculSomme = new javax.swing.JButton();
        CalculMoyenne = new javax.swing.JButton();
        CalculMEcart = new javax.swing.JButton();
        nomIndicateur = new javax.swing.JLabel();
        Recherche = new javax.swing.JButton();

        jButton4.setText("jButton4");

        jTextField3.setText("jTextField3");

        jScrollPane2.setViewportView(JListIndicateurUtilise);

        jScrollPane1.setViewportView(JListAllIndicateurs);

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

        CalculSomme.setText("Sommme");

        CalculMoyenne.setText("Moyenne");

        CalculMEcart.setText("Ecart");

        nomIndicateur.setText("Nom de Lindicateur   :");

        Recherche.setText("Recherche");
        Recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CalculMoyenne)
                        .addGap(50, 50, 50)
                        .addComponent(CalculSomme)
                        .addGap(50, 50, 50)
                        .addComponent(CalculMEcart, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Recherche)
                            .addComponent(nomIndicateur, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textRecherche)
                            .addComponent(TxtNomNewIndicateur, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recherche))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNomNewIndicateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomIndicateur))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalculMoyenne)
                    .addComponent(CalculSomme)
                    .addComponent(CalculMEcart))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultListModel dLM=(DefaultListModel) JListIndicateurUtilise.getModel();
        //dLM.addElement(JListAllIndicateurs.getSelectedValue());
        DefaultListModel dLM2=(DefaultListModel) JListAllIndicateurs.getModel();
        
    //    dLM2.removeElementAt(JListAllIndicateurs.getSelectedIndex());
    //    JListAllIndicateurs.invalidate();
        
        dLM2.removeElement(JListAllIndicateurs.getSelectedValue());
        validate();
         
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercheActionPerformed
        
        String s= textRecherche.getText();
        String[] l=r.getTracesEtIndicateursCalcules().getTr().keySet().toArray(new String[r.getTracesEtIndicateursCalcules().getTr().keySet().size()]);
        List<String> l2=new ArrayList<>();
        for(String ss:l)
            if(ss.contains(s))
                l2.add(ss);
        IndicateursImpl ind=r.getTracesEtIndicateursCalcules().creerVueIndicateurs(l2);
        JListAllIndicateurs.setModel(ind);
                
// TODO add your handling code here:
    }//GEN-LAST:event_RechercheActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!JListIndicateurUtilise.isSelectionEmpty()){
        DefaultListModel dLM=(DefaultListModel) JListIndicateurUtilise.getModel();
        dLM.removeElement(JListIndicateurUtilise.getSelectedValue());
        validate();}
        else JOptionPane.showMessageDialog(this, "veuiller selectionner un element a enlever de la liste!");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculMEcart;
    private javax.swing.JButton CalculMoyenne;
    private javax.swing.JButton CalculSomme;
    private javax.swing.JList JListAllIndicateurs;
    private javax.swing.JList JListIndicateurUtilise;
    private javax.swing.JButton Recherche;
    private javax.swing.JTextField TxtNomNewIndicateur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel nomIndicateur;
    private javax.swing.JTextField textRecherche;
    // End of variables declaration//GEN-END:variables
}