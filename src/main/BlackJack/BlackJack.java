package main.BlackJack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import main.App;
import main.Jeu;
import main.Joueur;
import main.Bingo.bingo;

public class BlackJack implements Jeu{

    private static Map<String,Value> convertValues = new HashMap<>() {{
        put("2", Value.DEUX);
        put("3", Value.TROIS);
        put("4", Value.QUATRE);
        put("5", Value.FIVE);
        put("6", Value.SIX);
        put("7", Value.SEPT);
        put("8", Value.HUIT);
        put("9", Value.NEUF);
        put("10", Value.DIX);
        put("V", Value.VALLET);
        put("D", Value.DAME);
        put("R", Value.ROI);
        put("A", Value.AS);
    }};

    private static final int DUREE = 2;

    public Scanner scanner = App.scanner;


    public User player;
    public User dealer;
    public int bet;
    public CardDeck deck;

    
    public BlackJack(User user, CardDeck deck, User dealer, int bet) {
        this.player = user;
        this.player.setDenomination("joueur");
        this.dealer = dealer;
        this.deck = deck;
        this.bet = bet;
    }

    public BlackJack(User user) {
        this(user, new CardDeck(), new User(), 0);
    }

    public BlackJack(Joueur j) {
        this(new User(j));
    }

    public BlackJack() {
        this(new User());
    }

    void bet(int playerBet) {
        this.bet = playerBet;
    }

    void playerDeal() {
        Card deltCard = this.deck.deal();
        this.player.addCard(deltCard);
        this.player.calculateScore();
    }

    void dealerDeal() {
        Card deltCard = this.deck.deal();
        this.dealer.addCard(deltCard);
        if (this.dealer.userHand.size() == 1) {
            deltCard.setVisible(false);   
        }
        this.dealer.calculateScore();
    }    

    

    public void startingDeal() {
        this.playerDeal();
        this.dealerDeal();
        this.playerDeal();
        this.dealerDeal();
        if (this.player.hasBlackJack()) {
            this.victoire();
        }

    }

    void showCards() {
        System.out.println(dealer);
        System.out.println("\n");
        System.out.println(player);
        System.out.println("\n");
    }

    void askForChoice() throws InterruptedException {
        String choice = "";
        while (!(choice.equals("T")) && !(choice.equals("R")) && (!choice.equals("C"))) {
            System.out.println("T- Tirer");
            System.out.println("R- Rester");
                System.out.println("C- Tricher");
            choice = scanner.next().toUpperCase();
        }
        if (choice.equals("T")) {
            this.hit();
        } else if (choice.equals("R")) {
            this.stand();
        } else if (choice.equals("C")) {
            this.tricher();
        }
    }

    void askForBet() {
        int choice = 0;
        while (choice > this.player.currentMoney || choice <= 0) {
            System.out.println("Combien allez-vous mettre en jeu?");
            choice = scanner.nextInt();
        }
        bet(choice);
    }

    public void hit() throws InterruptedException {
        this.playerDeal();
        if (this.player.userScore.isBusted()) {
            this.defaite();
        } else {
            this.showCards();
            this.askForChoice();
        }
    }

    public void stand() throws InterruptedException {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        do {
            Thread.sleep(1000);
            this.dealerDeal();
            this.showCards();
        } while (this.dealer.getUserScore() < this.player.getUserScore() && !(this.dealer.isBusted()));
        if (this.dealer.isBusted()) {
            this.victoire();
        } else {
            this.defaite();
        }
    }

    void payOut(boolean hasBlackJack) {
        if (hasBlackJack) {
            App.joueur.setArgent((int)(App.joueur.getArgent() + this.bet*1.5));
        } else {
            App.joueur.setArgent(App.joueur.getArgent() + this.bet);
        }
    }

    public void startOfGame() throws InterruptedException {
        bingo.afficherTitre("BlackJack");
        this.deck.shuffle();
        askForRules();
        System.out.println("Vous avez "+ this.player.currentMoney+" € dans votre compte bancaire");
        askForBet();
        App.clear();
        startingDeal();
        if (!this.player.hasBlackJack()) {
            showCards();
            askForChoice();
            baisserTemps();
        }
    }

