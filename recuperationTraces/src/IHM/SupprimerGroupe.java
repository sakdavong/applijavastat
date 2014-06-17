/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import recuperationtraces.*;

/**
 *
 * @author Tigro
 */
public class SupprimerGroupe extends javax.swing.JPanel {

    /**
     * Creates new form SupprimerGroupe
     */
    Racine r;
    public SupprimerGroupe(Racine r) {
        initComponents();
        this.r=r;
        //r.arbre est dans la Racine et contient les les groupe crée
        jTree1.setModel(r.arbreModele);
        jTree1.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                e.getPath().getPathCount();
                jTree1.setSelectionPaths(new TreePath[]{});
            }
        });
        validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoutonRecherche = new javax.swing.JButton();
        textRecherche = new javax.swing.JTextField();
        BoutonSupprimer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        BoutonRecherche.setText("Recherche");
        BoutonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonRechercheActionPerformed(evt);
            }
        });

        BoutonSupprimer.setText("Supprimer le groupe");
        BoutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSupprimerActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(BoutonRecherche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonSupprimer)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonRecherche)
                    .addComponent(textRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(BoutonSupprimer)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonRechercheActionPerformed
      
        String s= textRecherche.getText(); //la chaine à rechercher
        DefaultMutableTreeNode[] l=r.getGroupe().keySet().toArray(new DefaultMutableTreeNode[r.getGroupe().keySet().size()]);
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("groupe");
        JTree jt= new JTree(racine);
        for(DefaultMutableTreeNode key:l)
        if(key.toString().contains(s))
        racine.add(key);
        
        
        
        jTree1.setModel(jt.getModel());
        

        // TODO add your handling code here:
    }//GEN-LAST:event_BoutonRechercheActionPerformed

    private void BoutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSupprimerActionPerformed
        
        TreePath sp = jTree1.getSelectionModel().getSelectionPath();
        TreePath[] sp2 = jTree1.getSelectionModel().getSelectionPaths();
        
        DefaultMutableTreeNode dmt=(DefaultMutableTreeNode)(sp.getLastPathComponent());
        
        
        r.getGroupe().remove((String)(dmt.getUserObject()));
        
        int pos = r.arbreModele.getIndexOfChild(dmt.getParent(), dmt);
        System.out.println(sp+" sp2 size:" +sp2.length+" "+pos);
        //().remove(dmt);
        
        r.arbreModele.removeNodeFromParent(dmt);
        //r.arbreModele.nodesWereRemoved(dmt.getParent(), new int[]{pos}, new Object[]{dmt});
        //r.arbreModele.nodeStructureChanged(dmt.getParent());
        //jTree1.getParent().revalidate();

        // TODO add your handling code here:
    }//GEN-LAST:event_BoutonSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonRecherche;
    private javax.swing.JButton BoutonSupprimer;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField textRecherche;
    // End of variables declaration//GEN-END:variables
}
