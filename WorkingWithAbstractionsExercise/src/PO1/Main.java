package PO1;

public class Main {
    public static void main(String[] args) {

        CardSuit[] values = CardSuit.values();
        for (CardSuit cardSuit : values) {
            System.out.printf("Ordinal cardSuit: %d; Name cardSuit: %s\n",cardSuit.ordinal(),cardSuit.name());
        }
        //Ordinal value: 0; Name value: CLUBS
        
    }
}
