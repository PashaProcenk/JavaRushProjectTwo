package engine;

import map.Island;
import map.Location;
import model.*;

import java.util.Random;

public class AnimalGenerator {
    private final Island island;
    private final Random random = new Random();

    public AnimalGenerator(Island island) {
        this.island = island;
    }

    public void populateAllAnimals(int countPerType) {
        addAnimal(countPerType, new Wolf());
        addAnimal(countPerType, new Rabbit());
        addAnimal(countPerType, new Eagle());
        addAnimal(countPerType, new Mouse());
        addAnimal(countPerType, new Horse());
        addAnimal(countPerType, new Bear());
    }

    private void addAnimal(int count, Animal prototype) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(island.getWidth());
            int y = random.nextInt(island.getHeight());
            Location location = island.getLocation(x, y);
            Animal animal = prototype.clone();
            location.add(animal);
        }
    }
}
