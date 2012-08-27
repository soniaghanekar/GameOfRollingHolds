import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameStrategyTest {

    private GameStrategy gameStrategy;
    private IAmAPlayer player;
    private IAmAPlayer remainingPlayer;
    private Dice dice;
    private Roll roll;
    private Hold hold;

    @Before
    public void setUp(){
        player = new Player("player1");
        remainingPlayer = new Player("player2");
        dice = new Dice();
        roll = mock(Roll.class);
        hold = mock(Hold.class);
        gameStrategy = new GameStrategy(roll, hold);
    }

    @Test
    public void shouldExecuteCorrespondingMethodIfRollSelected() throws Exception {

        player.setChoice(GameStrategy.ROLL);
        gameStrategy.makeChangesBasedOnChoice(player, dice, remainingPlayer);
        verify(roll).executeRollAndReturnTrueIfSuccessful(player, dice, remainingPlayer);
    }

    @Test
    public void shouldExecuteCorrespondingMethodIfHoldSelected(){
        player.setChoice(GameStrategy.HOLD);
        gameStrategy.makeChangesBasedOnChoice(player, dice, remainingPlayer);
        verify(hold).executeHold(player);
    }
}
