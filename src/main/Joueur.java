package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import main.Bingo.bingo;

public class Joueur {
    private String nom;
    private int nourriture;
    private int argent;
    private int bonheur;
    private int nbJours;

    public Joueur(String nom, int nourriture, int argent, int bonheur, int nbJours) {
        this.nom = nom;
        this.nourriture = nourriture;
        this.argent = argent;
        this.bonheur = bonheur;
        this.nbJours = nbJours;
    }

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void jourPasse(){
        this.nourriture -= 10 + Math.ceil(10 * (1 - this.bonheur/100.0) * 4);
        this.bonheur -= 10;
    }

    

    public String getNom() {
        return nom;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNourriture() {
        return nourriture;
    }

    public void setNourriture(int nourriture) {
        this.nourriture = nourriture;
        if(this.nourriture < 0){
            this.nourriture = 0;
        }else if(this.nourriture > 100){
            this.nourriture = 100;
        }
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getBonheur() {
        return bonheur;
    }

    public void setBonheur(int bonheur) {
        this.bonheur = bonheur;
        if(this.bonheur < 0){
            this.bonheur = 0;
        }else if(this.bonheur > 100){
            this.bonheur = 100;
        }
    }

    public void sauvegarder(){
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + this.nom + ".csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("" + argent);
            bw.newLine();
            bw.write("" + nourriture);
            bw.newLine();
            bw.write("" + bonheur);
            bw.newLine();
            bw.write("" + nbJours);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier " + file + " : " + e.getMessage());
        }
    }

    public void charger(){
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + this.nom + ".csv");
        try(Scanner scan = new Scanner(file)){
            System.out.println("Heureux de te revoir " + this.nom);
            scan.useDelimiter("\n");
            this.argent = Integer.valueOf(scan.next());
            this.nourriture = Integer.valueOf(scan.next());
            this.bonheur = Integer.valueOf(scan.next());
            this.nbJours = Integer.valueOf(scan.next());
        }catch(FileNotFoundException e){
            System.out.println("Ahh un nouveau joueur soit le bienvenu !!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            this.argent = 100;
            this.nourriture = 100;
            this.bonheur = 100;
            this.nbJours = 1;
            App.clear();
            bingo.afficherRegle("Jeu");
        }
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public void addNbJours() {
        this.nbJours++;
    }
}
