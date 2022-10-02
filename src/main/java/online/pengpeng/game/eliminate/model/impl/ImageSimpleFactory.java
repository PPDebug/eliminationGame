package online.pengpeng.game.eliminate.model.impl;

import online.pengpeng.game.eliminate.model.ImageFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ImageFactory
 * @pattern FlyWeight, Singleton
 * @author PPDebug
 */
public class ImageSimpleFactory implements ImageFactory {
    private final Map<String, Image[]> images;

    private static final ImageFactory SINGLETON = new ImageSimpleFactory();

    private ImageSimpleFactory() {
        images = new HashMap<>();
    }

    public static ImageFactory getInstance() {
        return SINGLETON;
    }

    @Override
    public Image getResourcesImage(String imagePath, boolean covered) {
        if (! images.containsKey(imagePath)) {
            buildImage(imagePath);
        }
        return images.get(imagePath)[covered ? 1 : 0];
    }

    synchronized private void buildImage(String path) {
        BufferedImage image = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            image = ImageIO.read(Objects.requireNonNull(classLoader.getResourceAsStream(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedImage reverse = reverseImage(image);
        images.put(path, new Image[] {image, reverse});
    }

    private BufferedImage reverseImage(BufferedImage image) {
        final int maskR = 0xff0000;
        final int maskG = 0x00ff00;
        final int maskB = 0x0000ff;
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage reverse = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb & maskR) >> 16;
                int g = (rgb & maskG) >> 8;
                int b = (rgb & maskB);
                int gray = (int) (r * 0.299 + g * 0.587 + b * 0.114);
                int newRgb = (gray << 16) + (gray << 8) + gray;
                reverse.setRGB(x, y, newRgb);
            }
        }
        return reverse;
    }
}
