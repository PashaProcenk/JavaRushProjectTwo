package Model;

public class Boar extends Model.Herbivore {
    public Boar(int x, int y) {
        super(x, y, 50, 2, 25, 5);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Boar(newX, newY);
    }
}
