package main;

import java.util.ArrayList;
import java.util.List;

public class Jour {
    private int tempsJour = 24;
    private List<Jeu> jeuxDuJour = new ArrayList<>();
    private int argentDeb;

    public Jour(int argentDeb) {
        this.argentDeb = argentDeb;
    }

    public int getTempsJour() {
        return tempsJour;
    }

    public void setTempsJour(int tempsJour) {
        this.tempsJour = tempsJour;
    }

    public void moinsTempsJour(int tempsJour){
        this.tempsJour -= tempsJour;
    }

    

    public List<Jeu> getJeuxDuJour() {
        return jeuxDuJour;
    }

    public String toString(){
        String res = "Jeu(x) du jour :\n";
        for(Jeu j : jeuxDuJour){
            res += j + " -> " + j.duree() + "h\n";
        }
        res += "Argent en début de journée : " + this.argentDeb + "\n";
        res += "Argent en fin de journée : " + App.joueur.getArgent() + "\n";
        return res;
    }

    public String getVisualHour() {
        int result = Math.abs(this.getTempsJour()-24);
        String realTime = ""+result;
        if (result < 10) {
            realTime = "0" + realTime;
        }
        return realTime;
    }
}
