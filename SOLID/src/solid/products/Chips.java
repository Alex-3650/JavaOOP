package solid.products;

public class Chips implements Food{

    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }


    @Override
    public double getAmountOfFood() {
        return getGrams()/1000;
    }

    @Override
    public double getCalories() {
        return  CALORIES_PER_100_GRAMS/100 * grams;
    }
}
