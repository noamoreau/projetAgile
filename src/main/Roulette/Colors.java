package main.Roulette;

public class Colors {
    private static final String RESET = "\033[0m";
    private static final String BLACK = "\033[40;30m";
    private static final String RED = "\033[40;31m";
    private static final String GREEN = "\033[38;2;80;250;0m";
    private static final String YELLOW = "\033[38;2;250;240;0m";

    public static String setColor(String color) {
        if (color.equals("black")) {
            return Colors.BLACK;
        }else if (color.equals("red")) {
            return Colors.RED;
        }else if (color.equals("green")){
            return Colors.GREEN;
        }else if (color.equals("yellow")){
            return Colors.YELLOW;
        }
        return "";
    }

    public static String resetColor() {
        return Colors.RESET;
    }
}
