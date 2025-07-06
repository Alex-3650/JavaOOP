package PO3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");

        double pricePerDay= Double.parseDouble(arr[0]);
        int days=Integer.parseInt(arr[1]);
       Season season= Season.valueOf(arr[2].toUpperCase());
       DiscountType discountType=DiscountType.fromString(arr[3].toUpperCase());

        PriceCalculator calculator=new PriceCalculator(discountType,pricePerDay,days,season);
        System.out.printf("%.2f",calculator.calculatedPrice());
    }
}
