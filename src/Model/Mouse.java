package Model;

public class Mouse extends Model.Herbivore {
    public Mouse(int x, int y) {
        super(x, y, 10, 1, 50, 1, "\\uD83D\\uDC01");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Mouse(newX, newY);
    }
}
