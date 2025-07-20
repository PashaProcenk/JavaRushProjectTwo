package Model;

public class Buffalo extends model.Herbivore {
    public Buffalo(int x, int y) {
        super(x, y, 80, 1, 15, 8);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Buffalo(newX, newY);
    }
}