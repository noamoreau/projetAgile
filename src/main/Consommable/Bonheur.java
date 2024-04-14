package main.Consommable;

import main.App;
import main.Joueur;

public class Bonheur extends Consommable{
    
    private int bonheur;

    public Bonheur(int bonheur, int prix, String nom){
        super(prix, nom);
        this.bonheur = bonheur;
    }

    public String effet(){
        return "Ceci est un " + this.getNom() + " qui coute " + getPrix() + " pour gagner " + bonheur +" point de bonheur.";
    }

    public boolean achete() throws InterruptedException{
        if(super.achete()){
            int nouv_bonheur = App.joueur.getBonheur() + bonheur;
            App.joueur.setBonheur(nouv_bonheur);
            return true;
        }
        return false;
    }
}
