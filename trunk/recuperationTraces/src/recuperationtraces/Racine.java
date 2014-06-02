/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * classe racine de l'application qui contiendra une HashMap 
 * contenant uniquement les données remontées du serveur
 * @author Tigro
 */
public class Racine {
    //ensuite, on créera une liste d'IndicateurImpl qui contiendra toutes les vues 
    //IndicateurImpl qui contiendra les données remonté du serveur
    //on ne le modifiera pas on créera des copies pour les modifications
    IndicateursImpl traces; 
    IndicateursImpl tracesEtIndicateursCalcules;
    /**
     * constructeur de la racine
     */
    public Racine() {
        File fichier = new File("src/sauvegardeIndicateurs.dat");
        if (fichier.exists()){
            System.out.println("on charge le fichier et boum");
            
            traces = new IndicateursImpl(this);
            traces.charger(fichier);
        }else {
            System.out.println("on recupere les traces");
            recupererTrace();
            System.out.println("fin de recupererTrace : on va sauvegarder");
            traces.sauver(fichier);
            System.out.println("fin de la sauvegarde");
        }
        tracesEtIndicateursCalcules = new IndicateursImpl(this);
        tracesEtIndicateursCalcules.setTr(traces.getTr());
        //on construit la Hashmap qui contiendra les indicateurs remontés du serveur 
        //et les indicateurs calculés
        tracesEtIndicateursCalcules.calculerMoyenneNoteNormalisee();
        tracesEtIndicateursCalcules.moyenneGlobaleNormaliseAvantApres();
        tracesEtIndicateursCalcules.classerUsers();
        //tracesEtIndicateursCalcules.afficher();
    }
    
   /**
    * une méthode pour recuprer les Traces du serveur et les sauvegarder dans une HashMap 
    * pour pouvoir l'utiliser aprés sans avoir à se reconnecter à chaque fois 
    * 
    */
    private void recupererTrace(){
        RecupTrace dialog = new RecupTrace(new javax.swing.JFrame(), true,this);
        System.out.println("fin de recupTrace");
        traces=dialog.getTraces();
        
    }

    public IndicateursImpl getTraces() {
        return traces;
    }
    
}
    
  
    /**
     * La classe IndicateurImpl prend la classe racine en parametre pour pouvoir utiliser
     * la HashMap qui contient les Traces Sauvgardées
     */

