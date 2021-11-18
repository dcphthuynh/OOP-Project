package candycrush;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseHandler extends MouseAdapter {
    private static MouseHandler handler = null;
    private final ArrayList<Clickable> objects = new ArrayList<>();
    private final ArrayList<Clickable> objectsToRemove = new ArrayList<>();
    private final ArrayList<Clickable> objectsToAdd = new ArrayList<>();

    public static MouseHandler getInstance() {
        if (handler == null) {
            handler = new MouseHandler();
        }
        return handler;
    }

    public void addObject(Clickable object) {
        objectsToAdd.add(object);
    }

    public void addObject(ClickableGroup group) {
        objectsToAdd.addAll(group.getObjects());
    }

    public void removeObject(Clickable object) {
        objectsToRemove.add(object);
    }

    public void removeObject(ClickableGroup group) {
        objectsToRemove.addAll(group.getObjects());
    }

    private boolean mouseOver(int mouseX, int mouseY, Clickable object) {
        int x = object.getX();
        int y = object.getY();
        int dx = x + object.getWidth();
        int dy = y + object.getHeight();
        return mouseX > x && mouseX < dx && mouseY > y && mouseY < dy;
    }

    public void tick() {
        objects.removeAll(objectsToRemove);
        objects.addAll(objectsToAdd);

        objectsToAdd.clear();
        objectsToRemove.clear();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        for (int i = 0; i < objects.size(); i++) {
            if (mouseOver(mouseX, mouseY, objects.get(i)) && objects.get(i).isClickable()) {
                objects.get(i).mousePressed(e);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).isClickable()) {
                if (mouseOver(mouseX, mouseY, objects.get(i))) {
                    objects.get(i).mouseReleased(e);
                    objects.get(i).performAction();
                } else
                    objects.get(i).mouseReset();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).isClickable()) {
                if (mouseOver(mouseX, mouseY, objects.get(i))) {
                    objects.get(i).mouseHover(e);
                } else
                    objects.get(i).mouseReset();
            }
        }
    }
}
