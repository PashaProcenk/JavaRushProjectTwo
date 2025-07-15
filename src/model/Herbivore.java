package model;


import map.Location;
import java.util.Iterator;


public abstract class Herbivore extends Animal {
    @Override
    public void eat(Location location) {
        Iterator<Object> it = location.getInhabitants().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Plant && foodRequired > 0) {
                it.remove();
                foodRequired -= 1.0;
            }
        }
    }
}

