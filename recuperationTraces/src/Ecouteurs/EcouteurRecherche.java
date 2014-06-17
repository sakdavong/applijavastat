/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ecouteurs;

import IHM.CreerGroupe;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import recuperationtraces.IndicateursImpl;
import recuperationtraces.Racine;

/**
 *
 * @author Matthieu
 */
public class EcouteurRecherche implements KeyListener{
    Racine r;
    CreerGroupe fenetre;
    
    public EcouteurRecherche(Racine r,CreerGroupe cG){
        this.r=r;
        fenetre= cG;
       
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        String s;
        if (Character.isLetterOrDigit(e.getKeyChar())){
            s= ((JTextField)e.getSource()).getText()+e.getKeyChar(); //la chaine à rechercher
        }else {
            s=((JTextField)e.getSource()).getText();
        }
        String[] l=r.getTracesEtIndicateursCalcules().getTr().keySet().toArray(new String[r.getTracesEtIndicateursCalcules().getTr().keySet().size()]);
        DefaultListModel dLM=new DefaultListModel();            
        for(String key:l)
            if(key.contains(s))
                dLM.addElement(key);
        fenetre.getJListAllIndicateurs().setModel(dLM);
        System.out.println(s);
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
