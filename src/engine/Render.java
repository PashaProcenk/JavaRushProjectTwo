package engine;

import map.Island;
import map.Location;
import Model.WorldObject;
import Model.Animal;
import Model.Plant;

import java.util.List;

public class Render {

    public static void renderIsland(Island island) {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
        }

        System.out.print("+");
        for (int i = 0; i < island.getWidth(); i++) {
            System.out.print("--");
        }
        System.out.println("-+");

        for (int y = 0; y < island.getHeight(); y++) {
            System.out.print("|"); // Ліва межа карти
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                List<WorldObject> objects = location.getObjects();
                String content = "  "; // За замовчуванням - порожня клітинка

                if (!objects.isEmpty()) {
                    WorldObject topObject = objects.get(0);
                    if (topObject instanceof Animal) {
                        content = ((Animal) topObject).getIcon() + " ";
                    } else if (topObject instanceof Plant) {
                        content = ((Plant) topObject).getIcon() + " ";
                    }
                    if (content.length() > 2) {
                        content = content.substring(0, 2);
                    }
                }
                System.out.print(content);
            }
            System.out.println(" |");
        }

        System.out.print("+");
        for (int i = 0; i < island.getWidth(); i++) {
            System.out.print("--");
        }
        System.out.println("-+");
    }
}
