package online.pengpeng.game.eliminate.model;

import online.pengpeng.game.eliminate.view.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SelectedBrandsTest {
    @InjectMocks
    SelectedBrands selectedBrands;

    @Test
    public void add() {

        Brand brand1 = new Brand("shape");
        Brand brand2= new Brand("shape");
        Brand brand3= new Brand("shape");
        selectedBrands.add(brand1);
        Assert.assertEquals(1, selectedBrands.size());
        selectedBrands.add(brand2);
        Assert.assertEquals(2, selectedBrands.size());

    }

}