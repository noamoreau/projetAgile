package main.Roulette;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import main.App;
import main.Jeu;
import main.Bingo.bingo;

public class Roulette implements Jeu{
    
    private static int resultat;
    private final static int DUREE = 6;
    private static String pari;
    private static int argentParier;
    private static List<Integer> black = Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35);
    private static List<Integer> red = Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36);
    private final static Random RAND = new Random();

    public Roulette(){
        Random rand = new Random();
        resultat = rand.nextInt(37);
    }

    public static void Pari(){
        String choix = "";
        boolean fin = false;
        do{
            fin = false;
            affichageTable();
            System.out.println("\nLes chiffres noirs sont les chiffres 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35"
            + "\n" + "Les chiffres rouges sont les chiffres 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36 \n");

            System.out.println("Vous pouvez parier sur: " + "\n" + "- Un chiffre (taper le numéro du chiffre)" 
            + "\n" + "Les chiffres noirs sont les chiffres 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35"
            + "\n" + "Les chiffres rouges sont les chiffres 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36"
            + "\n" + "- Une couleur (taper noir ou rouge)" 
            + "\n" + "- Un nombres pair et impair (taper pair ou impair)" 
            + "\n" + "- Une moitié (taper moitie1 pour les chiffre de 1 à 18, et moitie2 pour les nombres de 19 à 36)" 
            + "\n" + "- Une colonne (taper colonne1, colonne2 ou colonne3)"
            + "\n" + "- Un tiers (taper tiers1, tiers2, tiers3)");
            choix = App.scanner.next();
            Boolean nombreValide = false;
            try{
                nombreValide = Integer.parseInt(choix) >= 0 && Integer.parseInt(choix) <=36;
            }catch(NumberFormatException e){

            }
            if(choix.equals("noir") || choix.equals("rouge") || choix.equals("pair") || choix.equals("impair") || choix.equals("colonne1") || choix.equals("colonne2") || choix.equals("colonne3") || choix.equals("moitie1") || choix.equals("moitie2") || choix.equals("tiers1") || choix.equals("tiers2") || choix.equals("tiers3") || nombreValide){
                fin = true;
                pari = choix;
                do{
                    System.out.println("metter combien d'argent");
                    argentParier = App.scanner.nextInt();
                }while(argentParier < 0 && App.joueur.getArgent() > argentParier);
                App.joueur.setArgent(App.joueur.getArgent()-argentParier);
            }else{
                System.out.println("Le pari n'est pas valide");
            }
        }while(!fin);
        boolean continuer = true;
        char c;
        App.clear();
        while(continuer){
            System.out.println("Voulez vous tricher (o/n)");
            c = App.ecouterChar();
            App.clear();
            if (c == 'o') {
                new Roulette().tricher();
                continuer = false;
            }else if (c =='n') {
                continuer = false;
            }
        }
    }

    public static int Gain(){
        if(pari.equals("noir")){
            if(black.contains(resultat)){
                return argentParier * 2;
            }
        }else if(pari.equals("rouge")){
            if(red.contains(resultat)){
                return argentParier * 2;
            }
        }else if(pari.equals("pair")){
            if(resultat % 2 == 0){
                return argentParier * 2;
            }
        }else if(pari.equals("impair")){
            if(resultat % 2 != 0){
                return argentParier * 2;
            }
        }else if(pari.equals("moitie1")){
            if(resultat > 0 && resultat < 19){
                return argentParier * 2;
            }
        }else if(pari.equals("moitie2")){
            if(resultat > 18 && resultat < 37){
                return argentParier * 2;
            }
        }else if(pari.equals("colonne1")){
            if(resultat % 3 == 1){
                return argentParier * 3;
            }
        }else if(pari.equals("colonne2")){
            if(resultat % 3 == 2){
                return argentParier * 3;
            }
        }else if(pari.equals("colonne3")){
            if(resultat % 3 == 0){
                return argentParier * 3;
            }
        }else if(pari.equals("tiers1")){
            if(resultat > 0 && resultat < 13){
                return argentParier * 3;
            }
        }else if(pari.equals("tiers2")){
            if(resultat > 12 && resultat < 25){
                return argentParier * 3;
            }
        }else if(pari.equals("tiers3")){
            if(resultat > 24 && resultat < 37){
                return argentParier * 3;
            }
        }else if(Integer.parseInt(pari) == resultat){
            return argentParier * 36;
        }
        return 0;
    }

    public static void affichageTable(){
        System.out.println("                          __________ ");
        System.out.println("                          |   0    |  ");
        System.out.println("                 |----------------------------|");
        System.out.println("                 |        |"+Colors.setColor("red")+"1"+Colors.resetColor()+" |"+Colors.setColor("grey")+"2"+Colors.resetColor()+" |"+Colors.setColor("red")+"3"+Colors.resetColor() + " |          |");
        System.out.println("                 |        |"+Colors.setColor("grey")+"4"+Colors.resetColor() +" |"+Colors.setColor("red")+"5"+Colors.resetColor()+" |"+Colors.setColor("grey")+"6"+Colors.resetColor() +" |          |");
        System.out.println("                 | tiers1 |"+Colors.setColor("red")+"7"+Colors.resetColor()+" |"+Colors.setColor("grey")+"8"+Colors.resetColor() +" |"+Colors.setColor("red")+"9"+Colors.resetColor() + " |          |");
        System.out.println("                 |        |"+Colors.setColor("grey")+"10"+Colors.resetColor()+"|"+Colors.setColor("grey")+"11"+Colors.resetColor()+"|"+Colors.setColor("red")+"12"+Colors.resetColor()+"|  moitie1 |");
        System.out.println("                 |-----------------|          | ");
        System.out.println("                 |        |"+Colors.setColor("grey")+"13"+Colors.resetColor()+"|"+Colors.setColor("red")+"14"+Colors.resetColor()+"|"+Colors.setColor("grey")+"15"+Colors.resetColor()+"|          |");
        System.out.println("                 | tiers2 |"+Colors.setColor("red")+"16"+Colors.resetColor()+"|"+Colors.setColor("grey")+"17"+Colors.resetColor()+"|"+Colors.setColor("red")+"18"+Colors.resetColor()+"|          |");
        System.out.println("                 |        |-------------------| ");
        System.out.println("                 |        |"+Colors.setColor("red")+"19"+Colors.resetColor()+"|"+Colors.setColor("grey")+"20"+Colors.resetColor()+"|"+Colors.setColor("red")+"21"+Colors.resetColor()+"|          |");
        System.out.println("                 |        |"+Colors.setColor("grey")+"22"+Colors.resetColor()+"|"+Colors.setColor("red")+"23"+Colors.resetColor()+"|"+Colors.setColor("grey")+"24"+Colors.resetColor()+"|          |");
        System.out.println("                 |-----------------|          |");
        System.out.println("                 |        |"+Colors.setColor("red")+"25"+Colors.resetColor()+"|"+Colors.setColor("grey")+"26"+Colors.resetColor()+"|"+Colors.setColor("red")+"27"+Colors.resetColor()+"|  moitie2 |");
        System.out.println("                 | tiers3 |"+Colors.setColor("grey")+"28"+Colors.resetColor()+"|"+Colors.setColor("grey")+"29"+Colors.resetColor()+"|"+Colors.setColor("red")+"30"+Colors.resetColor()+"|          |");
        System.out.println("                 |        |"+Colors.setColor("grey")+"31"+Colors.setColor("grey")+"|"+Colors.setColor("red")+"32"+Colors.resetColor()+"|"+Colors.setColor("grey")+"33"+Colors.resetColor()+"|          |");
        System.out.println("                 |        |"+Colors.setColor("red")+"34"+Colors.resetColor()+"|"+Colors.setColor("grey")+"35"+Colors.resetColor()+"|"+Colors.setColor("red")+"36"+Colors.resetColor()+"|          |");
        System.out.println("                 |________|__|__|__|__________| ");
        System.out.println("                          |c1|c2|c3|    ");
    }


    public static int getResultat() {
        return resultat;
    }

    public static void setResultat(int resultat) {
        Roulette.resultat = resultat;
    }

    public static String getPari() {
        return pari;
    }

    public static void setPari(String pari) {
        Roulette.pari = pari;
    }

    public static int getArgentParier() {
        return argentParier;
    }

    public static void setArgentParier(int argentParier) {
        Roulette.argentParier = argentParier;
    }

    public static List<Integer> getBlack() {
        return black;
    }

    public static void setBlack(List<Integer> black) {
        Roulette.black = black;
    }

    public static List<Integer> getRed() {
        return red;
    }

    public static void setRed(List<Integer> red) {
        Roulette.red = red;
    }

    @Override
    public void tricher() {
        App.clear();
        System.out.println("Vous donnez un coup dans la table pour influencer le sort de la roulette\n");
        if (RAND.nextInt(100) > 75){
            if(pari.equals("noir")){
                Roulette.setResultat(2);
            }else if(pari.equals("rouge")){
                Roulette.setResultat(1);
            }else if(pari.equals("pair")){
                Roulette.setResultat(2);
            }else if(pari.equals("impair")){
                Roulette.setResultat(1);
            }else if(pari.equals("moitie1")){
                Roulette.setResultat(1);
            }else if(pari.equals("moitie2")){
                Roulette.setResultat(20);
            }else if(pari.equals("colonne1")){
                Roulette.setResultat(1);
            }else if(pari.equals("colonne2")){
                Roulette.setResultat(2);
            }else if(pari.equals("colonne3")){
                Roulette.setResultat(3);
            }else if(pari.equals("tiers1")){
                Roulette.setResultat(1);
            }else if(pari.equals("tiers2")){
                Roulette.setResultat(20);
            }else if(pari.equals("tiers3")){
                Roulette.setResultat(28);
            }else {
                Roulette.setResultat(Integer.parseInt(pari));
            }
        }else{
            System.out.println("Votre coup a été remarqué !! Les vigils vous font sortir et vous payez 50€ de frais d'hopital pour soigner vos fractures");
            App.joueur.setArgent(App.joueur.getArgent()-50);
            argentParier = -1;
        }

        
    }

    @Override
    public void jouer() throws InterruptedException {
        bingo.afficherTitre("Roulette");

        char c;
        boolean continuer = true;
        while(continuer){
            App.clear();
            System.out.println("Voulez vous entrez, vous pouvez choisir votre mise (o/n)");
            c = App.ecouterChar();
            if (c == 'o') {
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
            System.out.println("Voulez vous voir les régles (r)");
            System.out.println("Voulez vous continuer (c)");
            c = App.ecouterChar();
            if (c =='c') {
                continuer = false;
            }else if(c == 'r'){
                bingo.afficherRegle("Roulette");
                while(!z.equals("q")){
                    System.out.println("\nAppuyer sur q pour quitter");
                    z = App.scanner.next();
                }
            }
        }
        Pari();
        System.out.println("Le numéro gagnant est : " + resultat);
        if(Roulette.Gain() == 0){
            defaite();
        }else if(Roulette.Gain() < 0){
            
        }else{
            victoire();
        }
        Thread.sleep(6000);
    }

    @Override
    public void victoire() {
        App.joueur.setBonheur(App.joueur.getBonheur() + 10);
        System.out.println("Bravo vous avez gagner " + Roulette.Gain() +"€");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
        App.joueur.setArgent(App.joueur.getArgent() + Roulette.Gain());
    }

    @Override
    public void defaite() {
        App.joueur.setBonheur(App.joueur.getBonheur() - 10);
        System.out.println("Dommage vous avez perdu l'argent parié");
        System.out.println("Vous avez " + App.joueur.getArgent() + "€");
    }

    @Override
    public void baisserTemps() {
        App.jour.moinsTempsJour(Roulette.DUREE);
    }

    @Override
    public int duree() {
        return Roulette.DUREE;
    }

    public String toString(){
        return "Roulette";
    }
}