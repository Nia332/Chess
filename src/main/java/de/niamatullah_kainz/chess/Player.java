package de.niamatullah_kainz.chess;
public class Player {
    Color color;
    String name;
    int score;

    public Player(Color color, String name, int score) {
        this.color = color;
        this.name = name;
        this.score = score;
    }

    public void setColor(Color color) {
        this.color = color;  
    }

    public Color getColor() {
        return this.color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return this.score;
    }
}
