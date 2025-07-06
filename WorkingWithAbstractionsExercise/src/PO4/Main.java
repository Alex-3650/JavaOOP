package PO4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);

         Color [] color= Arrays.stream(scanner.nextLine().split("\\s+")).map(Color::valueOf).toArray(Color[]::new);

         int n=Integer.parseInt(scanner.nextLine());
        List<TrafficLight>trafficLights=new ArrayList<>();
        for (Color color1 : color) {
            TrafficLight trafficLight=new TrafficLight(color1);
            trafficLights.add(trafficLight);
        }

        for (int i = 1; i <=n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor()+" ");
            }
            System.out.println();
            
        }
        
    }
}
