package model;

import map.Location;

public class Rabbit extends Herbivore {
    public Rabbit() {
        this.icon = "🐇";
        this.weight = 2;
        this.maxInCell = 150;
        this.speed = 2;
        this.foodRequired = 0.45;
    }

    @Override
    public void move(Location current, Location[][] map) {}
    @Override
    public void reproduce(Location location) {}
    @Override
    public Animal clone() {
        return new Rabbit();
    }
}