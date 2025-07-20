package Model;

public class Wolf extends model.Predator {
    public Wolf(int x, int y) {
        super(x, y, 50, 2, 20, 5, 15);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Wolf(newX, newY);
    }
}
