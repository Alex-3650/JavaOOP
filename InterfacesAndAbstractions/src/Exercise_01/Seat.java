package Exercise_01;

import Exercise_02.Car;

public class Seat implements Car {

    private final String model;
    private final String color;
    private final String countryProduced;
    private final int getHorsePower;


    public Seat(String color, String countryProduced, Integer getHorsePower, String model) {
        this.color = color;
        this.countryProduced = countryProduced;
        this.getHorsePower = getHorsePower;
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
        return color;
    }

    @Override
    public int getHorsePower() {
        return getHorsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel(),countryProduced,TIRES);
    }
}
