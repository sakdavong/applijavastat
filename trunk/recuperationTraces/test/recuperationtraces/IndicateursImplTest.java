/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recuperationtraces;

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
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
    
   /* HashMap<String, List<String>> hmp;
    List<String> lst,lst2,lst0,lst1;
    List<String> lst01,lst12,lst10,lst11;
    */
    public IndicateursImplTest() {
        
   /*   hmp=new HashMap();
        lst=new ArrayList<>();
        lst2=new ArrayList<>();
        lst.add("ut1");lst0.add("146");lst1.add("54");lst2.add("51");
        lst.add("ut2");lst0.add("81");lst1.add("146");lst2.add("166");
        lst.add("ut3");lst0.add("158");lst1.add("21");lst2.add("8");
        lst.add("ut4");lst0.add("85");lst1.add("138");lst2.add("128");
        lst.add("ut5");lst0.add("54");lst1.add("95");lst2.add("65");
        
        lst01.add("ut1");lst12.add("146");lst11.add("54");lst10.add("51");
        lst01.add("ut2");lst12.add("81");lst11.add("146");lst10.add("166");
        lst01.add("ut3");lst12.add("158");lst11.add("21");lst10.add("8");
        lst01.add("ut4");lst12.add("85");lst11.add("138");lst10.add("128");
        lst01.add("ut5");lst12.add("54");lst11.add("95");lst10.add("65");
        
        hmp.put("nom",lst);hmp.put("SAECarte0",lst0);hmp.put("SAECarte1",lst1);hmp.put("SAECarte2",lst2);
     */   
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
        
        List<String> ARechercher = new ArrayList<>();
        ARechercher.add("Nom");
        ARechercher.add("test");
        List<String> Nom = new ArrayList<>();
        List<String> test = new ArrayList<>();

        IndicateursImpl instance = new IndicateursImpl();
        instance.getTr().put("Nom", Nom);
        instance.getTr().put("test", test);
        
        IndicateursImpl expResult = instance;
        
        IndicateursImpl result =(IndicateursImpl) instance.creerVueIndicateurs(ARechercher);
        assertEquals(expResult.getTr(), result.getTr());
        
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
        IndicateursImpl instance = new IndicateursImpl();
        
        List<String> lst=new ArrayList<>();
        lst.add("ut1");
        instance.getTr().put("Nom", lst);
        
        instance.afficher();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of supprimerParticipants method, of class IndicateursImpl.
     */
    @Test
    public void testSupprimerParticipants_int() {
        System.out.print("supprimerParticipants => ");
        int indice = 2;
        IndicateursImpl instance = new IndicateursImpl();
        List<String> listeAvant = new ArrayList<>();
        List<String> listeAvant2 = new ArrayList<>();
        List<String> listeAvant3 = new ArrayList<>();
        
        List<String> listeApres = new ArrayList<>();
 
        listeAvant.add("1");listeAvant.add("2");listeAvant.add("3");listeAvant.add("4");listeAvant.add("5");
        listeAvant2.add("1");listeAvant2.add("2");listeAvant2.add("3");listeAvant2.add("4");listeAvant2.add("5");
        listeAvant3.add("1");listeAvant3.add("2");listeAvant3.add("3");listeAvant3.add("4");listeAvant3.add("5");
        
        listeApres.add("1");listeApres.add("2");listeApres.add("4");listeApres.add("5");

        instance.getTr().put("element", listeAvant);
        instance.getTr().put("element2", listeAvant2);
        instance.getTr().put("element3", listeAvant3);

        instance.supprimerParticipants(indice);
        boolean resultat=true;
        for(String key:instance.getTr().keySet()){
            if (!instance.getTr().get(key).equals(listeApres)){
                resultat=false;
            }
        }
        System.out.println(resultat);
        assertEquals(true, resultat);
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
    public void testSauverCharger() {
        System.out.print("sauver => ");
        File monFichier = new File("src/test.dat");
        
        IndicateursImpl instance = new IndicateursImpl();
        IndicateursImpl instanceCharge = new IndicateursImpl();
        
        List<String> liste = new ArrayList<>();
        liste.add("coucou");liste.add("je");liste.add("suis");liste.add("Matthieu");
        instance.getTr().put("cles", liste);
        
        instance.sauver(monFichier);
        instanceCharge.charger(monFichier);
        assertEquals(instance.getTr().get("cles"),instanceCharge.getTr().get("cles"));
        
        // TODO review the generated test code and remove the default call to fail.
       
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
    @Test
    public void testCreerIndicateurMoyenne(){
        System.out.println("creerIndicateurMoyenne");
        
        List<String> listeInd,lst1,lst2,lst3,lst;
        listeInd = new ArrayList<>();
        lst=new ArrayList<>();
        lst1=new ArrayList<>();
        lst2=new ArrayList<>();
        lst3=new ArrayList<>();
        String nom = "moyenne";
        lst.add("ut1");lst.add("ut2");lst.add("ut3");
        lst1.add("2");lst2.add("2");lst3.add("");
        lst1.add("4");lst2.add("2");lst3.add("1");
        lst1.add("1");lst2.add("2");lst3.add("5");
        listeInd.add("ind1");listeInd.add("ind2");listeInd.add("ind3");
        IndicateursImpl instance = new IndicateursImpl();
        instance.getTr().put("ind1", lst1);
        instance.getTr().put("ind2", lst2);
        instance.getTr().put("ind3", lst3);
        instance.getTr().put("Nom", lst);
        instance.creerIndicateurMoyenne(nom, listeInd);
        // TODO review the generated test code and remove the default call to fail.
        instance.afficher();
        
    }
    /**
     * Test of indicateurEcart method, of class IndicateursImpl.
     */
    @Test
    public void testIndicateurEcart() {
        System.out.println("indicateurEcart");
        List<String> lst,lstAvant,lstApres;
        lst=new ArrayList<>();
        lstAvant=new ArrayList<>();
        lstApres=new ArrayList<>();
        String nom = "ecart!!";
        String apres = "apres";
        String avant = "avant";
        lst.add("ut1");lst.add("ut2");
        lstAvant.add("2");lstAvant.add("");
        lstApres.add("3");lstApres.add("");
        IndicateursImpl instance = new IndicateursImpl();
        instance.getTr().put("Nom", lst);
        instance.getTr().put("apres", lstApres);
        instance.getTr().put("avant", lstAvant);
        instance.indicateurEcart(nom, apres, avant);
        instance.afficher();
        
        
    }

    /**
     * Test of creerIndicateurSomme method, of class IndicateursImpl.
     */
    @Test
    public void testCreerIndicateurSomme() {
        System.out.println("creerIndicateurSomme");
        String nom = "somme";
        List<String> listeInd,lst1,lst2,lst3,lst;
        listeInd = new ArrayList<>();
        lst=new ArrayList<>();
        lst1=new ArrayList<>();
        lst2=new ArrayList<>();
        lst3=new ArrayList<>();
        lst.add("ut1");lst.add("ut2");lst.add("ut3");
        lst1.add("2");lst2.add("2");lst3.add("");
        lst1.add("4");lst2.add("2");lst3.add("1");
        lst1.add("1");lst2.add("2");lst3.add("5");
        listeInd.add("ind1");listeInd.add("ind2");listeInd.add("ind3");
        IndicateursImpl instance = new IndicateursImpl();
        instance.getTr().put("ind1", lst1);
        instance.getTr().put("ind2", lst2);
        instance.getTr().put("ind3", lst3);
        instance.getTr().put("Nom", lst);
        instance.creerIndicateurSomme(nom, listeInd);
        // TODO review the generated test code and remove the default call to fail.
        instance.afficher();
    }

    /**
     * Test of moyenneGlobaleNormaliseAvantApres method, of class IndicateursImpl.
     */
    @Test
    public void testMoyenneGlobaleNormaliseAvantApres() {
        System.out.println("moyenneGlobaleNormaliseAvantApres");
        IndicateursImpl instance = new IndicateursImpl();
        instance.moyenneGlobaleNormaliseAvantApres();
        // TODO review the generated test code and remove the default call to fail.
        instance.afficher();
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
        List<String> liste1 = new ArrayList<>();
        List<String> liste2 = new ArrayList<>();
        IndicateursImpl instance = new IndicateursImpl();
        liste1.add("-1");liste2.add("-1");
        liste1.add("0");liste2.add("0");
        liste1.add("2");liste2.add("2");
        liste1.add("5");liste2.add("5");
        liste1.add("-2");
        double expResult1 = 0,expResult2 = 1;
        double result1 = instance.calculerMediane(liste1);
        double result2 = instance.calculerMediane(liste2);
        assertEquals(expResult1, result1,0.0);
        assertEquals(expResult2, result2,0.0);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("resultat attendu: "+expResult1+"/ resultat du teste: "+result1);
        System.out.println("resultat attendu: "+expResult2+"/ resultat du teste: "+result2);
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
