package engine.tasks;

import map.Island;
import map.Location;
import model.Animal;

import java.util.List;

public class AnimalLifeCycleTask implements Runnable {
    private final Island island;

    public AnimalLifeCycleTask(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        Location[][] grid = island.getGrid();
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = grid[y][x];
                List<Object> inhabitants = location.getInhabitants();

                for (Object obj : List.copyOf(inhabitants)) {
                    if (obj instanceof Animal animal) {
                        animal.eat(location);
                        animal.reproduce(location);
                        // move() потребує сусідів – реалізуємо пізніше
                    }
                }
            }
        }
        System.out.println("🐾 Animal life cycle updated.");
    }
}
