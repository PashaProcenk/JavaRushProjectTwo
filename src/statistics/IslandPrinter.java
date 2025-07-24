package statistics;

import map.Island;
import map.Location;
import model.Animal;
import model.Plant;

import java.util.List;

public class IslandPrinter {
    public static void print(Island island) {
        System.out.println("\n🌍 situation on the island :");

        Location[][] grid = island.getGrid();
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location loc = grid[y][x];
                String cell = getCellIcon(loc.getInhabitants());
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static String getCellIcon(List<Object> inhabitants) {
        int wolves = 0;
        int plants = 0;

        for (Object obj : inhabitants) {
            if (obj instanceof Animal) {
                Animal a = (Animal) obj;
                if ("🐺".equals(a.getIcon())) wolves++;
            } else if (obj instanceof Plant) {
                plants++;
            }
        }

        if (wolves > 0) return "🐺";
        if (plants > 0) return "🌿";
        return "▫️";
    }

}
