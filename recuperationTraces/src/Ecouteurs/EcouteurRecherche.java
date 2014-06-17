/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ecouteurs;

import IHM.AjouterIndicateur;
import IHM.CreerGroupe;
import IHM.SupprimerIndicateur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import recuperationtraces.IndicateursImpl;
import recuperationtraces.Racine;

/**
 *
 * @author Matthieu
 */
public class EcouteurRecherche implements KeyListener{
    Racine r;
    JPanel fenetre;
    String typeFenetre;
    
    public EcouteurRecherche(Racine r,JPanel p, String type){
        this.r=r;
        fenetre= p;
        typeFenetre=type;
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
        boolean isSelectionne=false;
        
        switch (typeFenetre) {
            case "Groupe":
                for(String key:l){
                    isSelectionne=false;
                    //si la clé contient la chaine recherché
                    if(key.contains(s)){
                        //modele de la liste des éléments sélectionné pour le nouvel indicateur
                        ListModel modelUtilise = ((CreerGroupe)fenetre).getJListIndicateurUtilise().getModel();
                        //on vérifie si l'indicateur a été sélectionné ou pas
                        for(int i=0;i<modelUtilise.getSize();i++){
                            if(modelUtilise.getElementAt(i).equals(key)){
                                isSelectionne=true;
                            }
                        }
                        //si il n'est pas sélectionné on le met dans les résultats de la recherche
                        if (!isSelectionne)
                            dLM.addElement(key);
                    }
                }
                ((CreerGroupe)fenetre).getJListAllIndicateurs().setModel(dLM);
                break;
            case "Indicateur":
                for(String key:l){
                    isSelectionne=false;
                    //si la clé contient la chaine recherché
                    if(key.contains(s)){
                        //modele de la liste des éléments sélectionné pour le nouvel indicateur
                        ListModel modelUtilise = (((AjouterIndicateur)fenetre).getJListIndicateurUtilise().getModel());
                        //on vérifie si l'indicateur a été sélectionné ou pas
                        for(int i=0;i<modelUtilise.getSize();i++){
                            if(modelUtilise.getElementAt(i).equals(key)){
                                isSelectionne=true;
                            }
                        }
                        //si il n'est pas sélectionné on le met dans les résultats de la recherche
                        if (!isSelectionne)
                            dLM.addElement(key);
                    }
                }
                ((AjouterIndicateur)fenetre).getJListAllIndicateurs().setModel(dLM);
                break;
            case "SupprimerInd" :
                for(String key:l)
                    //si la clé contient la chaine recherché
                    if(key.contains(s))
                        dLM.addElement(key);
                        
                ((SupprimerIndicateur)fenetre).getJListAllIndicateurs().setModel(dLM);
        }
        
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
