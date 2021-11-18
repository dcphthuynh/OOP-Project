package candycrush;

public abstract class Action {
    private final Button parent;

    public Action(Button parent) {
        this.parent = parent;
    }

    public Button getParent() {
        return parent;
    }

    public abstract void perform();
}
