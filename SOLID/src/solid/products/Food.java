package solid.products;

public interface Food extends Product{

    double getAmountOfFood();

    @Override
    double getCalories();
}
