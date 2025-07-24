package Model;

public class Buffalo extends Model.Herbivore {
    public Buffalo(int x, int y) {
        super(x, y, 80, 1, 15, 8, "\\uD83D\\uDC03");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Buffalo(newX, newY);
    }
}