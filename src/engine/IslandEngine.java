package engine;

import map.Island;

public class IslandEngine {
    private final Island island;

    public IslandEngine() {
        this.island = new Island(20, 10);
    }

    public void start() {
        System.out.println("🌴 Island simulation started");
        System.out.println("Size of the island: 20 x 10");
    }
}


