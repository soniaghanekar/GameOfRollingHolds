import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HoldTest {

    private Hold hold;
    private IAmAPlayer player;

    @Before
    public void setUp(){
        hold = new Hold();
        player = new Player("player");
        player.setTurn_total(6);
        player.setScore(10);
    }

    @Test
    public void shouldExecuteHoldAndReturnFalse(){
        assertFalse(hold.executeHold(player));
        assertEquals(16, player.getScore());
        assertEquals(0, player.getTurn_total());

    }
}
