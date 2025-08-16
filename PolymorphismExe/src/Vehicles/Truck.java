package Vehicles;

public class Truck extends AbstractVehicle {


    public Truck(double fuel_Quantity, double fuel_Consumption_Per_KM) {
        super(fuel_Quantity, fuel_Consumption_Per_KM+1.6);
    }



}
