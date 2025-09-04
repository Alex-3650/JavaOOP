package solid;

import solid.Calculators.CalorieCalculator;
import solid.products.Product;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %.1f";
    private static final String AVERAGE = "Average: %.1f";

    public void printSum(List<Product> products) {


        System.out.printf((SUM) + "%n", CalorieCalculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", CalorieCalculator.average(products));
    }
}
