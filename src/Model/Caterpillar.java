package Model;

public class Caterpillar extends Model.Herbivore {
    public Caterpillar(int x, int y) {
        super(x, y, 15, 1, 45, 1, "\\uD83D\\uDC1B");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Caterpillar(newX, newY);
    }
}
