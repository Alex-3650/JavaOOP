import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers_03 {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

         List<Integer> numbers=new ArrayList<>();

         while (numbers.size()!=10){

             addNumber(numbers,scanner.nextLine());
         }
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));


    }

    private static void addNumber(List<Integer> numbers,String input) {
        int former=0;
        try {
            if (numbers.isEmpty()){
                former=Integer.parseInt(input);
                numbers.add(Integer.parseInt(input));
                return;
            }else{
                former=numbers.getLast();
            }
            if(former>=Integer.parseInt(input)){
                System.out.printf("Your number is not in range (%d – 100)\n",former);
            }else {
                numbers.add(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
        }



    }
}
