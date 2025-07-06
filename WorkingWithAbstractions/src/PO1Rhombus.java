import java.util.Scanner;

public class PO1Rhombus {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int n =Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= n; i++) {

             printRhombus(n,i,"%");
            }
        for (int i = n-1; i >=1 ; i--) {
            printRhombus(n,i,"%");





        }
    }

    private static void printRhombus(int n, int i,String symbol) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print(symbol+" ");
        }
        System.out.println();
    }
}
