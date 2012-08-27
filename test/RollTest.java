import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RollTest {
    private Roll roll;

    private IAmAPlayer player;
    private Dice dice;
    private IAmAPlayer remainingPlayer;

    @Before
    public void setUp(){
        roll = new Roll();
        player = new Player("player");
        player.setTurn_total(3);
        dice = mock(Dice.class);
        remainingPlayer = new Player("remainingPlayer");
    }

    @Test
    public void shouldReturnTrueForSuccessfulRoll(){
        when(dice.getNewValue()).thenReturn(5);
        assertTrue(roll.executeRollAndReturnTrueIfSuccessful(player, dice, remainingPlayer));
        assertEquals(8, player.getTurn_total());
    }

    @Test
    public void shouldReturnFalseForUnsuccessfulRoll(){
        when(dice.getNewValue()).thenReturn(4);
        assertFalse(roll.executeRollAndReturnTrueIfSuccessful(player, dice, remainingPlayer));
        assertEquals(0, player.getTurn_total());
        assertEquals(3, remainingPlayer.getScore());
    }
}
