package model;

import map.Location;

public class Wolf  extends Predator {
    public Wolf() {
        this.icon = "\uD83D\uDC3A"; // 🐺
        this.weight = 50;
        this.maxInCell = 30;
        this.speed = 3;
        this.foodRequired = 8;
    }

    @Override
    public void move(Location current, Location[][] map) {

    }

    @Override
    public void reproduce(Location location) {

    }

    @Override
    public Animal clone() {
        return new Wolf();
    }

}
