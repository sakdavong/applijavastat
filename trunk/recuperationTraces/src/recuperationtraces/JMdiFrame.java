package recuperationtraces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JMdiFrame extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu mnuFile = new JMenu("Fichier");
    JMenuItem mnuNewFile = new JMenuItem("Nouveau Fichier");
    JMenu mnuEdit = new JMenu("Edition");
    JMenuItem mnuUndo = new JMenuItem("Undo");
    JMenuItem mnuRedo = new JMenuItem("Redo");
    JMenuItem mnuCopy = new JMenuItem("Copy");
    JMenuItem mnuCut = new JMenuItem("Cut");
    JMenuItem mnuPaste = new JMenuItem("Paste");
    JMenuItem mnuOpenFile = new JMenuItem("Ouvrir Fichier...");
    JMenuItem mnuSaveFile = new JMenuItem("Savuvegarder Fichier ...");
    JMenuItem mnuSaveFileAs = new JMenuItem("Savuvegarder Fichier Sous ...");
    JMenu mnuHelp = new JMenu("Aide");

    /** Methode de construction de la barre de menu */
    private void createMenuBar() {
        this.setJMenuBar(menuBar);
        mnuFile.add(mnuNewFile);
        mnuFile.add(mnuOpenFile);
        mnuFile.add(mnuSaveFile);
        mnuFile.add(mnuSaveFileAs);
        mnuEdit.add(mnuUndo);
        mnuEdit.add(mnuRedo);
        mnuEdit.addSeparator();
        mnuEdit.add(mnuCopy);
        mnuEdit.add(mnuCut);
        mnuEdit.add(mnuPaste);

        menuBar.add(mnuFile);
        menuBar.add(mnuEdit);
        menuBar.add(mnuHelp);
    }

    /** Construction de l'interface graphique */
    public JMdiFrame() {
        // Mise en place du conteneur de sous-fenêtres
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.gray);
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);

        // Construction de la barre de menu
        this.createMenuBar();

        // Creation d'une sous-fenêtre
        JInternalFrame f2 = new JInternalFrame("fenêtre console1",true,true,true,true);
        f2.setSize(300,200);
        f2.setVisible(true);
        f2.setResizable(true);
        f2.setLocation(20,20);
        desktopPane.add( f2 );

        // Creation d'une autre sous-fenêtre
        JInternalFrame f1 = new JInternalFrame("fenêtre Graphique1",true,true,true,true);
        f1.setSize(300,200);
        f1.setVisible(true);
        f1.setResizable(true);
        desktopPane.add( f1 );

        // Autres Décorations
         // Creation d'une sous-fenêtre
        JInternalFrame f3 = new JInternalFrame("fenêtre console 2",true,true,true,true);
        f3.setSize(300,200);
        f3.setVisible(true);
        f3.setResizable(true);
        f3.setLocation(20,20);
        desktopPane.add( f3 );

        // Creation d'une autre sous-fenêtre
        JInternalFrame f4 = new JInternalFrame("fenêtre Graphique 2",true,true,true,true);
        f4.setSize(300,200);
        f4.setVisible(true);
        f4.setResizable(true);
        desktopPane.add( f4 );

        // Autres Décorations
        
        contentPane.add(new JLabel("La barre de status"), BorderLayout.SOUTH);

        this.setSize(500,400);

        // Quelques évènements
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JMdiFrame frame = new JMdiFrame();
        frame.setVisible(true);
    }
}
