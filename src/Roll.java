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
        System.out.print(player.getName() + ":  Dice value : " + newValue);
        if(!unsuccessfulRollDiceValues.contains(newValue)){
            isSuccessful = successfulRoll(player, newValue);
            System.out.print( "  Turn Total : " + player.getTurn_total() + "\n");
        }
        else{
            int playersEarlierTurnTotal = player.getTurn_total();
            isSuccessful = unsuccessfulRoll(player, remainingPlayer);
            System.out.print("   Turn Total : " + player.getTurn_total() + "   Score : "+ player.getScore()+" TURN FORFEITED " + remainingPlayer.getName() +" gets " + playersEarlierTurnTotal + " points\n");
        }

        return isSuccessful;
    }

    private boolean successfulRoll(IAmAPlayer player, int newValue) {
        player.setTurn_total(player.getTurn_total()+newValue);
        return true;
    }

    private boolean unsuccessfulRoll(IAmAPlayer player, IAmAPlayer remainingPlayer) {
        remainingPlayer.setScore(remainingPlayer.getScore() + player.getTurn_total());
        player.setTurn_total(0);
        return false;
    }
}
