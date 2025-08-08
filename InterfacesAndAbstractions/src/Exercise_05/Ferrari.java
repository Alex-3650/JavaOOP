package Exercise_05;

public class Ferrari implements Car {
     private final String driverName;
     private final String model="488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;

    }

    public String getDriverName() {
        return driverName;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",model,brakes(),gas(),getDriverName());
    }
}
