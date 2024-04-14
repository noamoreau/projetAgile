package main.BlackJack;

import java.util.ArrayList;

import main.Joueur;

public class User {
    ArrayList<Card> userHand;
    Score userScore;
    int currentMoney;
    String denomination;
    
    public User(ArrayList<Card> userHand, Score userScore, int currentMoney, String denomination) {
        this.userHand = userHand;
        this.userScore = userScore;
        this.currentMoney = currentMoney;
        this.denomination = denomination;
    }


    public User(Joueur j) {
        this(j.getArgent(), j.getNom());
    }

    public User(int currentMoney, String denomination) {
        this(new ArrayList<Card>(), new Score(), currentMoney, denomination);
    }

    public User() {
        this(new ArrayList<Card>(), new Score(), 0, "dealer");
    }

    public void addCard(Card card) {
        this.userHand.add(card);
    }

    public ArrayList<Card> getUserHand() {
        return userHand;
    }

    public void setUserHand(ArrayList<Card> userHand) {
        this.userHand = userHand;
    }

    public int getUserScore() {
        return userScore.getUserScore();
    }

    public void setUserScore(Score userScore) {
        this.userScore = userScore;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDenomination() {
        return this.denomination;
    }

    

    void calculateScore() {
        Score calculatedScore = new Score();
        int nbAce = 0;
        for (Card card : this.userHand) {
            if (card.isVisible) {
                calculatedScore.addValue(card.getCardValue());
                if (card.getCardRealValue().equals(Value.AS)) {
                    nbAce++;
                }
            }
        }
        if (calculatedScore.getUserScore() > 21) {
            calculatedScore.setUserScore(calculatedScore.getUserScore() - (10*nbAce));
        }

        this.setUserScore(calculatedScore);

    }

    boolean isBusted() {
        return this.getUserScore() > 21;
    }

    void setAllCardsVisible() {
        for (Card card : this.userHand) {
            card.setVisible(true);
        }
    }

    boolean hasACE() {
        for (Card card : this.getUserHand()) {
            if (card.getCardRealValue().equals(Value.AS)) {
                return true;
            }
        }
        return false;
    }

    boolean hasFigure() {
        for (Card card : this.getUserHand()) {
            if (card.getCardRealValue().equals(Value.DIX) || card.getCardRealValue().equals(Value.VALLET) || 
            card.getCardRealValue().equals(Value.DAME) || card.getCardRealValue().equals(Value.ROI)){
                return true;
            }
        }
        return false;
    }

    boolean hasBlackJack() {
        if (this.getUserHand().size() == 2 && this.hasACE() && this.hasFigure()) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        Visual v = new Visual();
        String result = this.getDenomination() + " - " + this.getUserScore();
        return result + "\n" + v.assembleCards(userHand);
    }

    
}
