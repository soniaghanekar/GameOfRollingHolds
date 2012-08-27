import java.util.ArrayList;

public class Roll {

    private ArrayList<Integer> unsuccessfulRollDiceValues = new ArrayList<Integer>();

    Roll(){
        unsuccessfulRollDiceValues.add(1);
        unsuccessfulRollDiceValues.add(4);

    }

    public boolean executeRollAndReturnTrueIfSuccessful(IAmAPlayer player, Dice dice, IAmAPlayer remainingPlayer) {
        boolean isSuccessful;
        int newValue = dice.getNewValue();
        if(!unsuccessfulRollDiceValues.contains(newValue)){
            successfulRoll(player, newValue);
            isSuccessful = true;
        }
        else{
            unsuccessfulRoll(player, remainingPlayer);
            isSuccessful = false;
        }
        System.out.println(player.getName() + ":  Dice value : " + newValue + "  Turn Total : " + player.getTurn_total() + "\n");
        return isSuccessful;
    }

    private void successfulRoll(IAmAPlayer player, int newValue) {
        player.setTurn_total(player.getTurn_total()+newValue);
    }

    private void unsuccessfulRoll(IAmAPlayer player, IAmAPlayer remainingPlayer) {
        remainingPlayer.setScore(remainingPlayer.getScore() + player.getTurn_total());
        player.setTurn_total(0);
    }
}
