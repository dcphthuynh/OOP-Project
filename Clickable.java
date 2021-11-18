package candycrush;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Clickable extends GameObject {
    protected ArrayList<Action> actions = new ArrayList<>();
    protected boolean clickable = true;

    public Clickable(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);

    public abstract void mouseHover(MouseEvent e);

    public abstract void mouseReset();

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void performAction() {
        for (Action action : actions) {
            action.perform();
        }
    }
}
