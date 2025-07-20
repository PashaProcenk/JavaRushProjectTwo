package Model;

public class Boa extends model.Predator {
    public Boa(int x, int y) {
        super(x, y, 40, 1, 15, 4, 10);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Boa(newX, newY);
    }
}