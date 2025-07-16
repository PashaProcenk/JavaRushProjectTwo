package engine.tasks;

import map.Island;
import map.Location;
import model.Plant;

import java.util.Random;

public class PlantGrowerTask implements Runnable {
    private final Island island;
    private final Random random = new Random();

    public PlantGrowerTask(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                if (random.nextDouble() < 0.3) { // 30% шанс зростання рослини
                    location.add(new Plant());
                }
            }
        }
        System.out.println("🌱 The plants grew");
    }
}
