/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rjava.acces;

import java.io.IOException;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RFactor;
import org.rosuda.JRI.RList;
import org.rosuda.JRI.*;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

/**
 *
 * @author JCSakdavong
 */
public class ClientR 
{
    Rengine rengine; // La référence au moteur de calcul R

    // Constructeur qui initialise R
    public ClientR(RMainLoopCallbacks textConsole) throws IOException 
    {
        if (!Rengine.versionCheck()) {
	    System.err.println("Mauvaise librairie choisie");
            System.exit(0);
        }
        rengine=new Rengine(null, false, textConsole);
        // Vérification du démarrage de R
        if (!rengine.waitForR()) 
        {
            System.out.println("Cannot load R");
            System.exit(0);
        }

    }
    
    public Rengine getEngine()
    {
        return rengine;
    }
}
