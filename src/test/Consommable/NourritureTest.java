package test.Consommable;

import main.App;
import main.Joueur;
import main.Consommable.Nourriture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class NourritureTest {
    
    private Nourriture pizza;
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
		pizza = new Nourriture(10, 30, "pizza");

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
        assertEquals("Ceci est un pizza qui coute 30 pour gagner 10 point de nourriture.",pizza.effet());
    }

    @Test
    public void acheteTest() throws InterruptedException{
        assertTrue(pizza.achete());
        assertEquals(50,App.joueur.getNourriture());
        assertEquals(20,App.joueur.getArgent());
        assertFalse(pizza.achete());
        assertEquals(50,App.joueur.getNourriture());
        assertEquals(20,App.joueur.getArgent());
    }
}