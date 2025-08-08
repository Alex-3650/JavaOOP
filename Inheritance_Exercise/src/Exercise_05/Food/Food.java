package Exercise_05.Food;

import Exercise_05.Product;

import java.math.BigDecimal;

public class Food extends Product {
    //•	A constructor with the following parameters: String name, BigDecimal price, double grams
    //•	name – String
    //•	price – double
    //•	grams - double
    //•	Getter for grams

    private final double grams;

    public Food(String name, BigDecimal price,double grams) {
        super(name, price);
        this.grams=grams;
    }

    public double getGrams(double CAKE_GRAMS) {
        return grams;
    }




}
