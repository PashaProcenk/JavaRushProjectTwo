package Model;

public class Fox extends model.Predator {
    public Fox(int x, int y) {
        super(x, y, 30, 2, 25, 3, 8);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Fox(newX, newY);
    }
}
