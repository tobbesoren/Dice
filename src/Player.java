import java.util.ArrayList;

public class Player {
    String name;
    int score;
    ArrayList<Die> myDice = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void rollDice() {
        for (Die die: myDice) {
            die.roll();
        }
    }

    public int getDiceValue() {
        int sum = 0;
        for(Die die: myDice) {
            sum += die.getCurrentValue();
        }
        return sum;
    }

    public void increaseScore() {
        score++;
    }

    public void addDie(int numberOfSides) {
        myDice.add(new Die(numberOfSides));
    }

    public String toString() {
        return name + ": " + myDice + ": " + score;
    }
}
