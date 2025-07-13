package model;

import map.Location;

public abstract class Animal {
    protected String icon;
    protected double weight;
    protected int maxInCell;
    protected int speed;
    protected double foodRequired;
    protected boolean isAlive = true;

    public abstract void eat(Location location);
    public abstract void move(Location current, Location[][] map);
    public abstract void reproduce(Location location);
    public abstract Animal clone();

    public boolean isAlive() {
        return isAlive;
    }

    public String getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxInCell() {
        return maxInCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFoodRequired() {
        return foodRequired;
    }

}
