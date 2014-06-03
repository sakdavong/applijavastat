/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tigro
 */
public class IndicateursImplTest {
    
    public IndicateursImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of creerVueIndicateurs method, of class IndicateursImpl.
     */
    @Test
    public void testCreerVueIndicateurs() {
        System.out.println("creerVueIndicateurs");
        List<String> ARechercher = null;
        IndicateursImpl instance = null;
        Indicateurs expResult = null;
        Indicateurs result = instance.creerVueIndicateurs(ARechercher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerVueValeurs method, of class IndicateursImpl.
     */
    @Test
    public void testCreerVueValeurs() {
        System.out.println("creerVueValeurs");
        String nomIndicateur = "";
        String ValeurContrainte = "";
        String condition = "";
        IndicateursImpl instance = null;
        Indicateurs expResult = null;
        Indicateurs result = instance.creerVueValeurs(nomIndicateur, ValeurContrainte, condition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficher method, of class IndicateursImpl.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        IndicateursImpl instance = null;
        instance.afficher();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerParticipants method, of class IndicateursImpl.
     */
    @Test
    public void testSupprimerParticipants_int() {
        System.out.println("supprimerParticipants");
        int indice = 0;
        IndicateursImpl instance = null;
        instance.supprimerParticipants(indice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerParticipants method, of class IndicateursImpl.
     */
    @Test
    public void testSupprimerParticipants_String() {
        System.out.println("supprimerParticipants");
        String nom = "";
        IndicateursImpl instance = null;
        instance.supprimerParticipants(nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTr method, of class IndicateursImpl.
     */
    @Test
    public void testGetTr() {
        System.out.println("getTr");
        IndicateursImpl instance = null;
        HashMap<String, List<String>> expResult = null;
        HashMap<String, List<String>> result = instance.getTr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTr method, of class IndicateursImpl.
     */
    @Test
    public void testSetTr() {
        System.out.println("setTr");
        HashMap<String, List<String>> tr = null;
        IndicateursImpl instance = null;
        instance.setTr(tr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerMatrice method, of class IndicateursImpl.
     */
    @Test
    public void testCreerMatrice() {
        System.out.println("creerMatrice");
        IndicateursImpl instance = null;
        double[][] expResult = null;
        double[][] result = instance.creerMatrice();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerTable method, of class IndicateursImpl.
     */
    @Test
    public void testCreerTable() {
        System.out.println("creerTable");
        IndicateursImpl instance = null;
        double[] expResult = null;
        double[] result = instance.creerTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sauver method, of class IndicateursImpl.
     */
    @Test
    public void testSauver() {
        System.out.println("sauver");
        File monFichier = null;
        IndicateursImpl instance = null;
        instance.sauver(monFichier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of charger method, of class IndicateursImpl.
     */
    @Test
    public void testCharger() {
        System.out.println("charger");
        File monFichier = null;
        IndicateursImpl instance = null;
        instance.charger(monFichier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculerMoyenneNoteNormalisee method, of class IndicateursImpl.
     */
    @Test
    public void testCalculerMoyenneNoteNormalisee() {
        System.out.println("calculerMoyenneNoteNormalisee");
        IndicateursImpl instance = null;
        instance.calculerMoyenneNoteNormalisee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indicateurEcart method, of class IndicateursImpl.
     */
    @Test
    public void testIndicateurEcart() {
        System.out.println("indicateurEcart");
        String nom = "";
        String apres = "";
        String avant = "";
        IndicateursImpl instance = null;
        instance.indicateurEcart(nom, apres, avant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerIndicateurSomme method, of class IndicateursImpl.
     */
    @Test
    public void testCreerIndicateurSomme() {
        System.out.println("creerIndicateurSomme");
        String nom = "";
        List<String> listeInd = null;
        IndicateursImpl instance = null;
        instance.creerIndicateurSomme(nom, listeInd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moyenneGlobaleNormaliseAvantApres method, of class IndicateursImpl.
     */
    @Test
    public void testMoyenneGlobaleNormaliseAvantApres() {
        System.out.println("moyenneGlobaleNormaliseAvantApres");
        IndicateursImpl instance = null;
        instance.moyenneGlobaleNormaliseAvantApres();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of classerUsers method, of class IndicateursImpl.
     */
    @Test
    public void testClasserUsers() {
        System.out.println("classerUsers");
        IndicateursImpl instance = null;
        instance.classerUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculerMediane method, of class IndicateursImpl.
     */
    @Test
    public void testCalculerMediane() {
        System.out.println("calculerMediane");
        List<String> liste = null;
        IndicateursImpl instance = null;
        double expResult = 0.0;
        double result = instance.calculerMediane(liste);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moyenneVariableAutoEvaluation method, of class IndicateursImpl.
     */
    @Test
    public void testMoyenneVariableAutoEvaluation() {
        System.out.println("moyenneVariableAutoEvaluation");
        IndicateursImpl instance = null;
        instance.moyenneVariableAutoEvaluation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
