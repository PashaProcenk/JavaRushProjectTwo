package Model;

public class Deer extends model.Herbivore {
    public Deer(int x, int y) {
        super(x, y, 55, 3, 35, 5);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Deer(newX, newY);
    }
}
