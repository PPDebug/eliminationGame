package online.pengpeng.game.eliminate.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EliminationBoxTest {

    @Test
    public void test() {
        assertNotNull(EliminationBox.getInstance());
    }
}