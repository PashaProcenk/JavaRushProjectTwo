package Model;

public class Horse extends Model.Herbivore {
    public Horse(int x, int y) {
        super(x, y, 60, 3, 30, 6);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Horse(newX, newY);
    }
}
