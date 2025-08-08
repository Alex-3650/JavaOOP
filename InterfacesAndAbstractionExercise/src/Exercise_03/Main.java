package Exercise_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String input=scanner.nextLine();
        List<Birthable> list=new ArrayList<>();

         while (!input.equalsIgnoreCase("End")){
             Birthable birthable = null;
             String name=input.split("\\s+")[0];

             if (name.equalsIgnoreCase("Pet")){
                  birthable=new Pet(input.split("\\s+")[1],input.split("\\s+")[2]);

             }else if (name.equalsIgnoreCase("Citizen")){
                     birthable=new Citizen(input.split("\\s+")[1],Integer.parseInt(input.split("\\s+")[2]),input.split("\\s+")[3],input.split("\\s+")[4]);

             }
             if (birthable!=null){
                 list.add(birthable);

             }
             input=scanner.nextLine();
         }

         String year=scanner.nextLine();

        for (Birthable birthable : list) {
            String birth=birthable.getBirthDate();
            if (birth.split("/")[2].equalsIgnoreCase(year)){
                System.out.println(birth);
            }
        }
    }
}
