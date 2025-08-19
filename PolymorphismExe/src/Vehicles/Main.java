package Vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[]tokens=scanner.nextLine().split("\\s+");

        Vehicle car= new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
        String[] tokens2=scanner.nextLine().split("\\s+");
        Vehicle truck= new Truck(Double.parseDouble(tokens2[1]), Double.parseDouble(tokens2[2]),Double.parseDouble(tokens2[3]));
        String[] tokens3=scanner.nextLine().split("\\s+");
        Vehicle bus= new Bus(Double.parseDouble(tokens3[1]), Double.parseDouble(tokens3[2]),Double.parseDouble(tokens3[3]));

        Map<String ,Vehicle >map=new LinkedHashMap<>();
        map.put(car.getClass().getSimpleName(),car);
        map.put(truck.getClass().getSimpleName(),truck);
        map.put(bus.getClass().getSimpleName(),bus);

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens=scanner.nextLine().split("\\s+");
            double parameter = Double.parseDouble(tokens[2]);
            Vehicle vehicle = map.get(tokens[1]);

            try {
                if (tokens[0].equals("Drive")){
                    if (vehicle.getClass().getSimpleName().equals("Bus")){
                        System.out.println(vehicle.driveFull(parameter));
                    }else {
                        System.out.println(vehicle.drive(parameter));
                    }

                }else if (tokens[0].equals("Refuel")){

                    vehicle.refuel(parameter);

                }else{
                    System.out.println(vehicle.drive(parameter));
                }

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


        }
      map.values().forEach(System.out::println);
    }

}
