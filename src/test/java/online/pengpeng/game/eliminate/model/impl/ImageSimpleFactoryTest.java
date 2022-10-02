package online.pengpeng.game.eliminate.model.impl;

import online.pengpeng.game.eliminate.model.ImageFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

@RunWith(MockitoJUnitRunner.class)
public class ImageSimpleFactoryTest {

    @Test
    public void singletonTest() {
        ImageFactory imageFactory1 = ImageSimpleFactory.getInstance();
        ImageFactory imageFactory2 = ImageSimpleFactory.getInstance();
        Assert.assertEquals(imageFactory1, imageFactory2);
    }

    @Test
    public void flyWeightTest() {
        ImageFactory imageFactory = ImageSimpleFactory.getInstance();
        Image image1 = imageFactory.getResourcesImage("img/shape.png", false);
        Image image2 = imageFactory.getResourcesImage("img/shape.png", false);
        Assert.assertEquals(image1, image2);
    }
}