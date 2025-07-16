package engine;

import engine.tasks.AnimalLifeCycleTask;
import engine.tasks.IslandPrinterTask;
import engine.tasks.PlantGrowerTask;
import map.Island;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandEngine {
    private final Island island;

    public IslandEngine() {
        this.island = new Island(20, 10);
    }

    public void start() {
        System.out.println("🌴 Island simulation started");
        System.out.println("Size of the island: 20 x 10");

        AnimalGenerator generator = new AnimalGenerator(island);
        generator.populateAllAnimals(20);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.scheduleAtFixedRate(new PlantGrowerTask(island), 0, 5, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(new AnimalLifeCycleTask(island), 0, 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(new IslandPrinterTask(island), 0, 6, TimeUnit.SECONDS);

        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            scheduler.shutdownNow();
            System.out.println("🛑 Simulation finish.");
        }, 60, TimeUnit.SECONDS);
    }
}




