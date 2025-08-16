package Vehicles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[]tokens=scanner.nextLine().split("\\s+");

        Vehicle car= new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
        String[] tokens2=scanner.nextLine().split("\\s+");
        Vehicle truck= new Truck(Double.parseDouble(tokens2[1]), Double.parseDouble(tokens2[2]));

        Map<String ,Vehicle >map=new HashMap<>();
        map.put(car.getClass().getSimpleName(),car);
        map.put(truck.getClass().getSimpleName(),truck);

        int n=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens=scanner.nextLine().split("\\s+");
            double parameter = Double.parseDouble(tokens[2]);
            Vehicle vehicle = map.get(tokens[1]);
            if (tokens[0].equals("Drive")){
                System.out.println( vehicle.drive(parameter));

            }else{

                vehicle.refuel(parameter);

            }

        }
      map.values().forEach(System.out::println);
    }

}
