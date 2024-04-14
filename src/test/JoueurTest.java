package test;

import static org.junit.Assert.assertTrue;



import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;

public class JoueurTest {
    Joueur j1;

    @BeforeEach
    public void testInitialization(){
        j1 = new Joueur("test");
    }

    @Test
    public void testSauvegarderCharger(){
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + j1.getNom() + ".csv");
        j1.setArgent(100);
        j1.setNourriture(100);
        j1.setBonheur(100);
        j1.setNbJours(1);
        j1.sauvegarder();
        assertTrue(file.exists());
        j1.charger();
        assertTrue(100 == j1.getArgent());
        assertTrue(100 == j1.getNourriture());
        assertTrue(100 == j1.getBonheur());
        assertTrue(1 == j1.getNbJours());
        j1.setArgent(70);
        j1.setNourriture(90);
        j1.setBonheur(80);
        j1.setNbJours(8);
        j1.sauvegarder();
        j1.charger();
        assertTrue(70 == j1.getArgent());
        assertTrue(90 == j1.getNourriture());
        assertTrue(80 == j1.getBonheur());
        assertTrue(8 == j1.getNbJours());
    }

    @Test
    public void testJourPasse(){
        j1.setBonheur(100);
        j1.setNourriture(100);
        j1.jourPasse();
        assertTrue(j1.getBonheur() == 90);
        assertTrue(j1.getNourriture() == 90);
        j1.jourPasse();
        assertTrue(j1.getBonheur() == 80);
        assertTrue(j1.getNourriture() == 76);
    }

    @Test
    public void testAddNbJours(){
        j1.setNbJours(1);
        j1.addNbJours();
        j1.addNbJours();
        assertTrue(3 == j1.getNbJours());
    }
}

