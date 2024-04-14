package main.Lotterie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.App;
import main.Jeu;
import main.Bingo.bingo;


public class Lotterie implements Jeu{

    private List<Integer> boules;
    private List<Integer> predictionBoules;
    private List<Integer> tirages;

    private static int ammende = 1_000;
    private static int nb_trouver = 0;
    private static int max_boules = 45;
    private final static int PRIX = 5_000;
    private final static int PRIX_TICKET = 5;
    private final static int DUREE = 24;
    private final static Random RAND = new Random();

    public Lotterie() {
        this.predictionBoules = new ArrayList<>();
        this.boules = new ArrayList<>();
        for (int number = 1; number < 46; number++) {
            boules.add(number);
        }
    }

    

    public static int getMax_boules() {
        return max_boules;
    }

    public static void setMax_boules(int max_boules) {
        Lotterie.max_boules = max_boules;
    }



    public List<Integer> getBoules() {
        return boules;
    }

    public List<Integer> getPredictionBoules() {
        return predictionBoules;
    }

    public List<Integer> getTirages() {
        return tirages;
    }

    public void input_user() {
        boolean bon_input;
        int boule1 = 0;
        int boule2 = 0;
        int boule3 = 0;
        int boule4 = 0;
        int boule5 = 0;
        int boule6 = 0;
        do {
            bon_input = true;
            System.out.println("Entrez les 6 numeros (un par un)");
            
            boule1 = App.scanner.nextInt();
            boule2 = App.scanner.nextInt();
            boule3 = App.scanner.nextInt();
            boule4 = App.scanner.nextInt();
            boule5 = App.scanner.nextInt();
            boule6 = App.scanner.nextInt();
            if(0 < boule1 && boule1 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 1 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule2 && boule2 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 2 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule3 && boule3 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 3 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule4 && boule4 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 4 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule5 && boule5 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 5 n'est pas comprise entre 1 et 45");
            }
            if(0 < boule6 && boule6 < (Lotterie.getMax_boules()+1)) {
                bon_input = bon_input && true;
            }
            else {
                bon_input = false;
                System.out.println("La boule numéro 6 n'est pas comprise entre 1 et 45");
            }
        }while(!bon_input);
        this.predictionBoules.add(boule1);
        this.predictionBoules.add(boule2);
        this.predictionBoules.add(boule3);
        this.predictionBoules.add(boule4);
        this.predictionBoules.add(boule5);
        this.predictionBoules.add(boule6);     
    }



    public void tirage() {
        int i = 0;
        List<Integer> tirer = new ArrayList<>();
        while (tirer.size() != 6) {
            int tirage = RAND.nextInt(Lotterie.getMax_boules()-i);
            i++;
            int boule_tirer = this.getBoules().remove(tirage);
            tirer.add(boule_tirer);
        }
        this.tirages = tirer;
    }

    @Override
    public void tricher() {
        System.out.println("Vous êtes fait attraper Vous devez payez " + Lotterie.ammende + "€");
        App.joueur.setArgent(App.joueur.getArgent() - Lotterie.ammende);
    }

