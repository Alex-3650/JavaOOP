package Exercise_02;

public class Seat extends CarImpl implements Sellable{

    private final Double price;
    protected Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model, color, horsePower, countryProduced);
        this.price=price;
    }


    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("\n%s sells for %f",super.getModel(),getPrice());
    }

}
