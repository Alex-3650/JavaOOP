package PO3;

import PO1.CardSuit;

public class Cards {
    private final Card card;
    private final CardSuits cardSuit;

    public Cards(Card card,CardSuits cardSuit){
        this.card=card;
        this.cardSuit=cardSuit;
    }

    public Card getCard() {
        return card;
    }

    public CardSuits getCardSuit() {
        return cardSuit;

    }
      public int calculated(){
         return card.getPower()+cardSuit.getPower();
      }


}
