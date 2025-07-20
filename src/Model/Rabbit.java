package Model;

public class Rabbit extends Model.Herbivore {
    public Rabbit(int x, int y) {
        super(x, y, 20, 2, 40, 2);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Rabbit(newX, newY);
    }
}
