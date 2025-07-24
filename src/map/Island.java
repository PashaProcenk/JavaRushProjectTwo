package map;

import Model.WorldObject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Island {
    private final int width;
    private final int height;
    private final Location[][] grid;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Location[width][height];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new Location(x, y);
            }
        }
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[x][y];
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addWorldObject(WorldObject obj) {
        Location location = getLocation(obj.getX(), obj.getY());
        if (location != null) {
            location.addObject(obj);
        }
    }

    public void removeWorldObject(WorldObject obj) {
        Location location = getLocation(obj.getX(), obj.getY());
        if (location != null) {
            location.removeObject(obj);
        }
    }

    public Map<String, List<WorldObject>> getAllWorldObjectsGroupedByType() {
        Map<String, List<WorldObject>> allObjects = new ConcurrentHashMap<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (WorldObject obj : grid[x][y].getObjects()) {
                    allObjects.computeIfAbsent(obj.getClass().getSimpleName(), k -> Collections.synchronizedList(new ArrayList<>())).add(obj);
                }
            }
        }
        return allObjects;
    }
}