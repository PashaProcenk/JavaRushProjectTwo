package Model;

public class Boa extends Model.Predator {
    public Boa(int x, int y) {
        super(x, y, 40, 1, 15, 4, 10, "\uD83D\uDC0D");
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Boa(newX, newY);
    }
}