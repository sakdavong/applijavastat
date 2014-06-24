/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.rosuda.JRI.Rengine;
import rjava.acces.ClientR;

/**
 * classe racine de l'application qui contiendra une HashMap 
 * contenant uniquement les données remontées du serveur
 * @author Tigro
 */
public class Racine {
    //ensuite, on créera une liste d'IndicateurImpl qui contiendra toutes les vues 
    //IndicateurImpl qui contiendra les données remonté du serveur
    //on ne le modifiera pas on créera des copies pour les modifications
    ClientR clientR; // La référence principal à R
    Rengine r;      // Le moteur de calcul de R
    IndicateursImpl traces; 
    IndicateursImpl tracesEtIndicateursCalcules;
    HashMap<String,IndicateursImpl> groupe;
    public DefaultTreeModel arbreModele;

    public Racine() throws IOException {
        clientR = new ClientR(new TextConsoleExemple());
        r = clientR.getEngine();
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

    private void transfertMatriceVersR(String nomMatrice, Object[][] tab) 
    {
        
        // La ligne d'attribution des noms de colonne aura la forme                           colnames(nomMatrice) = c("titre1", "titre2", ...)
        StringBuffer ligneTitres = new StringBuffer("colnames("+nomMatrice+")=c(");
        for (Object o: tab[0])
            ligneTitres.append("\""+o.toString()+"\",");
        ligneTitres.replace(ligneTitres.length()-1, ligneTitres.length(), ")");
        
        
        // La premiere ligne de valeur lignes aura la forme                                    nomMatrice = c(val1, val2, ...)
        StringBuffer sb = new StringBuffer(nomMatrice+"=c(");
        for (Object o: tab[1])
            sb.append(o.toString()+',');
        sb.replace(sb.length()-1, sb.length(), ")");

        r.eval(sb.toString());  // La ligne R est construite, on la fait évaluer
        System.out.println("Calcul par R: "+sb.toString());

        
        // Les autres lignes de valeurs auront la forme                                    nomMatrice = rbind(nomMatrice,c(val1, val2, ...))
        for (int i=2; i<tab.length; i++)
        {
            sb = new StringBuffer(nomMatrice+"=rbind("+nomMatrice+",c(");
            for (Object o: tab[i])
                sb.append(o.toString()+',');
            sb.replace(sb.length()-1, sb.length(), "))");

            r.eval(sb.toString());  // La ligne R est construite, on la fait évaluer
            System.out.println("Calcul par R: "+sb.toString());
        }
        
        // Attribution des noms de colonne
        System.out.println("Calcul par R: "+ligneTitres.toString());
        r.eval(ligneTitres.toString()); // La ligne R est construite, on la fait évaluer
        

        
        r.eval(nomMatrice);
    }
    private void transfertTableauVersR(String nomMatrice, Object[] tab) 
    {
        
        // La ligne d'attribution des noms de colonne aura la forme                           colnames(nomMatrice) = c("titre1", "titre2", ...)
        StringBuffer ligneTitres = new StringBuffer("colnames("+nomMatrice+")=c(");
        Object o= tab[0];
            ligneTitres.append("\""+o.toString()+"\",");
        ligneTitres.replace(ligneTitres.length()-1, ligneTitres.length(), ")");
        
        
        // La premiere ligne de valeur lignes aura la forme                                    nomMatrice = c(val1, val2, ...)
        StringBuffer sb = new StringBuffer(nomMatrice+"=c(");
        Object o2= tab[1];
            sb.append(o2.toString()+',');
        sb.replace(sb.length()-1, sb.length(), ")");

        r.eval(sb.toString());  // La ligne R est construite, on la fait évaluer
        System.out.println("Calcul par R: "+sb.toString());

        
        // Les autres lignes de valeurs auront la forme                                    nomMatrice = rbind(nomMatrice,c(val1, val2, ...))
        for (int i=2; i<tab.length; i++)
        {
            sb = new StringBuffer(nomMatrice+"=rbind("+nomMatrice+",c(");
            Object o3= tab[i];
                sb.append(o3.toString()+',');
            sb.replace(sb.length()-1, sb.length(), "))");

            r.eval(sb.toString());  // La ligne R est construite, on la fait évaluer
            System.out.println("Calcul par R: "+sb.toString());
        }
        
        // Attribution des noms de colonne
        System.out.println("Calcul par R: "+ligneTitres.toString());
        r.eval(ligneTitres.toString()); // La ligne R est construite, on la fait évaluer
        

        
        r.eval(nomMatrice);
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

