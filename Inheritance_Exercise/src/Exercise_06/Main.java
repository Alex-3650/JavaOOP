package Exercise_06;

import Exercise_06.CAT.Cat;
import Exercise_06.CAT.Kittens;
import Exercise_06.CAT.Tomcat;
import Exercise_06.Dog.Dog;
import Exercise_06.FROG.Frog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] arr = scanner.nextLine().split("\\s+");

        while (!line.equals("Beast!")) {
            try {

                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String gender = arr[2];

                switch (line) {
                    case "Cat" -> {
                        Cat cat = new Cat(age, gender, name);
                        System.out.println(cat);
                    }
                    case "Dog" -> {
                        Dog dog = new Dog(age, gender, name);
                        System.out.println(dog);
                    }
                    case "Frog" -> {
                        Frog frog = new Frog(age, gender, name);
                        System.out.println(frog);
                    }
                    case "Kitten" -> {
                        Kittens kitten = new Kittens(age, gender, name);
                        System.out.println(kitten);
                    }
                    case "Tomcat" -> {
                        Tomcat tomcat = new Tomcat(age, gender, name);
                        System.out.println(tomcat);
                    }


                }




            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input!");

            }
            line = scanner.nextLine();
            arr = scanner.nextLine().split("\\s+");
        }
    }
}






