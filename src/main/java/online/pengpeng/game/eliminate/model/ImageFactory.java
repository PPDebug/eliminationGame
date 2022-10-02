package online.pengpeng.game.eliminate.model;

import java.awt.*;

/**
 * ImageFactory
 * @author ppdebug
 */
public interface ImageFactory {
    /**
     * Get image by relative path and flag
     * @param imagePath image store path
     * @param covered whether to make image gray
     * @return {@link Image}
     */
    Image getResourcesImage(String imagePath, boolean covered);
}
