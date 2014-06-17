/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ecouteurs;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import recuperationtraces.*;
import IHM.*;
/**
 *
 * @author Matthieu
 */
public class EcouteurMenu implements ActionListener{
    Racine r;
    
    public EcouteurMenu(Racine r){
        this.r=r;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "CréerGroupe":
                JFrame fen = new JFrame("Créer un groupe");
                CreerGroupe panGroupe = new CreerGroupe(r);
                fen.setContentPane(panGroupe);
                fen.pack();
                fen.setVisible(true);
                fen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            break;
                
            case "CréerIndicateurs":
                JFrame fen1 = new JFrame("Créer un groupe");
                AjouterIndicateur ajoutInd=new AjouterIndicateur(r);
                fen1.setContentPane(ajoutInd);
                fen1.pack();
                fen1.setVisible(true);
                fen1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
            break;
            case "Supprimer un groupe":
                JFrame fen3 = new JFrame("Créer un groupe");
                SupprimerGroupe supGroupe=new SupprimerGroupe(r);
                fen3.setContentPane(supGroupe);
                fen3.pack();
                fen3.setVisible(true);
                fen3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                break;
                
        }
    }
    
}
