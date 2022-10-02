package online.pengpeng.game.eliminate.view;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BrandTest {

    @Test
    public void test() {
        Brand brand = new Brand("shape");
        Assert.assertNotNull(brand);
    }
}