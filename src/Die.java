import java.util.Random;

public class Die {
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
}
