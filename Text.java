package candycrush;

import java.awt.*;

public class Text extends GameObject {
    private String text;
    private String font;
    private Color color;
    private int size;

    public Text(String text, String font, Color color, int size, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.text = text;
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public Text(String font, Color color, int size, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.text = "";
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void render(Graphics2D graphic) {
        graphic.setColor(color);
        Font ft = new Font(font, Font.BOLD, size);
        FontMetrics fontMetrics = graphic.getFontMetrics(ft);
        int strX = x + (width - fontMetrics.stringWidth(text)) / 2;
        int strY = y + (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphic.setFont(ft);
        graphic.drawString(text, strX, strY);
    }
}