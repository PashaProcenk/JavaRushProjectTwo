package Model;

import java.util.List;
import java.util.stream.Collectors;

import Model.Animal;
import Model.Plant;
import Model.WorldObject;
import util.RandomUtil;

public abstract class Herbivore extends Animal { // Наслідується від Animal
    public Herbivore(int x, int y, int maxSatiety, int speed, int reproductionChance, int hungerPerTick) {
        super(x, y, maxSatiety, speed, reproductionChance, hungerPerTick);
    }

    @Override
    public void eat(List<WorldObject> availableFood) {
        List<Plant> plants = availableFood.stream()
                .filter(obj -> obj instanceof Plant)
                .map(obj -> (Plant) obj)
                .collect(Collectors.toList());

        if (!plants.isEmpty()) {
            Plant targetPlant = plants.get(RandomUtil.nextInt(plants.size()));
            int eatingAmount = Math.min(maxSatiety - satiety, targetPlant.getNutritionValue());
            this.satiety += eatingAmount;
            targetPlant.decreaseNutritionValue(eatingAmount);
            System.out.println(this.getType() + " at (" + x + "," + y + ") ate plant. Satiety: " + satiety);
        }
    }

    @Override
    public int[] chooseMoveDirection(int mapWidth, int mapHeight) {
        int dx = RandomUtil.nextInt(-1, 2);
        int dy = RandomUtil.nextInt(-1, 2);
        return new int[]{dx, dy};
    }
}
