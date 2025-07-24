package Model;

public class Bear extends Model.Predator {
    public Bear(int x, int y) {
        super(x, y, 70, 1, 10, 7, 20, "\uD83D\uDC3B");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Bear(newX, newY);
    }
}
