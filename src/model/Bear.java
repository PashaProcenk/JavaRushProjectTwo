package model;

import map.Location;

public class Bear extends Predator {
    public Bear() {
        this.icon = "🐻";
        this.weight = 500;
        this.maxInCell = 5;
        this.speed = 2;
        this.foodRequired = 80;
    }

    @Override
    public void move(Location current, Location[][] map) {}
    @Override
    public void reproduce(Location location) {}
    @Override
    public Animal clone() {
        return new Bear();
    }
}
