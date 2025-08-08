package Exercise_01;

import Exercise_02.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         Car seat =new Seat("gray","Spain",110,"Leon");

        System.out.printf("%s is %s color and have %s horse power%n",seat.getModel(),
                seat.getColor(),
                seat.getHorsePower());
        System.out.println(seat);


    }
}
