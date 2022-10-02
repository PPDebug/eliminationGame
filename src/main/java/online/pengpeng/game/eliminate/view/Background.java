package online.pengpeng.game.eliminate.view;

import online.pengpeng.game.eliminate.model.ImageFactory;
import online.pengpeng.game.eliminate.model.impl.ImageSimpleFactory;

import java.awt.*;

/**
 * Background
 * @author PPDebug
 */
public class Background extends Component {
    private static final ImageFactory IMAGE_FACTORY = ImageSimpleFactory.getInstance();
    private static final Background SINGLETON = new Background();

    private Image image;
    private String imagePath = null;

    private Background() {
        setName("background");
        imagePath = "img/bg.png";
        image = IMAGE_FACTORY.getResourcesImage(imagePath, false);
    }

    public void setImagePath(String path) {
        imagePath = path;
        image = IMAGE_FACTORY.getResourcesImage(imagePath, false);
    }

    public static Background getInstance() {
        return SINGLETON;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, -10, -10, null);
    }
}