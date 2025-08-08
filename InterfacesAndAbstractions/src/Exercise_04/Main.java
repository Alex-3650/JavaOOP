package Exercise_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String line=scanner.nextLine();
        List<Identifiable>listIdentified=new ArrayList<>();

         while (!line.equalsIgnoreCase("end")){

             String [] tokens=line.split("\\s+");

             Identifiable identifiable;
             if (tokens.length==2){
                 identifiable=new Robot(tokens[1],tokens[0]);
             }else{
                 identifiable=new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
             }
             listIdentified.add(identifiable);

             line=scanner.nextLine();
         }

         String fakeId=scanner.nextLine();
         listIdentified.stream().
         filter(i->i.getId().endsWith(fakeId)).
         forEach(i-> System.out.println(i.getId()));
    }
}
