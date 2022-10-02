package online.pengpeng.game.eliminate.view;

import lombok.Getter;
import lombok.Setter;
import online.pengpeng.game.eliminate.controller.BrandClickHandler;
import online.pengpeng.game.eliminate.model.ImageFactory;
import online.pengpeng.game.eliminate.model.impl.ImageSimpleFactory;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Arrays;

/**
 * Brand
 * @author PPDebug
 */
@Getter
@Setter
public class Brand extends Component {
    public static final int BRAND_WIDTH = 50;
    public static final int BRAND_HEIGHT = 50;
    /** brand image */
    private Image image;
    private String imagePath = null;
    private boolean covered;
    private int offsetX;
    private int offsetY;

    private static final MouseListener MOUSE_LISTENER = BrandClickHandler.getInstance();
    private static final ImageFactory IMAGE_FACTORY = ImageSimpleFactory.getInstance();

    public Brand(String name) {
        setName(name);
        imagePath = "img/" + name + ".png";
        image = IMAGE_FACTORY.getResourcesImage(imagePath, covered);
        this.addMouseListener(MOUSE_LISTENER);
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
        image = IMAGE_FACTORY.getResourcesImage(imagePath, covered);
    }

    public void removeMouseListener() {
        Arrays.stream(this.getMouseListeners())
                .filter( listener -> listener instanceof BrandClickHandler)
                .forEach(this::removeMouseListener);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}