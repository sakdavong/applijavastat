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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

//teste SVN

public class IndicateursImpl implements Indicateurs {
    
    private HashMap<String, List<String>> tr;
    
    Racine r;
    
    /**
     * ce constructeur utilise les données directement renvoyé du serveur
     * @param r la racine de l'application
     */
    public IndicateursImpl(Racine r) {
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
    public IndicateursImpl(Racine r,Indicateurs i ) {
        this.r=r;
        this.tr=i.getTr();
    }
    
    @Override
    public Indicateurs creerVueIndicateurs(List<String> ARechercher) {
        //nouvel indicateurImpl qui contiendra la vue
        IndicateursImpl indTemp = new IndicateursImpl(r);
        
        return indTemp;
    }

    @Override
    public Indicateurs creerVueValeurs(String nomIndicateur, String ValeurContrainte, String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        System.out.println (tr.get(key).size());
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
        for(String key:tr.keySet()){
            tr.get(key).remove(indice);
        }
    }
    public void supprimerParticipants(String nom) {
        for(String key:tr.keySet()){
            tr.get(key).remove(nom);
        }
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
     * recherche les notes normalisées Avant et Apres de chaque carte
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
    private void creerIndicateurMoyenne(String nom, List<String> listeInd){
        // tableau qui contiendra les sommes des indicateurs
        double[] somme = new double[tr.get("Nom").size()];
        
        //parcours de la liste d'indicateurs passé en arguments
        for(String ind:listeInd){
            //parcours de la liste de valeurs 
            for(int i=0;i<tr.get(ind).size();i++){
                //si la valeur n'est pas vide
                if(!tr.get(ind).get(i).equals(""))
                    //on l'ajoute au tableau des sommes
                    somme[i]+=Double.parseDouble(tr.get(ind).get(i));
            }
        }
        
        //on ajoute un indicateur dans la hashMap avec une liste vide en valeur
        tr.put(nom, new ArrayList<String>());
        //on ajoute dans cette liste les valeurs des moyennes
        for(int i=0;i<tr.get("Nom").size();i++){
            tr.get(nom).add(String.valueOf(somme[i]/listeInd.size()));
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
            if(!tr.get(apres).get(i).equals("")||!tr.get(avant).get(i).equals("")) 
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
        creerIndicateurMoyenne("manip1_MoyenneQCM_Apres_Normalisee",noteNormAvant);
        
    }
    /**
     * classe les utilisateurs en deux catégories par rapport à la médianne des notes avant
     * crée un nouvel indicateurs qui pourra contenir deux valeurs faible ou fort
     */
    public void classerUsers() {
        
    }
}