    private void askForRules() {
        
        String choice = "";
        while (!(choice.equals("O")) && !(choice.equals("N"))) {
            System.out.println("Voulez-vous les règles? (O/N)");
            choice = scanner.next().toUpperCase();
        }
        if (choice.equals("N")) {
            System.out.println("Très bien, commençons!");
        } else {
            bingo.afficherRegle("BJ");
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public User getDealer() {
        return dealer;
    }

    public void setDealer(User dealer) {
        this.dealer = dealer;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public CardDeck getDeck() {
        return deck;
    }

    public void setDeck(CardDeck deck) {
        this.deck = deck;
    }

    @Override
    public void tricher() {
        Visual v = new Visual();
        App.clear();
        System.out.println();
        String choice = "";
        while (!(choice.equals("1")) && !(choice.equals("2"))) {
            System.out.println("Quel carte voulez-vous remplacer (parmi les deux premières)?");
            System.out.println(v.assembleCards(this.player.userHand));
            choice = scanner.next().toUpperCase();
        }
        switch (choice) {
            case "1":
                this.changerCarte(this.player.getUserHand().get(0));
                break;
            case "2":
                this.changerCarte(this.player.getUserHand().get(1));
                break;
        }
    }

    private void changerCarte(Card card) {
        App.clear();
        Visual v = new Visual();
        System.out.println(v.cardVisual(card));
        ArrayList<String> validList = new ArrayList<>() {{
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
            add("10");
            add("V");
            add("D");
            add("R");
            add("A");
        }};
        String choice = "";
        while (!(validList.contains(choice))) {
            System.out.println("En quelle carte voulez-vous la transformer?\n");
            System.out.println("(pour un chiffre, mettez le chiffre, sinon l'initiale de la carte)");
            choice = scanner.next().toUpperCase();
        }
        card.setCardValue(convertValues.get(choice));
        this.player.calculateScore();
        this.showCards();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Random r = new Random();
        
        int trouvé = r.nextInt(2);
        if (trouvé == 1) {
            System.out.println("PROBLEME");
            this.foundOut();
        } else {
            try {
            this.askForChoice();
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    @Override
    public void jouer() throws InterruptedException {
        this.startOfGame();
    }

    @Override
    public void victoire() {
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        if (this.player.hasBlackJack()) {
            if (this.dealer.hasBlackJack()) {
                System.out.println("Double BlackJack, tu ne gagne rien et ne perds rien");
                return;
            }
            payOut(true);
        }
        System.out.println("TU AS GAGNER, le dealer a crever \n(c'est le terme technique, il n'est pas mort mais ça veux dire qu'il dépasser les 21 points)");
        payOut(false);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void defaite() {
        App.joueur.setBonheur(App.joueur.getBonheur()-5);
        this.dealer.setAllCardsVisible();
        this.dealer.calculateScore();
        this.showCards();
        if (this.dealer.getUserScore() == this.player.getUserScore()) {
            System.out.println("Egalité,\n Tu n'as rien gagné et rien perdu\nAu moins tu n'as pas perdu!");

        }
        if (this.player.isBusted()) {
            System.out.println("Game Over,\n Tu as crever (ton score est passé au dela de 21)\nPas de chance!");
        }
        else if (this.player.getUserScore() < this.dealer.getUserScore() && this.dealer.isBusted()){
            System.out.println("Game Over,\nLe dealer a un score plus élevé que le tiens\nPas de chance!");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        App.joueur.setArgent(App.joueur.getArgent()-this.bet);
        App.joueur.setBonheur(App.joueur.getBonheur() - 10);
    }

    @Override
    public void baisserTemps() {
        App.jour.moinsTempsJour(BlackJack.DUREE);
        
    }

    @Override
    public int duree() {
        return BlackJack.DUREE;
    }

    void foundOut() {
        App.clear();
        System.out.println("On a découvert que vous avez tricher! Le croupier vous a ejecté violemment du casino\n");
        System.out.println("Et les témoins de votre triche vous ont frappé dans les rues juste devant le casino");
        App.joueur.setArgent(App.joueur.getArgent()-this.bet);
        App.joueur.setArgent(App.joueur.getArgent()-50);
        App.joueur.setBonheur(App.joueur.getBonheur() - 10);
    }

    public String toString(){
        return "BlackJack";
    }

}
