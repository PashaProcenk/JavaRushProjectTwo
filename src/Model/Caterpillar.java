package Model;

public class Caterpillar extends model.Herbivore {
    public Caterpillar(int x, int y) {
        super(x, y, 15, 1, 45, 1);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Caterpillar(newX, newY);
    }
}
