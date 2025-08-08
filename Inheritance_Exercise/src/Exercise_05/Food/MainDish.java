package Exercise_05.Food;

import java.math.BigDecimal;

public class MainDish extends Food{

    private static final double SALMON_GRAMS = 22;
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, SALMON_GRAMS);
    }


}
