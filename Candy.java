package candycrush;

import java.awt.*;

public class Candy extends GameObject {
    private final CandiesID id;
    private int animX;
    private int animY;

    public Candy(int x, int y, CandiesID id) {
        super(x, y, 100, 100);
        this.id = id;
        animX = x;
        animY = y;
    }

    public static void swap(Candy c1, Candy c2) {
        int x1 = c1.getX();
        int y1 = c1.getY();
        int x2 = c2.getX();
        int y2 = c2.getY();

        c1.gotoXY(x2, y2);
        c2.gotoXY(x1, y1);
    }

    public void gotoXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isMoving() {
        return !(animX == x && animY == y);
    }

    public CandiesID getId() {
        return id;
    }

    @Override
    public void tick() {
        if (animX != x) {
            if (animX > x)
                animX -= 5;
            else
                animX += 5;
        }
        if (animY != y) {
            if (animY > y)
                animY -= 5;
            else
                animY += 5;
        }
    }

    @Override
    public void render(Graphics2D graphic) {
        int drawX = animX, drawW = drawX + 100;
        int drawY = animY, drawH = drawY + 100;
        int picX = 0, picY = 0;
        int picW = id.Texture.getWidth(), picH = id.Texture.getWidth();
        int[][] gridData = LevelHandler.getInstance().getGrid();

        if ((animY + 70) / 100 < 9) {
            if (gridData[(animY + 70) / 100][(animX - 350) / 100] == 2 || (animY + 70) / 100 == 0) {
                if (gridData[1 + (animY + 70) / 100][(animX - 350) / 100] == 2) {
                    drawH = drawY;
                } else {
                    drawY = (1 + (animY + 70) / 100) * 100 - 70;
                    drawH = animY + 100;

                    picY = picH * (drawY - animY) / 100;
                }
            } else {
                if (gridData[1 + (animY + 70) / 100][(animX - 350) / 100] == 2) {
                    drawH = (1 + (animY + 70) / 100) * 100 - 70;

                    picH = picH * (drawH - drawY) / 100;
                }
            }
        }

        graphic.drawImage(id.Texture, drawX, drawY, drawW, drawH, picX, picY, picW, picH, null);
    }
}
