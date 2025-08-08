package Exercise_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[]arr=scanner.nextLine().split("\\s+");
         int n=Integer.parseInt(scanner.nextLine());

         AddCollection addCollection=new AddCollection();
        AddRemoveCollection addRemoveCollection=new AddRemoveCollection();
         MyListImpl myList=new MyListImpl();


        for (String string : arr) {
            System.out.print( addCollection.add(string)+" ");
        }
        System.out.println();
        for (String string : arr) {
            System.out.print( addRemoveCollection.add(string)+" ");
        }
        System.out.println();
        for (String string : arr) {
            System.out.print( myList.add(string)+" ");
        }
        System.out.println();
        for (String string : arr) {
            System.out.print( addRemoveCollection.remove()+" ");
        }
        System.out.println();
        for (String string : arr) {
            System.out.print(myList.remove()+" ");
        }


    }
}
