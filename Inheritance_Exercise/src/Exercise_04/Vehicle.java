package Exercise_04;

import javax.swing.*;

public class Vehicle {
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
    //•	fuelConsumption – double
    //•	fuel – double
    //•	horsePower – int
    //•	Getters and Setters for the fields
    //•	A public constructor which accepts (fuel, horsePower) and set the default fuel consumption on the field fuelConsumption
    //•	void drive(double kilometers)

    protected  final double DEFAULT_FUEL_CONSUMPTION=1.25;
    protected double fuelConsumption;
    protected double fuel;
    protected int horsePower;



    public Vehicle(double fuel,int horsePower){
        this.fuel=fuel;
        this.horsePower=horsePower;
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;
    }

    public void drive(double kilometers){
        final double CONSUMPTION=kilometers*this.fuelConsumption;
        if (CONSUMPTION>=fuel){
            this.setFuel(this.fuel - CONSUMPTION);
        }
    }




    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
