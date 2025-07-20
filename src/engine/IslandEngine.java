package engine;

import map.Island;
import map.Location;
import Model.WorldObject;
import Model.Plant;
import Model.Animal;
import Model.*;
import statistics.StatisticsPrinter;
import util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class IslandEngine {
    private Island island; //
    private final ScheduledExecutorService scheduledPool;
    private final int animalThreadPoolSize = 5;
    private final int plantGrowthIntervalSeconds = 5;
    private final int animalLifeCycleIntervalSeconds = 1;
    private final int statisticsIntervalSeconds = 2;

    public IslandEngine(int width, int height) {
        this.island = new Island(width, height); // Створюємо об'єкт Island
        this.scheduledPool = Executors.newScheduledThreadPool(3);
        initializeIslandPopulation();
    }

    private void initializeIslandPopulation() {
        // Додаємо трохи рослин на початку
        for (int i = 0; i < island.getWidth() * island.getHeight() / 10; i++) {
            int x = RandomUtil.nextInt(island.getWidth());
            int y = RandomUtil.nextInt(island.getHeight());
            Location location = island.getLocation(x, y);
            boolean plantExists = location.getObjectsOfType(Plant.class).stream().anyMatch(p -> true);
            if (!plantExists) {
                island.addWorldObject(new Plant(x, y, 20 + RandomUtil.nextInt(30)));
            }
        }

        // Додаємо початкових тварин
        island.addWorldObject(new Wolf(5, 5));
        island.addWorldObject(new Wolf(6, 6));
        island.addWorldObject(new Boa(10, 10));
        island.addWorldObject(new Fox(2, 8));
        island.addWorldObject(new Bear(15, 3));
        island.addWorldObject(new Eagle(1, 1));

        island.addWorldObject(new Horse(0, 0));
        island.addWorldObject(new Deer(1, 2));
        island.addWorldObject(new Rabbit(3, 4));
        island.addWorldObject(new Mouse(7, 7));
        island.addWorldObject(new Goat(9, 1));
        island.addWorldObject(new Sheep(12, 12));
        island.addWorldObject(new Boar(4, 18));
        island.addWorldObject(new Buffalo(18, 5));
        island.addWorldObject(new Duck(10, 15));
        island.addWorldObject(new Caterpillar(11, 15));
    }

    private Runnable plantGrowthTask = () -> {
        System.out.println("--- Tick: Plants growing ---");
        // Логіка додавання нових рослин
        if (island.getAllWorldObjectsGroupedByType().getOrDefault(Plant.class.getSimpleName(), Collections.emptyList()).size() < island.getWidth() * island.getHeight() / 5) {
            int x = RandomUtil.nextInt(island.getWidth());
            int y = RandomUtil.nextInt(island.getHeight());
            Location location = island.getLocation(x, y);
            boolean plantExists = location.getObjectsOfType(Plant.class).stream().anyMatch(p -> true);
            if (!plantExists) {
                island.addWorldObject(new Plant(x, y, 10 + RandomUtil.nextInt(20)));
            }
        }
    };

    private Runnable animalLifeCycleTask = () -> {
        System.out.println("--- Tick: Animal life cycle ---");
        try (var animalPool = Executors.newFixedThreadPool(animalThreadPoolSize)) {
            // Отримуємо всіх тварин через Island
            Map<String, List<WorldObject>> currentObjects = island.getAllWorldObjectsGroupedByType();
            List<Animal> animalsToProcess = currentObjects.values().stream()
                    .flatMap(List::stream)
                    .filter(obj -> obj instanceof Animal)
                    .map(obj -> (Animal) obj)
                    .collect(Collectors.toList());

            List<Animal> newAnimals = Collections.synchronizedList(new ArrayList<>());
            List<Animal> deadAnimals = Collections.synchronizedList(new ArrayList<>());

            for (Animal animal : animalsToProcess) {
                animalPool.submit(() -> {
                    if (animal.isDead()) {
                        deadAnimals.add(animal);
                        return;
                    }

                    animal.decreaseSatiety();
                    if (animal.isDead()) {
                        deadAnimals.add(animal);
                        return;
                    }

                    Location oldLocation = island.getLocation(animal.getX(), animal.getY());
                    if (oldLocation != null) oldLocation.removeObject(animal);

                    animal.move(island.getWidth(), island.getHeight());
                    Location newLocation = island.getLocation(animal.getX(), animal.getY());
                    if (newLocation != null) newLocation.addObject(animal);

                    List<WorldObject> foodInLocation = newLocation.getObjects();
                    if (animal.isHungry() && !foodInLocation.isEmpty()) {
                        animal.eat(foodInLocation);
                        foodInLocation.stream()
                                .filter(obj -> (obj instanceof Animal && ((Animal) obj).isDead()) || (obj instanceof Plant && ((Plant) obj).isEmpty()))
                                .forEach(newLocation::removeObject);
                    }

                    if (animal.canReproduce()) {
                        boolean foundMate = animalsToProcess.stream()
                                .filter(other -> other != animal && other.getClass().equals(animal.getClass()) &&
                                        Math.abs(other.getX() - animal.getX()) <= 1 && Math.abs(other.getY() - animal.getY()) <= 1)
                                .findAny().isPresent();

                        if (foundMate) {
                            int newX = animal.getX() + RandomUtil.nextInt(-1, 2);
                            int newY = animal.getY() + RandomUtil.nextInt(-1, 2);
                            newX = Math.max(0, Math.min(island.getWidth() - 1, newX));
                            newY = Math.max(0, Math.min(island.getHeight() - 1, newY));

                            Animal offspring = animal.reproduce(newX, newY);
                            newAnimals.add(offspring);
                            System.out.println(animal.getType() + " at (" + animal.getX() + "," + animal.getY() + ") reproduced. New " + offspring.getType() + " at (" + newX + "," + newY + ")");
                        }
                    }
                });
            }

            animalPool.shutdown();
            try {
                animalPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            newAnimals.forEach(island::addWorldObject);
            deadAnimals.forEach(animal -> {
                Location loc = island.getLocation(animal.getX(), animal.getY());
                if (loc != null) {
                    loc.removeObject(animal);
                }
            });
        }
    };

    private Runnable statisticsTask = () -> {
        StatisticsPrinter.printIslandStatistics(island.getAllWorldObjectsGroupedByType());
    };

    public void startSimulation() {
        scheduledPool.scheduleAtFixedRate(plantGrowthTask, 0, plantGrowthIntervalSeconds, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(animalLifeCycleTask, 0, animalLifeCycleIntervalSeconds, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(statisticsTask, 0, statisticsIntervalSeconds, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scheduledPool.shutdown();
            System.out.println("Simulation stopped. Shutting down scheduled thread pool.");
        }));
    }
}
