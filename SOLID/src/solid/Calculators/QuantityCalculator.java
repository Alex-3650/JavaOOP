package solid.Calculators;

import solid.products.Drinks;
import solid.products.Food;

import java.util.List;

public class QuantityCalculator {


    private QuantityCalculator() {
    }

    public static double sum(List<Food> products) {
        return  products.stream().mapToDouble(Food::getAmountOfFood).sum();
    }
    public static double sumDrinks(List<Drinks> products) {
        return  products.stream().mapToDouble(Drinks::getAmountInKG).sum();
    }

    public static double averageDrinks(List<Drinks> products) {
        return sumDrinks(products)/products.size();
    }


    public static  double average(List<Food> products) {
        return sum(products)/products.size();
    }
}
