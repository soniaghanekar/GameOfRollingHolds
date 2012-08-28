import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private Dice dice;
    private IAmAPlayer player1;
    private IAmAPlayer player2;
    private GameStrategy gameStrategy;
    private Roll roll;
    private Hold hold;

    private final String PLAYER1 ="Player1";
    private final String PLAYER2 ="Player2";

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final int MAX_SCORE = 50;

    Game(){
        player1 = new Player(PLAYER1);
        player2 = new Player(PLAYER2);
        dice = new Dice();
        roll = new Roll();
        hold = new Hold();
        gameStrategy = new GameStrategy(roll, hold);
    }

    private boolean isGameOver(){
        if(player1.getScore() >= MAX_SCORE || player2.getScore() >= MAX_SCORE)
            return true;
        return false;
    }

    public void play() {
        System.out.println("Welcome to the Game of Rolling Holds\n");
        System.out.println("======================================\n");
        IAmAPlayer player = player1;
        char inputValue;
        boolean getAChoiceToPlayAgain = true;
        while (!isGameOver()){
            getAChoiceToPlayAgain = true;
            System.out.println(player.getName() + ": Score: " + player.getScore());
            System.out.println(player.getName() + ": Choose Roll(r) or Hold(h): ");
            while((inputValue=acceptAValidCharInput())=='\0')
                System.out.println("Enter a valid input");
            player.setChoice(inputValue);
            if(!gameStrategy.makeChangesBasedOnChoice(player, dice, getRemainingPlayer(player)))
                getAChoiceToPlayAgain = false;
            System.out.println("Scores: Player1:" + player1.getScore() + " Player2:" + player2.getScore() + "\n\n");
            if(!getAChoiceToPlayAgain)
                player = getRemainingPlayer(player);
        }
        System.out.println(getWinner() + " is the winner!!");
    }

    private IAmAPlayer getRemainingPlayer(IAmAPlayer player) {
        if(player.getName() == PLAYER1)
            return player2;
        return player1;
    }

    private char acceptAValidCharInput() {
        char value='\0';
        try {
            value = reader.readLine().toLowerCase().charAt(0);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if(value != GameStrategy.ROLL && value!= GameStrategy.HOLD)
            return '\0';
        return value;
    }

    private String getWinner() {
        if(player1.getScore()>=MAX_SCORE)
            return PLAYER1;
        return PLAYER2;
    }
}
