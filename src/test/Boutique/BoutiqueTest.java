package test.Boutique;

import main.App;
import main.Joueur;
import main.Boutique.Boutique;
import main.Consommable.Bonheur;
import main.Roulette.Roulette;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BoutiqueTest {

    Boutique b;
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
		b = new Boutique();

        joueurAppInitiale = App.joueur;
        Joueur j1 = new Joueur("test",40,150,30,1);
        App.joueur = j1;
	}

    @AfterEach
	public void afterATest() {
        App.joueur = joueurAppInitiale;
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void acheterNourritureTest() throws InterruptedException{
        b.acheterNourriture(2);
        assertEquals(60,App.joueur.getNourriture());
        assertEquals(50,App.joueur.getArgent());
    }

    @Test
    public void acheterBonheurTest() throws InterruptedException{
        b.acheterBonheur(1);
        assertEquals(40,App.joueur.getBonheur());
        assertEquals(100,App.joueur.getArgent());
    }

    @Test
    public void acheterToutTest() throws InterruptedException{
        b.acheterTout(9);
        assertEquals(40,App.joueur.getNourriture());
        assertEquals(150,App.joueur.getArgent());
    }
}
