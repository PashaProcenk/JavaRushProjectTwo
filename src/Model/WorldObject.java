package Model;

public abstract class WorldObject {
    protected int x;
    protected int y;

    public WorldObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " at (" + x + "," + y + ")";
    }
}
