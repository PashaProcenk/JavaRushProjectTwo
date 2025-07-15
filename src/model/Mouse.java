package model;

import map.Location;

public class Mouse extends Herbivore {
    public Mouse() {
        this.icon = "🐁";
        this.weight = 0.05;
        this.maxInCell = 500;
        this.speed = 1;
        this.foodRequired = 0.01;
    }

    @Override
    public void move(Location current, Location[][] map) {}
    @Override
    public void reproduce(Location location) {}
    @Override
    public Animal clone() {
        return new Mouse();
    }
}
