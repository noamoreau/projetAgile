package main.BlackJack;

public class Score {
    private int userScore;


    Score() {
        this.userScore = 0;
    }

    Score(int userScore) {
        this.userScore = userScore;
    }

    boolean isBusted() {
        return this.userScore > 21;
    }

    boolean isBlackJack() {
        return this.userScore == 21;
    }

    void addValue(int cardValue) {
        this.userScore += cardValue;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
    
}
