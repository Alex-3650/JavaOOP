package solid.products;

public interface Drinks extends Product {
    double getAmountInKG();

    @Override
    double getCalories();
}
