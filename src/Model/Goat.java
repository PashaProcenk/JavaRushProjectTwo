package Model;

public class Goat extends model.Herbivore {
    public Goat(int x, int y) {
        super(x, y, 40, 2, 30, 4);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Goat(newX, newY);
    }
}