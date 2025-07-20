package Model;

public class Plant extends WorldObject {
    private int nutritionValue;

    public Plant(int x, int y, int nutritionValue) {
        super(x, y);
        this.nutritionValue = nutritionValue;
    }

    public int getNutritionValue() {
        return nutritionValue;
    }

    public void decreaseNutritionValue(int amount) {
        this.nutritionValue = Math.max(0, this.nutritionValue - amount);
    }

    public boolean isEmpty() {
        return nutritionValue <= 0;
    }
}
