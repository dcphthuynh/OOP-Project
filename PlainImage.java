package candycrush;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlainImage extends GameObject {
    private final BufferedImage image;

    public PlainImage(BufferedImage image, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.image = image;
    }

    @Override
    public void render(Graphics2D graphic) {
        graphic.drawImage(image, x, y, width, height, null);
    }
}
