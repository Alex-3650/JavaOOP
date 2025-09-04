package solid.products;

public class Chocolate implements Food{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private final double grams;

    public Chocolate(double grams) {

        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS/100) * this.grams;
    }

    @Override
    public double getAmountOfFood() {
        return getGrams()/1000;
    }
}
