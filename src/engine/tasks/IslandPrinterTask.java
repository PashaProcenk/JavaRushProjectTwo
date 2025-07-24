package engine.tasks;

import map.Island;
import model.Animal;
import model.Plant;
import statistics.IslandPrinter;

import java.util.List;

public class IslandPrinterTask implements Runnable {
    private final Island island;

    public IslandPrinterTask(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        IslandPrinter.print(island);
    }

    private static String getCellIcon(List<Object> inhabitants) {
        for (Object obj : inhabitants) {
            if (obj instanceof Animal animal) {
                return animal.getIcon(); // повертає іконку будь-якої тварини
            } else if (obj instanceof Plant) {
                return "🌿";
            }
        }
        return "▫️";
    }
}

