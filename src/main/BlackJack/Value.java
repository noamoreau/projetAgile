package main.BlackJack;

public enum Value {
    DEUX(2), 
    TROIS(3), 
    QUATRE(4), 
    FIVE(5), 
    SIX(6), 
    SEPT(7), 
    HUIT(8), 
    NEUF(9), 
    DIX(10), 
    VALLET(10), 
    DAME(10), 
    ROI(10), 
    AS(11);

    int cardValue;

    Value(int cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}
