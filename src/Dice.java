import java.util.Random;

public class Dice {
    private Random randomGenerator = new Random();

    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public int getNewValue(){
        return 1+randomGenerator.nextInt(6);
    }

}
