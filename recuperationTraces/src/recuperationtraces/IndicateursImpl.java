/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListDataListener;


public class IndicateursImpl extends DefaultListModel implements Indicateurs{
    
    private HashMap<String, List<String>> tr;
    
    Racine r;
    
    /**
     * ce constructeur utilise les données directement renvoyé du serveur
     * @param r la racine de l'application
     */
    public IndicateursImpl (Racine r) {
        this.r=r;
        tr = new HashMap();
    }
    
    /**
     * constructeur qui permet de créer un IndicateursImpl à partir d'un autre IndicateursImpl
     * et pas à a partir des traces de base
     * @param r racine de l'application
     * @param i indicateur choisi comme base pour en construire un autre 
     * @exemple notamment utilisé pour créer des vues à partir d'autre vues ...
     */
    public IndicateursImpl() {
        tr = new HashMap();
       }
    
    @Override
    public IndicateursImpl creerVueIndicateurs(List<String> ARechercher) {
        //nouvel indicateurImpl qui contiendra la vue
        IndicateursImpl indImpl=new IndicateursImpl(r);
        for(String s:ARechercher){
            // si la hashMap contient la clé 
            if(tr.containsKey(s)){
                //on rajoute la clé et la liste de valeurs dans la nouvelle vue
                indImpl.getTr().put(s, tr.get(s));
            }
        }
        return indImpl;
    }

