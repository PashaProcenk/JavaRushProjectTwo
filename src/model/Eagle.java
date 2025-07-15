package model;

import map.Location;

public class Eagle extends Predator {
    public Eagle() {
        this.icon = "🦅";
        this.weight = 6;
        this.maxInCell = 20;
        this.speed = 3;
        this.foodRequired = 1;
    }

    @Override
    public void move(Location current, Location[][] map) {}
    @Override
    public void reproduce(Location location) {}
    @Override
    public Animal clone() {
        return new Eagle();
    }
}
