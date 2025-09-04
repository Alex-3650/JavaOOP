package solid;

import solid.products.Food;

public class Cloud implements Food {
    @Override
    public double getAmountOfFood() {
        return 0;
    }

    @Override
    public double getCalories() {
        return 0;
    }
}
