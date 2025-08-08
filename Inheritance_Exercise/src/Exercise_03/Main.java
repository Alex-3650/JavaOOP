package Exercise_03;

import Exercise_03.Knight.BladeKnight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int age=Integer.parseInt(scanner.nextLine());
         String name=scanner.nextLine();

        BladeKnight knight=new BladeKnight(age,name);
        System.out.println(knight);
    }
}
