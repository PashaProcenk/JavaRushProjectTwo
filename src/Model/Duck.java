package Model;

import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Duck extends Model.Herbivore {
    public Duck(int x, int y) {
        super(x, y, 25, 2, 30, 3,"\\uD83E\\uDD86");
    }

    @Override
    public void eat(List<WorldObject> availableFood) {
        List<Caterpillar> caterpillars = availableFood.stream()
                .filter(obj -> obj instanceof Caterpillar)
                .map(obj -> (Caterpillar) obj)
                .collect(Collectors.toList());

        if (!caterpillars.isEmpty()) {
            Caterpillar targetCaterpillar = caterpillars.get(RandomUtil.nextInt(caterpillars.size()));
            int eatingAmount = Math.min(maxSatiety - satiety, targetCaterpillar.getSatiety());
            this.satiety += eatingAmount;
            targetCaterpillar.satiety -= eatingAmount;
            if (targetCaterpillar.isDead()) {
                System.out.println(this.getType() + " at (" + x + "," + y + ") ate and killed " + targetCaterpillar.getType());
            } else {
                System.out.println(this.getType() + " at (" + x + "," + y + ") ate " + targetCaterpillar.getType());
            }
        } else {
            super.eat(availableFood);
        }
    }

    @Override
    public Animal reproduce(int newX, int newY) {
        return new Duck(newX, newY);
    }
}
