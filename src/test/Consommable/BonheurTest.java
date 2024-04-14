package test.Consommable;

import main.App;
import main.Joueur;
import main.Consommable.Bonheur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BonheurTest {
    
    private Bonheur cloche;
    private Joueur joueurAppInitiale;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start test series");
    }

    @AfterAll
	public static void afterAllTests() {
        System.out.println("End test series");
    }

    @BeforeEach
	public void beforeATest() {
		cloche = new Bonheur(10, 30, "cloche");

        joueurAppInitiale = App.joueur;
        Joueur j1 = new Joueur("test",40,50,30,1);
        App.joueur = j1;
	}

    @AfterEach
	public void afterATest() {
        App.joueur = joueurAppInitiale;
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void effetTest(){
        assertEquals("Ceci est un cloche qui coute 30 pour gagner 10 point de bonheur.",cloche.effet());
    }

    @Test
    public void acheteTest() throws InterruptedException{
        assertTrue(cloche.achete());
        assertEquals(40,App.joueur.getBonheur());
        assertEquals(20,App.joueur.getArgent());
        assertFalse(cloche.achete());
        assertEquals(40,App.joueur.getBonheur());
        assertEquals(20,App.joueur.getArgent());
    }
}