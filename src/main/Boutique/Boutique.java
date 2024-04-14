package main.Boutique;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.App;
import main.Bingo.bingo;
import main.Consommable.*;


public class Boutique {
    

    private List<Consommable> consommables;

    public Boutique(){
        this.consommables = new ArrayList<Consommable>();
        this.initialiserConsommable();
    }

    public void initialiserConsommable(){

        this.consommables.add(new Nourriture(10,50,"Terre"));
        this.consommables.add(new Nourriture(20,100,"Legume"));
        this.consommables.add(new Nourriture(30,150,"Pomme de terre"));
        this.consommables.add(new Nourriture(40,250,"Pizza"));
        this.consommables.add(new Nourriture(50,350,"Sushi"));
        this.consommables.add(new Nourriture(60,450,"Steak"));
        this.consommables.add(new Nourriture(70,650,"Kebab"));
        this.consommables.add(new Nourriture(80,850,"Tacos"));
        this.consommables.add(new Nourriture(90,1050,"Raclette"));
        this.consommables.add(new Nourriture(100,1500,"caviar"));
        
        
        

        this.consommables.add(new Bonheur(10,50,"Vetement"));
        this.consommables.add(new Bonheur(20,100,"Jeux"));
        this.consommables.add(new Bonheur(30,150,"Voiture"));
        this.consommables.add(new Bonheur(40,250,"Maison"));
        this.consommables.add(new Bonheur(50,350,"Femme"));
        this.consommables.add(new Bonheur(60,450,"Enfant"));
        this.consommables.add(new Bonheur(70,650,"Voiture de luxe"));
        this.consommables.add(new Bonheur(80,850,"Bateau"));
        this.consommables.add(new Bonheur(90,1050,"Avion"));
        this.consommables.add(new Bonheur(100,1500,"Lune"));
    }

    public static void main(String[] args){
        Boutique b = new Boutique();
        b.afficherMenu();
    }

    public void afficher(Consommable c, int i){
        // System.out.println(c.effet());
        System.out.println("_________________________________________________________________________________________\n");
        System.out.println(i + " | " + c.getNom() + " | " + c.getPrix() + " | " + c.effet());
        
    }

    public void menu() throws InterruptedException{
        char car = ' ';
        do{
            car = afficherMenu();
            if(car != 'q'){
                achat(car);
            }
        }while(car != 'q');
        System.out.println(car);
    }
    
    public char afficherMenu(){
        String car;
        do{
            bingo.clear();
            bingo.afficherTitre("Boutique");
            System.out.println("Bienvenue dans la Boutique.\n"
            + "Içi, vous pouvez acheter: \n"
            + "N - De la nourriture, pour vous nourrir\n"
            + "B - Des biens divers pour vous rendre heureux\n"
            + "T - Afficher tout\n"
            + "Q - Quitter\n");
            car = "" + App.ecouterChar(); 
            car = car.toLowerCase();
        }while(!car.equals("n") && !car.equals("b") && !car.equals("t") && !car.equals("q"));
        return car.charAt(0);
    }

    public void achat(char car) throws InterruptedException{
        
            
        int choix = 21;
        do{
            bingo.clear();
            if(car == 't'){
                this.afficherTout();

                do{
                    System.out.println("Taper le chiffre de ce que vous voulez acheter, ou taper 0 pour revenir en arriere: ");
                    choix = App.scanner.nextInt();
                }while(choix<0 && choix>20);
                if(choix != 0){
                    this.acheterTout(choix);
                }
                

            }else{
                if(car == 'n'){
                    this.afficherNourriture();
                }else if(car == 'b'){
                    this.afficherBonheur();
                }

                do{
                    System.out.println("Taper le chiffre de ce que vous voulez acheter, ou taper 0 pour revenir en arriere: ");
                    choix = App.scanner.nextInt();
                }while(choix<0 && choix>10);
                if(car == 'n'){
                    if(choix != 0){
                        this.acheterNourriture(choix);
                    }
                    
                }else if(car == 'b'){
                    if(choix != 0){
                        this.acheterBonheur(choix);
                    }
                    
                }
            }
        }while(choix != 0);
    }

    public void acheterBonheur(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                i++;
            }
            if(i == j){
                c.achete();
            }
        }
    }

    public void acheterNourriture(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                i++;
            }
            if(i == j){
                c.achete();
            }
        }
    }

    public void acheterTout(int j) throws InterruptedException{
        int i = 0;
        for(Consommable c: this.consommables){
            i++;
            if(i == j){
                c.achete();
            }
        }
    }

    public void afficherNourriture(){
        int i = 1;
        for(Consommable c: this.consommables){
            if(c instanceof Nourriture){
                this.afficher(c,i);
                i++;
            }
        }
        System.out.println("_________________________________________________________________________________________\n");
        System.out.println("Votre argent: " + App.joueur.getArgent() + "€");
    }

    public void afficherBonheur(){
        int i = 1;
        for(Consommable c: this.consommables){
            if(c instanceof Bonheur){
                this.afficher(c,i);
                i++;
            }
        }
        System.out.println("_________________________________________________________________________________________\n");
        System.out.println("Votre argent: " + App.joueur.getArgent() + "€");
    }

    public void afficherTout(){
        int i = 1;
        for(Consommable c: this.consommables){
            this.afficher(c, i);
            i++;
        }
        System.out.println("_________________________________________________________________________________________\n");
        System.out.println("Votre argent: " + App.joueur.getArgent() + "€");
    }
}
