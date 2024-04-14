package main.BlackJack;

public class UseUser {
    public static void main(String[] args) {
        User player = new User(100, "player");
        CardDeck deck = new CardDeck();
        System.out.println(player);
        System.out.println(deck);
        deck.shuffle();
        System.out.println();
        System.out.println(deck);
        player.addCard(deck.deal());
        System.out.println(deck.getDeck().size());
        System.out.println(player);
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        player.getUserHand().get(1).setVisible(false);
        System.out.println(player);
    }
}
