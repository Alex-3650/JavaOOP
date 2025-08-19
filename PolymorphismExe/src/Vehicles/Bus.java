package Vehicles;

import java.text.DecimalFormat;

public class Bus extends AbstractVehicle{
    private static final boolean IS_EMPTY = true;
    private boolean isEmpty;
    private static final DecimalFormat DECIMAL_FORMAT=new DecimalFormat("#.##");



    public Bus(double fuel_Quantity, double fuel_Consumption_Per_KM, double tank_Capacity) {
        super(fuel_Quantity, fuel_Consumption_Per_KM, tank_Capacity);
        this.isEmpty=true;
    }

    @Override
    public void setFuel_Consumption_Per_KM(double fuel_Consumption_Per_KM) {
        if (!isEmpty){
            super.setFuel_Consumption_Per_KM(fuel_Consumption_Per_KM+1.4);
        }

    }
    @Override
    public String driveFull(double distance){
        this.fuel_Consumption_Per_KM+=1.4;
        double needDistance=distance*fuel_Consumption_Per_KM;
        if (fuel_Quantity>=needDistance){
            fuel_Quantity-=needDistance;

            return String.format("%s travelled %s km",getClass().getSimpleName(),DECIMAL_FORMAT.format(distance));
        }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

}
