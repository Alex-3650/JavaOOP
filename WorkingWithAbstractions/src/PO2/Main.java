package PO2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int[]coordinates= readArray(scanner);

         Rectangle rectangle=new Rectangle(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);

         int pointsCount= Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < pointsCount; i++) {
            int []points=readArray(scanner);
            int pointX=points[0];
            int pointY=points[1];
            Point point=new Point(pointX,pointY);
            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
