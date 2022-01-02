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
    
    //clickable check
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

    //tick
    public void tick() {
        objects.removeAll(objectsToRemove);
        objects.addAll(objectsToAdd);

        objectsToAdd.clear();
        objectsToRemove.clear();
    }
}