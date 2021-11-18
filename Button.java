package candycrush;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends Clickable {
    private final ArrayList<BufferedImage> textures;
    private String string = "";
    private Color color;
    private int size;
    private int state = 0;

    public Button(String string, Color color, int size, int x, int y, int width, int height, BufferedImage spriteSheet) {
        super(x, y, width, height);
        this.string = string;
        this.color = color;
        this.size = size;
        this.textures = SpriteHandler.divideSprite(spriteSheet, 1, 3);
    }

    public Button(int x, int y, int width, int height, BufferedImage spriteSheet) {
        super(x, y, width, height);
        this.textures = SpriteHandler.divideSprite(spriteSheet, 1, 3);
    }

    public String getString() {
        return string;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        state = 2;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        state = 0;
    }

    @Override
    public void mouseHover(MouseEvent e) {
        state = 1;
    }

    @Override
    public void mouseReset() {
        state = 0;
    }

    @Override
    public void tick() {
        if (!clickable)
            state = 2;
    }

    @Override
    public void render(Graphics2D graphic) {
        graphic.drawImage(textures.get(state), x, y, width, height, null);
        graphic.setColor(color);
        Font font = new Font("TimesRoman", Font.BOLD, size);
        FontMetrics fontMetrics = graphic.getFontMetrics(font);
        int strX = x + (width - fontMetrics.stringWidth(string)) / 2;
        int strY = y + (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphic.setFont(font);
        graphic.drawString(string, strX, strY);
    }
}
