package engine;

import map.Island;
import map.Location;
import model.Animal;
import model.Wolf;

import java.util.Random;

public class AnimalGenerator {
    private final Island island;
    private final Random random = new Random();

    public AnimalGenerator(Island island) {
        this.island = island;
    }

    public void populateWolves(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(island.getWidth());
            int y = random.nextInt(island.getHeight());
            Location location = island.getLocation(x, y);
            Animal wolf = new Wolf();
            location.add(wolf);
        }
    }

}
