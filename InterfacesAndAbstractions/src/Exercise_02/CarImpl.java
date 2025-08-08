package Exercise_02;

public class CarImpl implements Car{
    private final String model;
    private final String color;
    private final String countryProduced;
    private final int horsePower;


    protected CarImpl(String model, String color, int horsePower, String countryProduced){
        this.color = color;
        this.countryProduced = countryProduced;
        this.horsePower = horsePower;
        this.model = model;
    }
    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String .format( "This is %s produced in %s and have %d tires", getModel(),countryProduced,TIRES);
    }
}
