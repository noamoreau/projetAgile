package main.Consommable;

import main.App;
import main.Joueur;

public class Nourriture extends Consommable{
    
    private int faim;

    public Nourriture(int faim, int prix, String nom){
        super(prix, nom);
        this.faim = faim;
    } 

    public String effet(){
        return "Ceci est un " + this.getNom() + " qui coute " + getPrix() + " pour gagner " + faim +" point de nourriture.";
    }

    public boolean achete() throws InterruptedException{
        if(super.achete()){
            int nouv_faim = App.joueur.getNourriture() + faim;
            App.joueur.setNourriture(nouv_faim);
            return true;
        }
        return false;
        
    }

}
