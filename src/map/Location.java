package map;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final int x;
    private final int y;
    private final List<Object> inhabitants = new ArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public List<Object> getInhabitants() {
        return inhabitants;
    }

    public void add(Object obj) {
        inhabitants.add(obj);
    }

    public void remove(Object obj) {
        inhabitants.remove(obj);
    }

}
