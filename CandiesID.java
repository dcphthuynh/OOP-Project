package candycrush;

import java.awt.image.BufferedImage;

public enum CandiesID {
    GREEN(1284, 798, 146, 146),
    BLUE(1018, 1522, 146, 146),
    YELLOW(1609, 9, 146, 146),
    ORANGE(1596, 318, 146, 146),
    RED(1284, 176, 146, 146),
    PURPLE(1442, 318, 146, 146);

    private static final String textureName = "candies.png";
    public final BufferedImage Texture;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    CandiesID(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Texture = getTexture(this);
    }

    private BufferedImage getTexture(CandiesID id) {
        return SpriteHandler.cutSprite(TextureManager.getInstance().getTexture(textureName), id.x, id.y, id.width, id.height);
    }
}
