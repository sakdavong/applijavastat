/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sakdavong.communicationserveur.CommunicationServer;

/**
 *
 * @author JCSakdavong
 */
public class FenetreSaisieAuteursTrace extends javax.swing.JDialog {
    private int maxTraces=200; // Nombre de traces recherchée (et surtout taille du tableau de stockage vu que le but est une JTable sans MVC ici)

    /**
     * Creates new form FenetreSaisieAuteursTrace
     */
    public FenetreSaisieAuteursTrace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        auteurs = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        trace = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jLabel2.setText("Logins:");

        auteurs.setText("avrilmai2014_*");
        auteurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auteursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(auteurs, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(auteurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        trace.setText("manip1_carte4.trc");

        jLabel3.setText("Trace:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addComponent(trace, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Récupération des traces");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Voir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            BufferedReader br = CommunicationServer.receiveLogins(auteurs.getText());
            
            List<String> liste = new ArrayList<String>();
            while (br.ready())
            {
                liste.add(br.readLine());
                System.out.println("====> Traitement du login "+liste.get(liste.size()-1));
            }
            
            TreeMap<String, String[]> tr = new TreeMap<String, String[]>();
            tr.put(" Nom", new String[maxTraces+1]);
            String[] logins = new String[maxTraces+1];
            for (int i=0; i<maxTraces+1;i++)
                logins[i] = "";
            
            int nb=1;
            for (String login: liste)
            {
                System.out.println("====> Traitement du login "+login);
                tr.get(" Nom")[nb]=login;
                logins[nb] = login;
                try
                {

                    BufferedReader brf = CommunicationServer.receive(login, trace.getText(), "", "", "", "", "");

                    if (brf!=null)
                    while (brf.ready())
                    {
                        String line = brf.readLine();
                        System.out.println("                                                    "+line);
                        int pos = line.indexOf("#");

                        String indicateur = line.substring(0,pos);
                        String val = line.substring(pos+1);

                        if (!tr.containsKey(indicateur))
                            tr.put(indicateur, new String[maxTraces+1]);

                        tr.get(indicateur)[0] = indicateur;

                        tr.get(indicateur)[nb] = val;
                    }
                }
                catch (java.net.SocketException e)
                {
                    System.out.println("CARTE ABSENTE");
                }
                
                nb++;
            }
            
            for (String cle: tr.keySet())
            {
                String[] t = tr.get(cle);
                
                for (int i=0; i<maxTraces+1; i++)
                {
                    if (t[i]==null) t[i]="";
                }
            }
            
            
            List<String> listeCles = new ArrayList<String>();
            Iterator it = tr.keySet().iterator();
            while (it.hasNext())
            {
                listeCles.add(it.next().toString());
            }
            
            
            String[][] tab = new String[listeCles.size()][];
            
            for (int i = 0; i<listeCles.size(); i++)
            {
                tab[i] = tr.get(listeCles.get(i));
            }
            
            JFrame fr = new JFrame("Traces");
            JTable jt = new JTable(tab, logins){
  @Override
  public boolean getScrollableTracksViewportWidth() {
    return getPreferredSize().width < getParent().getWidth();
  }
};;
            for (int i=0; i<maxTraces+1; i++)
                jt.getColumnModel().getColumn(i).setMinWidth(i==0?300: 200);
            JScrollPane js = new JScrollPane(jt);
            js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            fr.setContentPane(js);
            fr.setSize(1024,768);
            fr.setVisible(true);
            fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (IOException ex) {
            System.out.println("IOException");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void auteursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auteursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_auteursActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreSaisieAuteursTrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreSaisieAuteursTrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreSaisieAuteursTrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreSaisieAuteursTrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FenetreSaisieAuteursTrace dialog = new FenetreSaisieAuteursTrace(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setModal(false);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField auteurs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField trace;
    // End of variables declaration//GEN-END:variables
}