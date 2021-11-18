package candycrush;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Grid extends Clickable {
    private Level level = null;
    private BufferedImage gridTexture = null;

    public Grid() {
        super(350, 30, 900, 900);
    }

    public void setUpGrid(Level level) {
        this.level = level;
        this.gridTexture = createGridTexture();
    }

    private int offsetDirX(int dir) {
        if (dir == 3)
            return 1;
        if (dir == 1)
            return -1;
        return 0;
    }

    private int offsetDirY(int dir) {
        if (dir == 0 || dir == 4)
            return -1;
        if (dir == 2)
            return 1;
        return 0;
    }

    private int diagonalOffsetX(int dir) {
        if (dir == 0 || dir == 1)
            return -1;
        if (dir == 2 || dir == 3)
            return 1;
        return 0;
    }

    private int diagonalOffsetY(int dir) {
        if (dir == 0 || dir == 3)
            return -1;
        if (dir == 1 || dir == 2)
            return 1;
        return 0;
    }

    private boolean emptyAdjacent(int x, int y, int side) {
        int dX = offsetDirX(side);
        int dY = offsetDirY(side);
        if (x + dX > 8 || x + dX < 0 || y + dY > 8 || y + dY < 0)
            return true;
        else
            return level.getEmpty()[y + dY][x + dX];
    }

    private boolean emptyDiagonal(int x, int y, int side) {
        int dX = diagonalOffsetX(side);
        int dY = diagonalOffsetY(side);
        if (x + dX > 8 || x + dX < 0 || y + dY > 8 || y + dY < 0)
            return true;
        else
            return level.getEmpty()[y + dY][x + dX];
    }

    private BufferedImage createGridTexture() {
        BufferedImage texture = new BufferedImage(908, 908, BufferedImage.TYPE_4BYTE_ABGR);
        ArrayList<BufferedImage> textures = SpriteHandler.divideSprite(TextureManager.getInstance().getTexture("grid.png"), 8, 8, 58);
        Graphics2D graphic = texture.createGraphics();
        boolean[][] empty = level.getEmpty();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                int even = 0;
                if ((x + y) % 2 == 1)
                    even = 1;

                int posX = 30 + x * 100;
                int posY = 30 + y * 100;

                if (!empty[y][x]) {
                    // Draw center
                    graphic.drawImage(textures.get(56 + even), posX, posY, null);

                    // Draw edge
                    for (int k = 0; k < 4; k++) {
                        if (emptyAdjacent(x, y, k))
                            graphic.drawImage(textures.get(32 + 2 * k + even), posX + offsetDirX(k) * 50, posY + offsetDirY(k) * 50, null);
                        else
                            graphic.drawImage(textures.get(40 + 2 * k + even), posX + offsetDirX(k) * 50, posY + offsetDirY(k) * 50, null);
                    }

                    // Draw conner
                    for (int k = 0; k < 4; k++) {
                        if (emptyAdjacent(x, y, k) && emptyAdjacent(x, y, k + 1) && emptyDiagonal(x, y, k))
                            graphic.drawImage(textures.get(2 * k + even), posX + diagonalOffsetX(k) * 50, posY + diagonalOffsetY(k) * 50, null);
                        else if (!emptyAdjacent(x, y, k) && emptyAdjacent(x, y, k + 1) && emptyDiagonal(x, y, k))
                            graphic.drawImage(textures.get(16 + 2 * k + even), posX + diagonalOffsetX(k) * 50, posY + diagonalOffsetY(k) * 50, null);
                        else if (emptyAdjacent(x, y, k) && !emptyAdjacent(x, y, k + 1) && emptyDiagonal(x, y, k))
                            graphic.drawImage(textures.get(24 + 2 * k + even), posX + diagonalOffsetX(k) * 50, posY + diagonalOffsetY(k) * 50, null);
                        else
                            graphic.drawImage(textures.get(48 + 2 * k + even), posX + diagonalOffsetX(k) * 50, posY + diagonalOffsetY(k) * 50, null);
                    }
                } else {
                    // Draw empty conner
                    for (int k = 0; k < 4; k++) {
                        if (!emptyAdjacent(x, y, k) && !emptyAdjacent(x, y, k + 1))
                            graphic.drawImage(textures.get(8 + 2 * k + even), posX + diagonalOffsetX(k) * 50, posY + diagonalOffsetY(k) * 50, null);
                    }
                }
            }
        }

        graphic.dispose();

        return texture;
    }

    @Override
    public void render(Graphics2D graphic) {
        graphic.drawImage(gridTexture, 346, 26, null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        LevelHandler.getInstance().selected(e.getX(), e.getY());
    }

    @Override
    public void mouseHover(MouseEvent e) {

    }

    @Override
    public void mouseReset() {

    }
}
