package main.BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private ArrayList<Card> deck;

    CardDeck() {
        this.deck = new ArrayList<Card>();
        for (int suits = 0; suits < Suits.values().length; suits++) {
            for (int value = 0; value < Value.values().length ; value++) {
                deck.add(new Card(Suits.values()[suits], Value.values()[value]));
            }
        }
    }


    void shuffle() {
        Collections.shuffle(deck);
    }

    Card deal() {
        return this.deck.remove(0);
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Remaining cards: \n");
        for (Card card : this.deck) {
            str.append(card.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
