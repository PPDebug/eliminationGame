package online.pengpeng.game.eliminate.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BackgroundTest {

    @Test
    public void test() {
        Background bg = Background.getInstance();
        assertNotNull(bg);
    }
}