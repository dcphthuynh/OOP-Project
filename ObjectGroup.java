package candycrush;

import java.awt.*;
import java.util.ArrayList;

public class ObjectGroup extends SimpleObject {
    protected final ArrayList<SimpleObject> objects = new ArrayList<>();

    //adding
    public void addObject(SimpleObject object) {
        objects.add(object);
    }

    //removing
    public void removeObject(SimpleObject object) {
        objects.remove(object);
    }

    //clearing
    public void clear() {
        objects.clear();
    }

    public ArrayList<SimpleObject> getObjects() {
        return objects;
    }

    //tick
    @Override
    public void tick() {
        for (SimpleObject object : objects) {
            object.tick();
        }
    }

    //render image
    @Override
    public void render(Graphics2D graphic) {
        for (SimpleObject object : objects) {
            object.render(graphic);
        }
    }
}
