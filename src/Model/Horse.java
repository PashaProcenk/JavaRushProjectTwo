package Model;

public class Horse extends Model.Herbivore {
    public Horse(int x, int y) {
        super(x, y, 60, 3, 30, 6, "\uD83D\uDC0E");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Horse(newX, newY);
    }
}
