public class GameStrategy {

    public static final char ROLL = 'r';
    public static final char HOLD = 'h';

    private Roll roll = new Roll();
    private Hold hold = new Hold();

    GameStrategy(Roll roll, Hold hold){
        this.roll = roll;
        this.hold = hold;
    }

    public boolean makeChangesBasedOnChoice(IAmAPlayer player, Dice dice, IAmAPlayer remainingPlayer){
        if(player.getChoice() == ROLL)
        {
            return roll.executeRollAndReturnTrueIfSuccessful(player, dice, remainingPlayer);
        }
        return hold.executeHold(player);
    }

}
