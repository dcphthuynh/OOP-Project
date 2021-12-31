package candycrush;

import java.awt.*;

public class Background extends SimpleObject {
    /**
	 * 
	 */
	/**
	 * 
	 */
    private static final int WIDTH = Game.WIDTH;
    private static final int HEIGHT = Game.HEIGHT;
    private static final float HUE_MIN = 0;
    private static final float HUE_MAX = 1;
    private static final float colorDelta = 0.01f;
    private float hue = HUE_MIN;
    private Color color1 = Color.white;
    private Color color2 = Color.black;

    @Override
    public void tick() {
        hue += colorDelta / 20;
        if (hue > HUE_MAX) {
            hue = HUE_MIN;
        }
        color1 = Color.getHSBColor(hue, 1, 1);
        color2 = Color.getHSBColor(hue + 16 * colorDelta, 1, 1);
    }
}