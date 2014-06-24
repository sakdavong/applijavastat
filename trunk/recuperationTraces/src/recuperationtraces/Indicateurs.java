/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.util.HashMap;
import java.util.List;


/**
 * spécification de la structure de données qui contiendra les traces
 * @author Matthieu et Said
 * la classe qui implementera cette interface héritera de HashMap
 * clé : nom de l'indicateur
 * valeur : une liste des valeurs de cet indicateur
 */

public interface Indicateurs {
    
    /**
     * Crée une HashMap d'indicateurs qui contiendra une partie de la HashMap initiale
     * permet de regrouper dans une "sous-HashMap" une liste d'indicateurs
     * @param ARechercher la liste des indicateurs à mettre dans la vue
     * @return HashMap contenant la vue
     * @exemple les SAE
     */
    public Indicateurs creerVueIndicateurs ( List<String> ARechercher);
    
    /**
     * Crée une HashMap d'indicateurs qui contiendra une partie de la HashMap initiale
     * permet de regrouper dans une "sous-HashMap" les indicateurs qui vérifient la condition
     * @param nomIndicateur l'indicateur concerné par la contrainte
     * @param ValeurContrainte la valeur qui définit la contrainte
     * @param condition la condition de la contrainte : =, >, <, >=, <=
     * @return HashMap contenant la vue
     * @exemple les participants qui ont lu l'introduction en moins de 10 secondes
     * @exemple les participants qui ont eu l'aide Scaffolding
     */
    public Indicateurs creerVueValeurs (String nomIndicateur, String ValeurContrainte, String condition);
    
    
    /**
     * Crée une matrice à partir des données de la HashMap
     * qui sera utilisable par R
     * @return la matrice
     */
    //public double[][] creerMatrice();
    
    /**
     * Crée une table à partir des données de la HashMap
     * qui sera utilisable par R 
     * Dans le cas, où la HashMap ne contient q'une ligne
     * @return la table
     */
    //public double[] creerTable();
    
    /**
     * Crée une fenetre qui affiche la HashMap
     * permettra de consulter les données contenues dans la HashMap
     */
    public void afficher();
    
    /**
     * supprime le participant
     * @param indice l'indice du participant à supprimer (ou nom du participant)
     */
    public void supprimerParticipants(int indice);
    
    public void setTr(HashMap<String, List<String>> tr);
    public HashMap<String, List<String>> getTr();
    /**
     * pour ajouter un indicateur nous utiliserons la méthode put de la classe Hashmap
     * pour supprimer un indicateur nous utiliserons la méthode remove de la classe Hashmap
     * on pourra créer des copies d'une HashMap grace à la methode clone
     */
    
    
}

