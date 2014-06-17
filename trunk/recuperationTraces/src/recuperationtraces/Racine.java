/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
    HashMap<String,IndicateursImpl> groupe;
    public DefaultTreeModel arbreModele;
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
        DefaultMutableTreeNode Racine = new DefaultMutableTreeNode("groupe");
        arbreModele= new DefaultTreeModel(Racine);
        groupe = new HashMap();
        tracesEtIndicateursCalcules = new IndicateursImpl(this);
        tracesEtIndicateursCalcules.setTr(traces.getTr());
        //on construit la Hashmap qui contiendra les indicateurs remontés du serveur 
        //et les indicateurs calculés
        tracesEtIndicateursCalcules.calculerMoyenneNoteNormalisee();
        tracesEtIndicateursCalcules.moyenneGlobaleNormaliseAvantApres();
        tracesEtIndicateursCalcules.classerUsers();
        tracesEtIndicateursCalcules.moyenneVariableAutoEvaluation();
        tracesEtIndicateursCalcules.nbUtilisationAide();
        System.out.println("taille de la HashMap : "+tracesEtIndicateursCalcules.getTr().size());
        tracesEtIndicateursCalcules.comportementsRA();
        System.out.println("taille de la HashMap : "+tracesEtIndicateursCalcules.getTr().size());
        tracesEtIndicateursCalcules.perfApprentissage();
        tracesEtIndicateursCalcules.butMaitrisePerformance();
        tracesEtIndicateursCalcules.variableMotivationnelle();
        System.out.println("taille de la HashMap : "+tracesEtIndicateursCalcules.getTr().size());
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

    public IndicateursImpl getTracesEtIndicateursCalcules() {
        return tracesEtIndicateursCalcules;
    }

    public HashMap<String, IndicateursImpl> getGroupe() {
        return groupe;
    }

    public void setGroupe(HashMap<String, IndicateursImpl> groupe) {
        this.groupe = groupe;
    }
    
    
}
    
  
    /**
     * La classe IndicateurImpl prend la classe racine en parametre pour pouvoir utiliser
     * la HashMap qui contient les Traces Sauvgardées
     */

