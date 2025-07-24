package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import Model.WorldObject;

public class Location {
    private final int x;
    private final int y;
    private final List<WorldObject> objectsAtLocation;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.objectsAtLocation = Collections.synchronizedList(new ArrayList<>());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addObject(WorldObject obj) {
        objectsAtLocation.add(obj);
    }

    public void removeObject(WorldObject obj) {
        objectsAtLocation.remove(obj);
    }

    public List<WorldObject> getObjects() {
        return new ArrayList<>(objectsAtLocation);
    }

    public <T extends WorldObject> List<T> getObjectsOfType(Class<T> type) {
        return objectsAtLocation.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Location{" + "x=" + x + ", y=" + y + ", objects=" + objectsAtLocation.size() + '}';
    }
}
