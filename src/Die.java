import java.util.Random;

public class Die {
    /* This class is for die instances. Uses Random to decide value of die.
     Uses an int to represent the die's number of sides. Uses another int to hold the latest die roll value.
     Has getter-methods, a toString-method (for testing) and a roll method.
     */
    private int currentValue;
    final private int numberOfSides;

    final private static Random random = new Random();

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void roll() {
        currentValue = random.nextInt(numberOfSides) + 1;
    }

    public String toString() {
        return "" + numberOfSides;
    }
}