    @Override
    public Indicateurs creerVueValeurs(String nomIndicateur, String ValeurContrainte, String condition){
        IndicateursImpl indImpl=new IndicateursImpl(r);
        switch (condition) {
            case "<":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(Double.parseDouble(ValeurContrainte)<=Double.parseDouble(tr.get(nomIndicateur).get(i))){
                        indImpl.supprimerParticipants(i);
                    }
                }
                break;
            case ">":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(Double.parseDouble(ValeurContrainte)>=Double.parseDouble(tr.get(nomIndicateur).get(i))){
                        indImpl.supprimerParticipants(i);
                    }
                }
                break;
            case "<=":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(Double.parseDouble(ValeurContrainte)<Double.parseDouble(tr.get(nomIndicateur).get(i))){
                        indImpl.supprimerParticipants(i);
                    }
                }
                break;
            case ">=":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(Double.parseDouble(ValeurContrainte)>Double.parseDouble(tr.get(nomIndicateur).get(i))){
                        indImpl.supprimerParticipants(i);
                    }
                }
                break;
            case "=":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(!tr.get(nomIndicateur).get(i).equals(ValeurContrainte)){
                        indImpl.supprimerParticipants(i);
                    }
                }
            case "#":
                for(int i=0;i<tr.get(nomIndicateur).size();i++){
                    if(tr.get(nomIndicateur).get(i).equals(ValeurContrainte)){
                        indImpl.supprimerParticipants(i);
                    }
                }
                break;
                
        }
        return null;
    }

   // Affichage
    @Override
    public void afficher() {
    // Afficher le contenu du MAP
    		Set listKeys=tr.keySet();  // Obtenir la liste des clés
    		Iterator iterateur=listKeys.iterator();
    		// Parcourir les clés et afficher les entrées de chaque clé;
                String[] logins = new String[tr.get("Nom").size()+1];
                String[][] tab = new String[listKeys.size()+1][tr.get("Nom").size()+1];
                logins[0]="Indicateur/nom";
                for(int i=1;i<tr.get("Nom").size()+1;i++)
                    logins[i]=tr.get("Nom").get(i-1);
                int i=0;
    		while(iterateur.hasNext())
    		{
    			Object key= iterateur.next();
    			System.out.println (key+"=>"+tr.get(key));
                        tab[i][0]=(String) key;
                        for(int j=1;j<tr.get(key).size()+1;j++)
                        tab[i][j]=tr.get(key).get(j-1);
                                i++;
    		}
                JFrame fr = new JFrame("Traces");
                JTable jt = new JTable(
                        tab,
                        logins){
                    @Override
                    public boolean getScrollableTracksViewportWidth() {
                        return getPreferredSize().width < getParent().getWidth();
                    }
                };;
                for (int j=0; j<tr.get("Nom").size()+1; j++)
                    jt.getColumnModel().getColumn(j).setMinWidth(j==0?300: 200);
                JScrollPane js = new JScrollPane(jt);
                
                js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                fr.setContentPane(js);
                fr.setSize(1024,768);
                fr.setVisible(true);
                fr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    
    @Override
    public void supprimerParticipants(int indice) {
        for(String key: tr.keySet()){
            (tr.get(key)).remove(indice);
        }
    }
    public void supprimerParticipants(String nom) {
        supprimerParticipants(tr.get("Nom").indexOf(nom));
    }

    @Override
    public HashMap<String, List<String>> getTr() {
        return tr;
    }
    @Override
    public void setTr(HashMap<String, List<String>> tr) {
        this.tr = tr;
    }

    @Override
    public double[][] creerMatrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] creerTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /**
     * permet de sauvegarder un IndicateurImpl (serialisation)
     * @param monFichier fichier dans lequel on charge
     */
    public void sauver(File monFichier) {
    FileOutputStream fos= null; 
        ObjectOutputStream oos = null;
        try {      
            
            fos = new FileOutputStream(monFichier, false); // Création flux d'octets
            oos = new ObjectOutputStream(fos); // Création du flux d'objets à partir du flux d'octets
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndicateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndicateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {      
            // Utilisation de la méthode void writeObject(Object o) de oos:
            oos.writeObject(tr); // Ecriture d'un objet dans le flux
            oos.close(); // Fermeture du flux d'objet
            fos.close(); // Fermeture du flux d'octets
        
        } catch (IOException ex) {
            Logger.getLogger(IndicateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    /**
     * permet de charger un IndicateurImpl
     * @param monFichier fichier dans lequel on charge
     */
    public void charger(File monFichier) {
        
        FileInputStream fis = null; 
        ObjectInputStream ois = null;
        try {
                fis = new FileInputStream(monFichier); // Création flux d'octets
                ois = new ObjectInputStream(fis); // Création du flux d'objets à partir du flux d'octets
                tr = (HashMap<String, List<String>>)(ois.readObject()); // Lecture d'un objet dans le flux et attestation du type
                ois.close(); // Fermeture du flux d'objet
                fis.close(); // Fermeture du flux d'octets
        } catch (FileNotFoundException ex) {
                
        } catch (IOException ex) {
                Logger.getLogger(IndicateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndicateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    /**
     * modifie les notes normalisées qui sont égale à -0.33 en -1
     */
    private void modifierNotes(){
        //parcours de la liste des clés
        for (String key : tr.keySet()) {
            //si la clé contient la chaine suivante
            if (key.contains("NoteQCM_q_normalisee")) {
                int i=0;
                //on parcours les valeurs contenues dans sa liste
                for (String valeur:tr.get(key)){
                    //et on modifie les -0.33 en -1.0
                    if (valeur.equals("-0.33")||valeur.equals(" -0.33")) {
                        tr.get(key).set(i,"-1.0");
                    }
                    i++;
                }
            }
        }
    }
    /**
     * recherche les notes normalisées Avant et Apres de chaque carte à partir des notes normalisées des questions
     * puis calcule la moyenne et l'ajoute à la hashMap concerné
     */
    public void calculerMoyenneNoteNormalisee(){
        int numeroCarte=0;          //numero de la carte parcouru
        String nomKeyAv,nomKeyAp;   //nom des sous-clés à rechercher
        
        //tant qu'il existe des cartes
        while(tr.containsKey("manip1_carte"+numeroCarte+"/avant/NoteQCM_q_normalisee0")) {
            
            List<String> listeAv = new ArrayList(); //liste des indicateurs NoteQCM_q_normalisee d'un même QCM avant
            List<String> listeAp = new ArrayList(); //liste des indicateurs NoteQCM_q_normalisee d'un même QCM après
            
            //parcours de toutes les clés
            for (String key : tr.keySet()) {
                nomKeyAv = "manip1_carte"+numeroCarte+"/avant/NoteQCM_q_normalisee";
                nomKeyAp = "manip1_carte"+numeroCarte+"/apres/NoteQCM_q_normalisee";

                //si la clé contient la chaine recherchée de la carte numeroCarte
                if (key.contains(nomKeyAv)) {
                    //on l'ajoute à la liste qui servira toute la moyenne
                    //cette liste contiendra les indicateurs qui représentent les questions du QCM avant de la carte numeroCarte
                    listeAv.add(key);

                } else if (key.contains(nomKeyAp)) {
                    //on l'ajoute à la liste
                    //cette liste contiendra les indicateurs qui représentent les questions du QCM apres de la carte numeroCarte
                    listeAp.add(key);

                }
            }
            
            //on calcule les moyennes d'avant et apres et on les ajoute a la hashMap
            creerIndicateurMoyenne("manip1_carte"+numeroCarte+"/avant/NoteQCM_Normalisee",listeAv);
            creerIndicateurMoyenne("manip1_carte"+numeroCarte+"/apres/NoteQCM_Normalisee",listeAp);
            indicateurEcart("Ecart_NoteQCMNormaliseeCarte"+numeroCarte, "manip1_carte"+numeroCarte+"/apres/NoteQCM_Normalisee", "manip1_carte"+numeroCarte+"/avant/NoteQCM_Normalisee");
            //on passe à la carte suivante
            numeroCarte++;
        }
    }
    
    
    
     /**
     * méthode qui permet de calculer la moyenne à partir d'une liste d'indicateurs
     * et l'ajoute à la hashMap concerné
     * @param nom le nom du nouvel indicateur
     * @param listeInd la liste des indicateurs dont on veut faire la moyenne
     */
    public void creerIndicateurMoyenne(String nom, List<String> listeInd){
        // tableau qui contiendra les sommes des indicateurs
        double[] somme = new double[tr.get("Nom").size()];
        
        //parcours de la liste d'indicateurs passé en arguments
        for(String ind:listeInd){
            //parcours de la liste de valeurs 
            for(int i=0;i<tr.get(ind).size();i++){
                //si la valeur n'est pas vide
                if(!tr.get(ind).get(i).equals("")){
                    if(somme[i]!=-1)
                    //on l'ajoute au tableau des sommes
                    somme[i]+=Double.parseDouble(tr.get(ind).get(i));
                }else {
                    somme[i]=-1;
                }
            }
        }
        
        //on ajoute un indicateur dans la hashMap avec une liste vide en valeur
        tr.put(nom, new ArrayList<String>());
        //on ajoute dans cette liste les valeurs des moyennes
        for(int i=0;i<tr.get("Nom").size();i++){
            if(somme[i]!=-1)
                tr.get(nom).add(String.valueOf(somme[i]/listeInd.size()));
            else
                tr.get(nom).add("");
        }
    }
    
    /**
     * crée un indicateur à partir de l’écart entre deux indicateurs 
     * Apres - Avant
     * @param nom le nom de l'indicateur à creer
     * @param apres la valeur apres
     * @param avant la valeur avant
     */
    public void indicateurEcart(String nom, String apres, String avant){
        
        //ajoute un nouvel indicateur avec une liste vide en valeur
        tr.put(nom, new ArrayList<String>());

        // parcours les deux listes de valeurs des indicateurs à soustraire
        for(int i=0;i<tr.get("Nom").size();i++){
            //s’il n’y a pas une valeur nulle dans l’un des deux indicateurs (après,avant) il fait la soustraction
            if(!tr.get(apres).get(i).equals("")&& !tr.get(avant).get(i).equals("")) 
                //et l'ajoute à la liste de valeurs
                tr.get(nom).add(String.valueOf(Double.parseDouble(tr.get(apres).get(i))-Double.parseDouble(tr.get(avant).get(i))));
            //sinon il met une chaine vide
            else tr.get(nom).add("");
        }
    }
    /**
     * crée un indicateur à partir de la somme d’une liste d’indicateurs
     * @param nom le nom du nouvel indicateur
     * @param listeInd la liste des indicateurs à ajouter
     */
    public void creerIndicateurSomme(String nom, List<String> listeInd){
        
        // tableau contenant la somme des indicateurs
        double[] somme = new double[getTr().get("Nom").size()];
        
        //parcours de la liste d'indicateurs donnée en argument
        for(String ind:listeInd){
            //parcours des valeurs de ces indicateurs
            for(int i=0;i<tr.get(ind).size();i++){
                //si l'indicateur n'est pas vide 
                if(!tr.get(ind).get(i).equals(""))
                //on fait la somme et on la met dans le tableau    
                somme[i]=somme[i]+Double.parseDouble(tr.get(ind).get(i));
                
            }
        }
        //on crée un nouvel indicateur avec une liste vide comme valeur
        tr.put(nom, new ArrayList<String>());
        //on ajoute les valeurs contenus dans le tableau des sommes dans cette liste
        for(int i=0;i<tr.get("Nom").size();i++){
            tr.get(nom).add(String.valueOf(somme[i]));
        }
        
    }
    /**
     * calcule la moyenne de toutes les notes normalisées AVANT entre elles et APRES entre elles
     * pour obtenir une note globale normalisé avant et une note globale normalisé apres
     */
    public void moyenneGlobaleNormaliseAvantApres(){
        int numeroCarte=0;          //numero de la carte parcouru
        List<String> noteNormAvant = new ArrayList<>(); //liste des notes normalisé de chaque carte
        List<String> noteNormApres = new ArrayList<>();
        
       //tant qu'il existe des cartes
        while(tr.containsKey("manip1_carte"+numeroCarte+"/avant/NoteQCM_Normalisee")) {
            
            //parcours de toutes les clés
            for (String key : tr.keySet()) {
                //si on trouve l'indicateur (de note normalisée avant)
                if (key.equals("manip1_carte"+numeroCarte+"/avant/NoteQCM_Normalisee")){
                    noteNormAvant.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur (de note normalisée apres)
                } else if (key.equals("manip1_carte"+numeroCarte+"/apres/NoteQCM_Normalisee")){
                    noteNormApres.add(key);//on l'ajoute à la liste
                }
            }
            numeroCarte++;
        }
        //on calcule les moyennes d'avant et apres et on les ajoute a la hashMap
        creerIndicateurMoyenne("manip1_MoyenneQCM_Avant_Normalisee",noteNormAvant);
        creerIndicateurMoyenne("manip1_MoyenneQCM_Apres_Normalisee",noteNormApres);
        
    }
    /**
     * classe les utilisateurs en deux catégories par rapport à la médianne des notes avant
     * crée un nouvel indicateurs qui pourra contenir deux valeurs faible ou fort
     */
    public void classerUsers() {
       List<String> liste = tr.get("manip1_MoyenneQCM_Avant_Normalisee");
       List<String> listeClassement = new ArrayList<>();
       double mediane = calculerMediane(liste);
       
       
       for (String t : liste) {
           if (t.equals(""))
               listeClassement.add("");
           else if(Double.parseDouble(t)<mediane){
               listeClassement.add("faible");
           }else{
               listeClassement.add("fort");
           }
        }
       tr.put("manip1_classement", listeClassement);
    }
    /**
     * Calcule la médiane d'une liste de String(avec valeurs entieres)
     * @param liste la liste de valeurs dont il faut trouver la médiane
     * @return la médiane de la liste 
     */
    public double calculerMediane(List<String> liste){
        double mediane;
        //liste de double
        List<Double> listeConverti = new ArrayList<>();
      //  List<String> listeTrie = tr.get("manip1_MoyenneQCM_Avant_Normalisee");
        
        //rempli la liste de double avec les valeur contenu dans la liste de String
        for (String t : liste) {
            if(!t.equals(""))
            listeConverti.add(Double.parseDouble(t));
        }
        
        //permet de trier la liste 
        Collections.sort(listeConverti);
        
        /**si la liste est de longueur paire*/
        if (liste.size()%2 == 0) {
            /**on prend la moyenne entre les deux valeurs situés au milieu*/
            double medianeTemp1 = listeConverti.get(listeConverti.size()/2);
            double medianeTemp2 = listeConverti.get((listeConverti.size()/2)-1);
            mediane = (medianeTemp1+medianeTemp2)/2;
        /**si la liste est de longueur impaire*/
        }else{
            /**on prend la valeur situé au milieu*/
            mediane = listeConverti.get(listeConverti.size()/2);
        }        
        return mediane;
    }
    
    /**
     * calcule les moyennes des SAE, de la difficulteTache et de l'EffortMental
     * (on les a regroupés pour éviter de faire trois fois la même boucle)
     * puis les ajoute à la HashMap
     */
    public void moyenneVariableAutoEvaluation(){
        // l'espace devant les indicateurs est présent dans le serveur 
        // on l'a donc conservé pour la recherche

        //listes qui contiendront les différents indicateurs qui rentreront dans le calcul de la moyenne
        List<String> listeSAE = new ArrayList<>();
        List<String> listeEffortMental = new ArrayList<>();
        List<String> listeDifficulteTache = new ArrayList<>();
        int numeroCarte=1;
        
        //tant qu'il existe des cartes
        while(tr.containsKey(" SAECarte"+numeroCarte)) {
            
            //parcours de toutes les clés
            for (String key : tr.keySet()) {
                //si on trouve l'indicateur de SAE
                if (key.equals(" SAECarte"+numeroCarte)){
                    listeSAE.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur de difficulteTache
                } else if (key.equals(" difficulteTacheCarte"+numeroCarte)){
                    listeDifficulteTache.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur d'EffortMental
                } else if (key.equals(" effortMentalCarte"+numeroCarte)){
                    listeEffortMental.add(key);//on l'ajoute à la liste
                }
            }
            numeroCarte++;
        }
        //on calcule les moyennes puis on les ajoute à la HashMap
        creerIndicateurMoyenne("Moyenne_SAE", listeSAE);
        creerIndicateurMoyenne("Moyenne_difficulteTache", listeDifficulteTache);
        creerIndicateurMoyenne("Moyenne_EffortMental", listeEffortMental);
    }
    /**
     * crée les indicateurs contenant le nombre moyen d'utilisation de chaque aide
     * puis la moyenne du nombre d'utilisation des aides instrumentales et executive
     * puis la moyenne globale du nombre d'utilisation d'aides
     */
    public void nbUtilisationAide(){
        //listes qui contiendront les indicateurs necessaires aux calculs de moyenne
        List<String> listeAideInstru1 = new ArrayList<>(); 
        List<String> listeAideInstru2 = new ArrayList<>(); 
        List<String> listeAideExe = new ArrayList<>();    
        List<String> listeEvitement1 = new ArrayList<>();
        List<String> listeEvitement2 = new ArrayList<>();
        
        int numeroCarte=0; 
        
        //tant qu'il existe des cartes
        while(tr.containsKey("manip1_carte"+numeroCarte+"/nbUtilisationAide1")) {
            
            //parcours de toutes les clés
            for (String key : tr.keySet()) {
                //si on trouve l'indicateur nbUtilisationAide1
                if (key.equals("manip1_carte"+numeroCarte+"/nbUtilisationAide1")){
                    listeAideInstru1.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur nbUtilisationAide2
                } else if (key.equals("manip1_carte"+numeroCarte+"/nbUtilisationAide2")){
                    listeAideInstru2.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur nbUtilisationAide3
                } else if (key.equals("manip1_carte"+numeroCarte+"/nbUtilisationAide3")){
                    listeAideExe.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur nbEvitement1
                } else if (key.equals("manip1_carte"+numeroCarte+"/nbUtilisationEvitement1")){
                    listeEvitement1.add(key);//on l'ajoute à la liste
                //si on trouve l'indicateur nbEvitement2
                } else if (key.equals("manip1_carte"+numeroCarte+"/nbUtilisationEvitement2")){
                    listeEvitement2.add(key);//on l'ajoute à la liste
                }
            }
            //on passe à la carte suivante
            numeroCarte++;
        }
        
        //on calcule les moyennes puis on les ajoute à la HashMap
        creerIndicateurMoyenne("Moyenne_NbUtilisationsAide1", listeAideInstru1);
        creerIndicateurMoyenne("Moyenne_NbUtilisationsAide2", listeAideInstru2);
        creerIndicateurMoyenne("Moyenne_NbUtilisationsAideExe", listeAideExe);
        creerIndicateurMoyenne("Moyenne_NbUtilisationsEvitement1", listeEvitement1);
        creerIndicateurMoyenne("Moyenne_NbUtilisationsEvitement2", listeEvitement2);
        
        //on calcule la moyenne du nombre d'utilisation des aides instrumentale (1+2)
        // = somme des moyennes des aides 1 et 2 
        //et on l'ajoute à la hashMap
        List<String> listeAideInstru = new ArrayList<>();
        listeAideInstru.add("Moyenne_NbUtilisationsAide1");
        listeAideInstru.add("Moyenne_NbUtilisationsAide2");
        creerIndicateurSomme("Moyenne_NbUtilisationsAideInstru", listeAideInstru);
        
        // pareil pour les évitements
        // = somme des moyenne des evitements 1 et 2
        List<String> listeAideEvitement = new ArrayList<>();
        listeAideInstru.add("Moyenne_NbUtilisationsEvitement1");
        listeAideInstru.add("Moyenne_NbUtilisationsEvitement2");
        creerIndicateurSomme("Moyenne_NbUtilisationsEvitement", listeAideEvitement);
    }
    /**
     * Calcul des moyennes Bc (A1,A2,B,C)
     * Calcul des moyennes comportement RA par carte
     * puis de la moyenne globale de comportement RA
     */
    public void comportementsRA(){
        int numeroCarte=0;
        
        //listes qui contiendront les indicateurs necessaires aux calculs de moyenne Bc(A1,A2,B,C) Avant et Apres
        List<String> listeBcA1Av = new ArrayList<>();
        List<String> listeBcA2Av = new ArrayList<>();
        List<String> listeBcBAv = new ArrayList<>();
        List<String> listeBcCAv = new ArrayList<>();
        
        List<String> listeBcA1Ap = new ArrayList<>();
        List<String> listeBcA2Ap = new ArrayList<>();
        List<String> listeBcBAp = new ArrayList<>();
        List<String> listeBcCAp = new ArrayList<>();
        
        
        //tant qu'il existe des cartes
        while(tr.containsKey("manip1_carte"+numeroCarte+"/BcA1Avant")) {
            
            //liste qui contiendra les indicateurs pour la moyenne Bc par carte
            List<String> listeRAAv = new ArrayList<>();
            List<String> listeRAAp = new ArrayList<>();
             
            //parcours de toutes les clés
            for (String key : tr.keySet()) {
               
                if (key.equals("manip1_carte"+numeroCarte+"/BcA1Avant")){
                    listeBcA1Av.add(key);//on l'ajoute à la liste
                    listeRAAv.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcA2Avant")){
                    listeBcA2Av.add(key);//on l'ajoute à la liste
                    listeRAAv.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcBAvant")){
                    listeBcBAv.add(key);//on l'ajoute à la liste
                    listeRAAv.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcCAvant")){
                    listeBcCAv.add(key);//on l'ajoute à la liste
                    listeRAAv.add(key);
                
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcA1Apres")){
                    listeBcA1Ap.add(key);//on l'ajoute à la liste
                    listeRAAp.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcA2Apres")){
                    listeBcA2Ap.add(key);//on l'ajoute à la liste
                    listeRAAp.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcBApres")){
                    listeBcBAp.add(key);//on l'ajoute à la liste
                    listeRAAp.add(key);
                } else if (key.equals("manip1_carte"+numeroCarte+"/BcCApres")){
                    listeBcCAp.add(key);//on l'ajoute à la liste
                    listeRAAp.add(key);
                
                } 
            }
            creerIndicateurMoyenne("Moyenne_RACarte"+numeroCarte+"Apres", listeRAAp);//moyenne RA par carte apres
            creerIndicateurMoyenne("Moyenne_RACarte"+numeroCarte+"Avant", listeRAAv);//moyenne RA par carte avant
            indicateurEcart("Moyenne_RACarte"+numeroCarte, "Moyenne_RACarte"+numeroCarte+"Apres", "Moyenne_RACarte"+numeroCarte+"Avant");
            
            //on passe à la carte suivante
            numeroCarte++;
        }
        //moyenne aprés
        creerIndicateurMoyenne("Moyenne_BcA1Apres", listeBcA1Ap);
        creerIndicateurMoyenne("Moyenne_BcA2Apres", listeBcA2Ap);
        creerIndicateurMoyenne("Moyenne_BcBApres", listeBcBAp);
        creerIndicateurMoyenne("Moyenne_BcCApres", listeBcCAp);
        
        //moyenne avant
        creerIndicateurMoyenne("Moyenne_BcA1Avant", listeBcA1Av);
        creerIndicateurMoyenne("Moyenne_BcA2Avant", listeBcA2Av);
        creerIndicateurMoyenne("Moyenne_BcBAvant", listeBcBAv);
        creerIndicateurMoyenne("Moyenne_BcCAvant", listeBcCAv);
        
        //aprés - avant
        indicateurEcart("Moyenne_BcA1", "Moyenne_BcA1Apres", "Moyenne_BcA1Avant");
        indicateurEcart("Moyenne_BcA2", "Moyenne_BcA2Apres", "Moyenne_BcA2Avant");
        indicateurEcart("Moyenne_BcB", "Moyenne_BcBApres", "Moyenne_BcBAvant");
        indicateurEcart("Moyenne_BcC", "Moyenne_BcCApres", "Moyenne_BcCAvant");
        
        //calcul de la moyenne de comportement RA 
        List<String> listeComportementRA = new ArrayList<>();
        
        listeComportementRA.add("Moyenne_BcA1");
        listeComportementRA.add("Moyenne_BcA2");
        listeComportementRA.add("Moyenne_BcB");
        listeComportementRA.add("Moyenne_BcC");
        creerIndicateurMoyenne("Moyenne_ComportementRA",listeComportementRA );
        
    }
    
    /**
     * crée l'indicateur de performance d'apprentissage
     */
    public void perfApprentissage(){
       //performance d'apprentissage =  Ecart entre la moyenne des Notes QCM normalisée apres et la moyenne des notes QCM normalisée avant
        indicateurEcart("perfApprentissage1","manip1_MoyenneQCM_Apres_Normalisee", "manip1_MoyenneQCM_Avant_Normalisee");
            
    }
    /**
     * crée les moyennes des indicateurs de buts d'accomplissement de soi
     * (de maitrise, de performance approche, de performance evitement)
     */
    public void butMaitrisePerformance(){
        List<String> listeBM = new ArrayList<>();
        List<String> listeBPE = new ArrayList<>();
        List<String> listeBPA = new ArrayList<>();
        
        //but de maitrise
        listeBM.add("manip1_motivation/Reponse_q0");
        listeBM.add("manip1_motivation/Reponse_q1");
        listeBM.add("manip1_motivation/Reponse_q7");
        
        //but de performance approche
        listeBPA.add("manip1_motivation/Reponse_q4");
        listeBPA.add("manip1_motivation/Reponse_q5");
        listeBPA.add("manip1_motivation/Reponse_q6");
        
        //but de performance evitement
        listeBPE.add("manip1_motivation/Reponse_q2");
        listeBPE.add("manip1_motivation/Reponse_q3");
        listeBPE.add("manip1_motivation/Reponse_q8");
        
        creerIndicateurMoyenne("Moyenne_BPA", listeBPA);
        creerIndicateurMoyenne("Moyenne_BPE", listeBPE);
        creerIndicateurMoyenne("Moyenne_BM", listeBM);
    }
    
    /**
     * crée les moyennes des indicateurs motivationnel
     * (Besoin d'autonomie, beneficeAide, Image privée image publique)
     */
    public void variableMotivationnelle(){
        List<String> listeBesoin = new ArrayList<>();
        List<String> listeBenefice = new ArrayList<>();
        List<String> listeIprivee = new ArrayList<>();
        List<String> listeIpublique = new ArrayList<>();
        
        //besoin d'autonomie
        listeBesoin.add("manip1_perception_aides/Reponse_q0");
        listeBesoin.add("manip1_perception_aides/Reponse_q4");
        listeBesoin.add("manip1_perception_aides/Reponse_q7");
        
        //bénéfice de l'aide
        listeBenefice.add("manip1_perception_aides/Reponse_q1");
        listeBenefice.add("manip1_perception_aides/Reponse_q3");
        listeBenefice.add("manip1_perception_aides/Reponse_q5");
        
        //Image privée
        listeIprivee.add("manip1_perception_aides/Reponse_q2");
        listeIprivee.add("manip1_perception_aides/Reponse_q6");
        
        //ImagePublique
        listeIpublique.add("manip1_perception_aides/Reponse_q8");
        listeIpublique.add("manip1_perception_aides/Reponse_q9");
        
        creerIndicateurMoyenne("Moyenne_besoinAutonomie", listeBesoin);
        creerIndicateurMoyenne("Moyenne_beneficeAide", listeBenefice);
        creerIndicateurMoyenne("Moyenne_imagePrivée", listeIprivee);
        creerIndicateurMoyenne("Moyenne_imagePublique", listeIpublique);
        
        
    }

    @Override
    public int getSize() {
        return this.tr.size();
    }

    @Override
    public Object getElementAt(int index) {
        return tr.keySet().toArray()[index];
    }

    
}
    
