import java.util.Optional;
import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int start=scanner.nextInt();
        int end=scanner.nextInt();
        scanner.nextLine();

        String input=scanner.nextLine();
        System.out.println("Range: ["+start+"..."+end+"]");

        while (!validInput(input,start,end)){
            input=scanner.nextLine();

        }



    }

    private static boolean validInput(String input,int start,int end) {
        Optional <Integer>number=Optional.empty();
        try{
            number= Optional.of(Integer.parseInt(input));


        }catch (NumberFormatException ignored){


        }
        String output= String.valueOf("Invalid number: "+ input);
        if (number.isPresent() && number.get()>=start && number.get() <=end){
            output=String.valueOf("Valid number: "+ number.get());
        }

        System.out.println(output);
        return number.isPresent() && number.get()>=start && number.get() <=end;

    }
}
