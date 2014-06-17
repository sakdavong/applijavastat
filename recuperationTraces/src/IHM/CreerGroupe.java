/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import Ecouteurs.EcouteurRecherche;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import recuperationtraces.IndicateursImpl;
import recuperationtraces.Racine;

/**
 *
 * @author Matthieu
 */
public class CreerGroupe extends javax.swing.JPanel {
    DefaultListModel dlm2;
    DefaultListModel dlm1;
    List<String> listelements;
    Racine r;
    /**
     * Creates new form CreerGroupe
     */
    public CreerGroupe(Racine r) {
        initComponents();
        this.r=r;
        dlm1= new DefaultListModel();
        listelements=new ArrayList<>();
        JListAllIndicateurs.setModel(dlm1);
        //List<String> lst=new ArrayList<>();
        for (String key : r.getTracesEtIndicateursCalcules().getTr().keySet()){
            //lst.add(key);
            dlm1.addElement(key);
        }
        dlm2= new DefaultListModel();
        JListIndicateurUtilise.setModel(dlm2);
        EcouteurRecherche EcoutRech= new EcouteurRecherche(r, this,"Groupe");
        textRecherche.addKeyListener(EcoutRech);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JListAllIndicateurs = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        JListIndicateurUtilise = new javax.swing.JList();
        BoutonGversD = new javax.swing.JButton();
        BoutonDversG = new javax.swing.JButton();
        BoutonRecherche = new javax.swing.JButton();
        textRecherche = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        textNomGroupe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(JListAllIndicateurs);

        jScrollPane2.setViewportView(JListIndicateurUtilise);

        BoutonGversD.setText(">");
        BoutonGversD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonGversDActionPerformed(evt);
            }
        });

        BoutonDversG.setText("<");
        BoutonDversG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonDversGActionPerformed(evt);
            }
        });

        BoutonRecherche.setText("Recherche");
        BoutonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonRechercheActionPerformed(evt);
            }
        });

        jButton4.setText("Créer le groupe");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom du nouveau groupe : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoutonDversG)
                            .addComponent(BoutonGversD))
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoutonRecherche)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNomGroupe, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(textRecherche))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(BoutonGversD)
                        .addGap(31, 31, 31)
                        .addComponent(BoutonDversG)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonRecherche)
                    .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomGroupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JList getJListAllIndicateurs() {
        return JListAllIndicateurs;
    }

    private void BoutonDversGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonDversGActionPerformed
        //si l'utilisateur a sélectionné une valeur
        if(!JListIndicateurUtilise.isSelectionEmpty()){
            //on la change de liste
            dlm1.addElement(JListIndicateurUtilise.getSelectedValue());
            listelements.remove(JListIndicateurUtilise.getSelectedValue().toString());
            ((DefaultListModel)JListIndicateurUtilise.getModel()).removeElement(JListIndicateurUtilise.getSelectedValue());
            validate();}
        else JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
        // TODO add your handling code here:
    }//GEN-LAST:event_BoutonDversGActionPerformed

    private void BoutonGversDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonGversDActionPerformed
        //si l'utilisateur a sélectionné une valeur
        if(!JListAllIndicateurs.isSelectionEmpty()){
            //on le change de liste
            dlm2.addElement(JListAllIndicateurs.getSelectedValue());
            listelements.add(JListAllIndicateurs.getSelectedValue().toString());
            ((DefaultListModel)JListAllIndicateurs.getModel()).removeElement(JListAllIndicateurs.getSelectedValue());
            validate();
        }else {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner un element !");
        }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_BoutonGversDActionPerformed

    private void BoutonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonRechercheActionPerformed
        
        String s= textRecherche.getText(); //la chaine à rechercher
        String[] l=r.getTracesEtIndicateursCalcules().getTr().keySet().toArray(new String[r.getTracesEtIndicateursCalcules().getTr().keySet().size()]);
        DefaultListModel dLM=new DefaultListModel();            
        for(String key:l)
            if(key.contains(s))
                dLM.addElement(key);
        JListAllIndicateurs.setModel(dLM);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_BoutonRechercheActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        r.getGroupe().put(textNomGroupe.getText(),r.getTracesEtIndicateursCalcules().creerVueIndicateurs(listelements));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonDversG;
    private javax.swing.JButton BoutonGversD;
    private javax.swing.JButton BoutonRecherche;
    private javax.swing.JList JListAllIndicateurs;
    private javax.swing.JList JListIndicateurUtilise;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField textNomGroupe;
    private javax.swing.JTextField textRecherche;
    // End of variables declaration//GEN-END:variables

}
