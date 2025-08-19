package Vehicles;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    protected double fuel_Quantity;
    protected double fuel_Consumption_Per_KM;
    protected double tank_Capacity;


    public void setTank_Capacity(double tank_Capacity) {

        if (fuel_Quantity>tank_Capacity){
            System.out.println("Cannot fit fuel in tank");
        }else {
            this.tank_Capacity = tank_Capacity;
        }
    }

    public void setFuel_Quantity(double fuel_Quantity) {
        if (fuel_Quantity<0){
            System.out.println("Fuel must be a positive number");
        }else {
            this.fuel_Quantity = fuel_Quantity;
        }

    }

    public AbstractVehicle(double fuel_Quantity, double fuel_Consumption_Per_KM,double tank_Capacity) {
      this.fuel_Quantity=fuel_Quantity;

        this.fuel_Consumption_Per_KM = fuel_Consumption_Per_KM;
        setTank_Capacity(tank_Capacity);

    }


    @Override
    public String drive(double km) {
        double needDistance=km*fuel_Consumption_Per_KM;
        if (fuel_Quantity>=needDistance){
            fuel_Quantity-=needDistance;

            return String.format("%s travelled %s km",getClass().getSimpleName(),DECIMAL_FORMAT.format(km));
        }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

    @Override
    public void refuel(double liters) {
        if (liters<=0){
            throw   new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuel_Quantity+liters>tank_Capacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        if (getClass().getSimpleName().equals("Truck")){
            fuel_Quantity+=liters*0.95;
        }else{
            fuel_Quantity+=liters;
        }

    }

    public void setFuel_Consumption_Per_KM(double fuel_Consumption_Per_KM) {
        this.fuel_Consumption_Per_KM = fuel_Consumption_Per_KM;
    }

    @Override
    public String toString() {

        return String.format("%s: %.2f",getClass().getSimpleName(),fuel_Quantity);
    }
}
