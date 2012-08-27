import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceTest {

    private Dice dice;
    private Random randomGenerator;

    @Before
    public void setUp(){
        dice = new Dice();
        randomGenerator = mock(Random.class);
        dice.setRandomGenerator(randomGenerator);
    }

    @Test
    public void shouldGetNextRandomValueFromDice(){
        when(randomGenerator.nextInt(6)).thenReturn(4);
        assertEquals(5, dice.getNewValue());
    }
}
