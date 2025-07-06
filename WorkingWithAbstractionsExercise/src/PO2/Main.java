package PO2;

import PO1.CardSuit;

public class Main {
    public static void main(String[] args) {
        Card[] cards = Card.values();
        System.out.println("Card Ranks:");
        for (Card card : cards) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",card.ordinal(),card.name());
        }
    }
}
