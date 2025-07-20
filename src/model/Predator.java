package model;

import java.util.List;
import java.util.stream.Collectors;

import Model.Animal;
import Model.WorldObject;
import util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil; // Це імпорт, який має бути

public abstract class Predator extends Animal {
    protected int attackPower;

    public Predator(int x, int y, int maxSatiety, int speed, int reproductionChance, int hungerPerTick, int attackPower) {
        super(x, y, maxSatiety, speed, reproductionChance, hungerPerTick);
        this.attackPower = attackPower;
    }

    @Override
    public void eat(List<WorldObject> availableFood) {
        List<Animal> prey = availableFood.stream()
                .filter(obj -> obj instanceof Animal && !(obj instanceof Predator))
                .map(obj -> (Animal) obj)
                .collect(Collectors.toList());

        if (!prey.isEmpty()) {
            Animal target = prey.get(RandomUtil.nextInt(prey.size())); // Виправлено тут
            int eatenAmount = Math.min(maxSatiety - satiety, target.getSatiety());
            this.satiety += eatenAmount;
            target.satiety -= eatenAmount;
            if (target.isDead()) {
                System.out.println(this.getType() + " at (" + x + "," + y + ") ate and killed " + target.getType());
            } else {
                System.out.println(this.getType() + " at (" + x + "," + y + ") ate " + target.getType());
            }
        }
    }

    @Override
    public int[] chooseMoveDirection(int mapWidth, int mapHeight) {
        // *** ПОМИЛКА БУЛА ТУТ, ВИПРАВЛЕНО: ***
        int dx = RandomUtil.nextInt(-1, 2); // Замість RandomUtil.nextInt(origin: -1, bound: 2);
        int dy = RandomUtil.nextInt(-1, 2); // Замість RandomUtil.nextInt(origin: -1, bound: 2);
        return new int[]{dx, dy};
    }
}
