package online.pengpeng.game.eliminate.view;

import online.pengpeng.game.eliminate.model.ImageFactory;
import online.pengpeng.game.eliminate.model.impl.ImageSimpleFactory;

import java.awt.*;

/**
 * Background
 * @author PPDebug
 */
public class EliminationBox extends Component {
    private static final ImageFactory IMAGE_FACTORY = ImageSimpleFactory.getInstance();
    private static final EliminationBox SINGLETON = new EliminationBox();

    private Image image;
    private String imagePath = null;

    private EliminationBox() {
        setName("eliminationBox");
        imagePath = "img/eliminationBox.png";
        image = IMAGE_FACTORY.getResourcesImage(imagePath, false);
    }

    public void setImagePath(String path) {
        imagePath = path;
        image = IMAGE_FACTORY.getResourcesImage(imagePath, false);
    }

    public static EliminationBox getInstance() {
        return SINGLETON;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
