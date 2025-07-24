package statistics;

import java.util.Map;
import java.util.List;
import Model.WorldObject;

public class StatisticsPrinter {

    public static void printIslandStatistics(Map<String, List<WorldObject>> worldObjects) {
        System.out.println("\n--- Island Statistics (Tick " + System.currentTimeMillis() / 1000 + ") ---");
        worldObjects.forEach((type, list) -> {
            System.out.println(type + ": " + list.size());
        });
        System.out.println("-------------------------------------\n");
    }
}
