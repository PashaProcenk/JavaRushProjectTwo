package Model;

public class Eagle extends Model.Predator {
    public Eagle(int x, int y) {
        super(x, y, 35, 3, 20, 4, 12);
    }
    @Override
    public Animal reproduce(int newX, int newY) {
        return new Eagle(newX, newY);
    }
}
