package Model;

public class Sheep extends Model.Herbivore {
    public Sheep(int x, int y) {
        super(x, y, 45, 1, 35, 4, "\uD83D\uDC11");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Sheep(newX, newY);
    }
}
