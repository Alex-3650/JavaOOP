package Vehicles;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    protected double fuel_Quantity;
    protected double fuel_Consumption_Per_KM;




    public AbstractVehicle(double fuel_Quantity, double fuel_Consumption_Per_KM) {
        this.fuel_Quantity = fuel_Quantity;
        this.fuel_Consumption_Per_KM = fuel_Consumption_Per_KM;

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
        if (getClass().getSimpleName().equals("Truck")){
            fuel_Quantity+=liters*0.95;
        }else{
            fuel_Quantity+=liters;
        }

    }

    @Override
    public String toString() {

        return String.format("%s: %.2f",getClass().getSimpleName(),fuel_Quantity);
    }
}
