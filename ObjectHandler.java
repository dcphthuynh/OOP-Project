package candycrush;

import java.awt.*;
import java.util.ArrayList;


public class ObjectHandler {
    private static ObjectHandler objectHandler = null;
    private final ArrayList<SimpleObject> objects = new ArrayList<>();
    private final ArrayList<SimpleObject> objectsToRemove = new ArrayList<>();
    private final ArrayList<SimpleObject> objectsToAdd = new ArrayList<>();

    public static ObjectHandler getInstance() {
        if (objectHandler == null) {
            objectHandler = new ObjectHandler();
        }
        return objectHandler;
    }

    public void tick() {
        for (SimpleObject object : objects) {
            object.tick();
        }

        objects.removeAll(objectsToRemove);
        objects.addAll(objectsToAdd);

        objectsToAdd.clear();
        objectsToRemove.clear();
    }

    public void render(Graphics2D graphic) {
        for (SimpleObject object : objects) {
            object.render(graphic);
        }
    }

    public void addObject(SimpleObject object) {
        objectsToAdd.add(object);
    }

    public void removeObject(SimpleObject object) {
        objectsToRemove.add(object);
    }
}
