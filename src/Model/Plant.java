package Model;

public class Plant extends WorldObject {
    private int nutritionValue;
    private String icon;


    public Plant(int x, int y, int nutritionValue) {
        super(x, y);
        this.nutritionValue = nutritionValue;
        this.icon = "\uD83C\uDF31";
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

    public String getIcon() {
        return icon;
    }
}
