package main.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Visual {
    String repeat(String str, int nb) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0 ; i < nb ; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    public static void clear()
    {
        final String ESC = "\033[";
        System.out.print (ESC + "2J");
        System.out.print (ESC + "0;0H");
        System.out.flush();
    }

    int biggestLine(String str) {
        return 0;
    }

    String getAppropritateValueAbove(Value value) {
        switch (value) {
            case AS:
                return "A ";
            case VALLET:
                return "V ";
            case DAME:
                return "D ";
            case ROI:
                return "R ";
            case DIX:
                return ""+value.cardValue;
            default:
                return value.cardValue+" ";
        }
    }

    String getAppropritateValueBelow(Value value) {
        switch (value) {
            case AS:
                return " A";
            case VALLET:
                return " V";
            case DAME:
                return " D";
            case ROI:
                return " R";
            case DIX:
                return ""+value.cardValue;
            default:
                return " "+value.cardValue;
        }
    }

    String cardVisual(Card originalCard) {
        StringBuilder card = new StringBuilder();
        card.append("\n┌───────┐\n");
        card.append("\u2502"+this.getAppropritateValueAbove(originalCard.cardValue)+"     \u2502\n");
        card.append("\u2502       \u2502\n");
        card.append("\u2502   "+this.getAppropritateSuit(originalCard.cardColor)+"   \u2502\n");
        card.append("\u2502       \u2502\n");
        card.append("\u2502     "+this.getAppropritateValueBelow(originalCard.cardValue)+"\u2502\n");
        card.append("└───────┘\n");

        return card.toString();
        
    }

    String cardHidden() {
        StringBuilder card = new StringBuilder();
        card.append("\n┌───────┐\n");
        card.append("\u2502       \u2502\n");
        card.append("\u2502       \u2502\n");
        card.append("\u2502   ?   \u2502\n");
        card.append("\u2502       \u2502\n");
        card.append("\u2502       \u2502\n");
        card.append("└───────┘\n");

        return card.toString();
    }

    private String getAppropritateSuit(Suits color) {
        switch (color) {
            case TREFLES:
            return "\u2663";
            case PIQUE:
            return "\u2660";
            case CARREAU:
            return "\u2666";
            case COEUR:
            return "\u2665";
            default:
            return "?";
        }
    }
    /*
    int nbLines(String str) {
        int nbLines = 0;
        for (int i = 1 ; i < str.length() ; i++) {
            char car = str.charAt(i);
            if (car == '\n') {
                nbLines++;
            }
        }
        return nbLines;
    }

    String getLine(String str, int i) {
        int currentLine = 0;
        int indexDeb = 0;
        int indexFin = 0;
        for (int j = 1 ; j < str.length() ; j++) {
            char car = str.charAt(j);
            if (car == '\n') {
                currentLine++;
                if (currentLine == i) {
                    indexDeb = j+1;
                }

                if (currentLine == i+1) {
                    indexFin = j;
                }
            }
        }
        return str.substring(indexDeb, indexFin);
    }


    String removeLineBreaks(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 1 ; i < str.length() ; i++) {
            char car = str.charAt(i);
            if (car != '\n') {
                result.append(car);
            }
        }
        return result.toString();
    }

    String assembleLines(String s1, String s2, int indexLigne) {
        StringBuilder str = new StringBuilder();
        str.append(this.getLine(s1, indexLigne));
        str.append(this.getLine(s2, indexLigne));
        //return this.removeLineBreaks(str.toString());
        return str.toString();

    }

    String assembleCards(String card1, String card2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < this.nbLines(card1) ; i++) {
            if (i==0) {
                result.append(this.removeLineBreaks(assembleLines(card1, card2, i)));    
            } else {
                result.append(assembleLines(card1, card2, i));
            }
            result.append('\n');
        }
        return result.toString();
    }
    */

    String assembleCards(List<Card> listCarte) {
        List<String[]> toAssemble = new ArrayList<>();
        for (Card card : listCarte) {
            toAssemble.add(card.toString().split("\n"));
        }
        String result = "";
        for(int i = 0; i < toAssemble.get(0).length; i++) {
            String line = "";
            for(String[] s : toAssemble) {
                line += s[i] + " ";
            }
            line += "\n";
            result += line;
        }
        return result;
    }

    public static void main(String[] args) {
        Card c = new Card(Suits.CARREAU, Value.AS);
        Card c2 = new Card(Suits.PIQUE, Value.VALLET);
        Card c3 = new Card(Suits.PIQUE, Value.DEUX);
        Visual v = new Visual();

        System.out.println(v.cardVisual(c));
        ArrayList<Card> liste = new ArrayList<>() {{
            add(c);
            add(c2);
            add(c3);
        }};
        System.out.println(v.assembleCards(liste));
        
    }
}
