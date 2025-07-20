package Model;

public class Mouse extends model.Herbivore {
    public Mouse(int x, int y) {
        super(x, y, 10, 1, 50, 1);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Mouse(newX, newY);
    }
}
