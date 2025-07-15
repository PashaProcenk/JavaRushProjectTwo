package model;

import map.Location;

public class Horse extends Herbivore {
    public Horse() {
        this.icon = "🐴";
        this.weight = 400;
        this.maxInCell = 20;
        this.speed = 4;
        this.foodRequired = 60;
    }

    @Override
    public void move(Location current, Location[][] map) {}
    @Override
    public void reproduce(Location location) {}
    @Override
    public Animal clone() {
        return new Horse();
    }
}
