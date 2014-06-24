/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

/**
 *
 * @author JCSakdavong
 */
// Cette classe est un exemple d'implantation de RMainLoopCallbacks
// Vous devrez implanter cette interface dans une de votre classe IHM si vous souhaitez d'afficher les réponses de R à l'écran.
// Dans cet exemple, les réponses de R sont toutes affichées avec l'instruciton System.out.println(s)

// Le parametre rEngine recu chaque fois en parametre correspond au moteur de calcul de R avec lequel il est aussi possible d'interagir ici.

public class TextConsoleExemple implements RMainLoopCallbacks {
    

    public TextConsoleExemple() {
        
    }

    // Affichage provoqué par R pour une sortie écran
    public void rWriteConsole(Rengine re, String text, int oType) {
        System.out.print("==>" + text);
    }

    // Affichage provoqué par R pour un message indiquant qu'il fait un calcul
    public void rBusy(Rengine re, int which) {
        System.out.println("==>rBusy(" + which + ")");
    }

    // Affichage provoqué par R pour demande à l'utilisateur de taper une valeur
    public String rReadConsole(Rengine re, String prompt, int addToHistory) {
        System.out.print("==>" + prompt);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            return (s == null || s.length() == 0) ? s : s + "\n";
        } catch (Exception e) {
            System.out.println("==>jriReadConsole exception: " + e.getMessage());
        }
        return null;
    }

    // Affichage provoqué par R pour afficher un message d'alerte
    public void rShowMessage(Rengine re, String message) {
        System.out.println("==>rShowMessage \"" + message + "\"");
    }

    // Demande d'un fichier par R
    public String rChooseFile(Rengine re, int newFile) {
        FileDialog fd = new FileDialog(new Frame(), (newFile == 0) ? "Select a file" : "Select a new file", (newFile == 0) ? FileDialog.LOAD : FileDialog.SAVE);
        fd.setVisible(true);
        String res = null;
        if (fd.getDirectory() != null) {
            res = fd.getDirectory();
        }
        if (fd.getFile() != null) {
            res = (res == null) ? fd.getFile() : (res + fd.getFile());
        }
        return res;
    }

    public void rFlushConsole(Rengine re) {
    }

    public void rLoadHistory(Rengine re, String filename) {
    }

    public void rSaveHistory(Rengine re, String filename) {
    }
    
}
