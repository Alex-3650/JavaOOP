package Vehicles;

public class Car extends AbstractVehicle {
    public Car(double fuel_Quantity, double fuel_Consumption_Per_KM,double tank_Capacity) {
        super(fuel_Quantity, fuel_Consumption_Per_KM+0.9,tank_Capacity);
    }





}
