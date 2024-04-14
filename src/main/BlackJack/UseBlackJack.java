package main.BlackJack;

import main.Joueur;

public class UseBlackJack {
    public static void main(String[] args) throws InterruptedException {
        Joueur j = new Joueur("null", 100, 500, 100, 0);
        BlackJack currentGame = new BlackJack(j);
        currentGame.jouer();
    }
}
