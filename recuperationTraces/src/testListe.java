
import java.util.ArrayList;
import java.util.List;
import recuperationtraces.IndicateursImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthieu
 */
public class testListe {
    
    public static void main (String args[]){
            List<String> liste = new ArrayList<String>();
            IndicateursImpl ind = new IndicateursImpl(null);
            ind.getTr().put("youhou", liste);
            ind.getTr().get("youhou").add("bonjour");
            ind.getTr().get("youhou").add(null);
            String st = null;
            if (st.equalsIgnoreCase("null")){
                ind.getTr().get("youhou").add("coucou");
            }else {
                ind.getTr().get("youhou").add(st);
            }
            ind.getTr().get("youhou").add("suis");
            ind.getTr().get("youhou").add("Matthieu");
            ind.getTr().get("youhou").add("");
            ind.getTr().get("youhou").add("Matthieu");
            ind.afficher();
    }
}


