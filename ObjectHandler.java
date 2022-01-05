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
}
