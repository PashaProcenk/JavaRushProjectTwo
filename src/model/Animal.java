package Model;

import java.util.List;
import util.RandomUtil; // Використовуємо новий RandomUtil

public abstract class Animal extends WorldObject {
    public int satiety;
    protected int maxSatiety;
    protected int speed;
    protected int reproductionChance;
    protected int hungerPerTick;

    public Animal(int x, int y, int maxSatiety, int speed, int reproductionChance, int hungerPerTick) {
        super(x, y);
        this.maxSatiety = maxSatiety;
        this.satiety = maxSatiety / 2;
        this.speed = speed;
        this.reproductionChance = reproductionChance;
        this.hungerPerTick = hungerPerTick;
    }

    public abstract void eat(List<WorldObject> availableFood);
    public abstract Animal reproduce(int newX, int newY);
    public abstract int[] chooseMoveDirection(int mapWidth, int mapHeight);

    public void decreaseSatiety() {
        this.satiety = Math.max(0, this.satiety - hungerPerTick);
    }

    public boolean isHungry() {
        return satiety < maxSatiety / 4;
    }

    public boolean isDead() {
        return satiety <= 0;
    }

    public void move(int mapWidth, int mapHeight) {
        int[] direction = chooseMoveDirection(mapWidth, mapHeight);
        int newX = x + direction[0] * speed;
        int newY = y + direction[1] * speed;

        this.x = Math.max(0, Math.min(mapWidth - 1, newX));
        this.y = Math.max(0, Math.min(mapHeight - 1, newY));
    }

    public boolean canReproduce() {
        return satiety > maxSatiety / 2 && RandomUtil.nextInt(100) < reproductionChance;
    }

    public int getSatiety() {
        return satiety;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
