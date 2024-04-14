package main.BlackJack;

public class Card {
    Suits cardColor;
    Value cardValue;
    boolean isVisible;

    Card(Suits cardColor, Value cardValue) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
        this.isVisible = true;
    }

    public Suits getCardColor() {
        return cardColor;
    }

    public void setCardColor(Suits cardColor) {
        this.cardColor = cardColor;
    }

    public int getCardValue() {
        return cardValue.cardValue;
    }

    public Value getCardRealValue() {
        return cardValue;
    }

    public void setCardValue(Value cardValue) {
        this.cardValue = cardValue;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        Visual v = new Visual();
        if(this.isVisible) {
            return v.cardVisual(this);
        }
        return v.cardHidden();
    }
}
