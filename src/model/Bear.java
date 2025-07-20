package Model;

public class Bear extends model.Predator {
    public Bear(int x, int y) {
        super(x, y, 70, 1, 10, 7, 20);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Bear(newX, newY);
    }
}
