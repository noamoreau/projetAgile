package main.Consommable;

import main.App;
import main.Joueur;

public class Consommable {
    
    private int prix;
    private String nom;

    public Consommable(int prix, String nom){
        this.prix = prix;
        this.nom = nom;
    }

    public String effet(){
        return "ceci est un " + nom + " qui coute " + prix;
    }

    public boolean achete() throws InterruptedException{
        
        int argent_restant = App.joueur.getArgent() - prix;
        if(argent_restant >= 0){
           App.joueur.setArgent(argent_restant);
           System.out.println("Merci d'avoir acheté l'article " + nom);
           Thread.sleep(2000);
           return true;
        }else{
            System.out.println("tu n'as pas assez d'argent le pauvre");
            Thread.sleep(2000);
        }
        return false;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
