package candycrush;

import java.awt.*;
import java.util.ArrayList;

public class ObjectGroup extends SimpleObject {
    protected final ArrayList<SimpleObject> objects = new ArrayList<>();

    @Override
    public void tick() {
        for (SimpleObject object : objects) {
            object.tick();
        }
    }

    @Override
    public void render(Graphics2D graphic) {
        for (SimpleObject object : objects) {
            object.render(graphic);
        }
    }
}
