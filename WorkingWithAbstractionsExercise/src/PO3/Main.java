package PO3;

import PO1.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String name=scanner.nextLine();
         String clubType=scanner.nextLine();

       Cards cards=new Cards(Card.valueOf(name.toUpperCase()), CardSuits.valueOf(clubType.toUpperCase()));

        System.out.printf("Card name: %s of %s; Card power: %d\n",cards.getCard(),cards.getCardSuit(),cards.calculated());
    }
}
