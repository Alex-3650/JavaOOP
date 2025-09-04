import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String num=scanner.nextLine();
         try {
         int number=Integer.parseInt(num);
             if (number>=0){
                 double sqrt = Math.sqrt(number);
                 System.out.printf("%.2f\n",sqrt);
                 return;
             }else{
                 throw new NumberFormatException();
             }


         }catch (NumberFormatException e){
             System.out.println("Invalid");

         }

         finally {
             System.out.println("Goodbye");
         }


    }
}
