package com.junit;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class CalculTest {

    Calcul calcul;

    ICalculService calculService;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("BeforeAll");
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("AfterAll");
    }

    /**
     * Après le test, il faut aussi fermer certaines ressources : connexion
     * à une base de données, socket...
     *
     * On peut utiliser les méthodes setUp() et tearDown() qui sont
     * respectivement exécutées avant et après l’appel de chaque
     * méthode de test.
     */

    @BeforeEach
    void setUp() throws Exception {
        calculService = mock(ICalculService.class);
        calcul = new Calcul(calculService);
        when(calculService.carre(2)).thenReturn(3);
        when(calculService.carre(3)).thenReturn(10);
    }
    @AfterEach
    void tearDown() throws Exception {
        calcul = null;
        calculService = null;
    }

    @Test
    void testSommeCarre() {
        assertTrue(calcul.sommeCarre(2,3) == 13,"calcul doesn't correct");
    }

    @Test
    void testSomme() {
        if(calcul.somme(2,3)!=13) fail("faux pour deux entiers positifs");
        if(calcul.somme(-2,-3)!=-5) fail("faux pour deux entiers negatifs");
        if(calcul.somme(-2,3)!=1) fail("faux pour deux entiers de signe different");
        if(calcul.somme(0,3)!=3) fail("faux pour x nul");
        if(calcul.somme(2,0)!=2) fail("faux pour y nul");
        if(calcul.somme(0,0)!=0) fail("faux pour x et y nuls");
    }
    @Test
    void testDivision() {
        assertFalse(calcul.division(6,3) == 0,"2entiers positifs");
        assertEquals(calcul.division(-6,-3),2,"2entiers negatifs");
        assertNotNull(calcul.division(-6,3),"2 entiers de signe different" );
        assertTrue(calcul.division(0,3) == 0,"entier x nul");
        Throwable e = null;
        try {
            calcul.division(2,0);
        }
        catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof ArithmeticException);
        e = null;
        try {
            calcul.division(0,0);
        }
        catch (Throwable ex) {
            e = ex;
        }
        assertTrue(e instanceof ArithmeticException);
    }
}