    @Override
    public void jouer() {
        char c;
        boolean triche = false;
        boolean trouver = true;
        boolean continuer = true;
        bingo.afficherTitre("Loterie");
        while(continuer){
            App.clear();
            System.out.println("Voulez vous les regles du jeu (o/n) ?");
            c = App.ecouterChar();
            if (c == 'o') {
                bingo.afficherRegle("Loterie");
                continuer = false;
            }else if (c =='n') {
                continuer = false;
            }
        }
        while(continuer){
            App.clear();
            System.out.println("Voulez vous entrez le ticket coûte " + Lotterie.PRIX_TICKET +"€ (o/n)");
            c = App.ecouterChar();
            if (c == 'o') {
                App.joueur.setArgent(App.joueur.getArgent() - Lotterie.PRIX_TICKET);
                continuer = false;
            }else if (c =='n') {
                return;
            }
        }
        baisserTemps();
        continuer = true;
        String z = "";
        while(continuer){
            App.clear();
            System.out.println("Voulez vous tricher (t)");
            System.out.println("Voulez vous voir les régles (r)");
            System.out.println("Voulez vous continuer (c)");
            c = App.ecouterChar();
            if (c == 't') {
                triche = true;
                System.out.println("Vous êtes sur que les nombres seronts inférieur de 26");
                continuer = false;
            }else if (c =='c') {
                continuer = false;
            }else if(c == 'r'){
                bingo.afficherRegle("Loterie");
                while(!z.equals("q")){
                    System.out.println("\nAppuyer sur q pour quitter");
                    z = App.scanner.next();
                }
            }
        }
        if (triche) {
            if (RAND.nextInt(4) != 1) {
                Lotterie l = new Lotterie();
                Lotterie.setMax_boules(25);
                l.input_user();
                l.tirage();
                System.out.println("Le tirages est:" + l.getTirages());
                System.out.println("Votre prédiction est:" + l.getPredictionBoules());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {}
                for (Integer integer : l.getTirages()) {
                    if (l.getPredictionBoules().contains(integer)){
                        trouver = trouver && true;
                        Lotterie.nb_trouver++;
                    }
                    else {
                        trouver = false;
                    }
                }
                if (trouver) {
                    this.victoire();
                }else {
                    this.defaite();
                }
            }else{
                this.tricher();
                this.defaite();
            }
        }else {
            Lotterie l = new Lotterie();
            l.input_user();
            l.tirage();
            System.out.println("Le tirages est:" + l.getTirages());
            System.out.println("Votre prédiction est:" + l.getPredictionBoules());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {}
            for (Integer integer : l.getTirages()) {
                if (l.getPredictionBoules().contains(integer)){
                    trouver = trouver && true;
                    Lotterie.nb_trouver++;
                }
                else {
                    trouver = false;
                }
            }
            if (trouver) {
                this.victoire();
            }else {
                this.defaite();
            }
        }
        
    }

    @Override
    public void victoire() {
        App.joueur.setBonheur(App.joueur.getBonheur() - 10);
        App.joueur.setBonheur(App.joueur.getBonheur() + 10);
        int argent = Lotterie.PRIX;
        if (Lotterie.nb_trouver == 6) {
            System.out.println("Bravo vous avez gagner " + argent +"€");
            System.out.println("Vous avez " + App.joueur.getArgent() + "€");
            App.joueur.setArgent(App.joueur.getArgent() + argent);
        } else if (Lotterie.nb_trouver == 5) {
            System.out.println("Bravo vous avez gagner " +((int) (argent*0.75)) +"€");
            System.out.println("Vous avez " + App.joueur.getArgent() + "€");
            App.joueur.setArgent(App.joueur.getArgent() + ((int) (argent*0.75)));
        } else if (Lotterie.nb_trouver == 4) {
            System.out.println("Bravo vous avez gagner " +((int) (argent*0.5)) +"€");
            System.out.println("Vous avez " + App.joueur.getArgent() + "€");
            App.joueur.setArgent(App.joueur.getArgent() + ((int) (argent*0.5)));
        } else if (Lotterie.nb_trouver == 3) {
            System.out.println("Bravo vous avez gagner " +((int) (argent*0.25)) +"€");
            System.out.println("Vous avez " + App.joueur.getArgent() + "€");
            App.joueur.setArgent(App.joueur.getArgent() + ((int) (argent*0.25)));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void defaite() {
        System.out.println("Dommage vous avez perdu");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }

    @Override
    public void baisserTemps() {
        App.jour.moinsTempsJour(Lotterie.DUREE);
    }

    @Override
    public int duree() {
        return Lotterie.DUREE;
    }

    public String toString(){
        return "Lotterie";
    }
}