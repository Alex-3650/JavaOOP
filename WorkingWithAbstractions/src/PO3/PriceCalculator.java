package PO3;

public class PriceCalculator {
    //{pricePerDay} {numberOfDays} {season} {discountType}
    private final double pricePerDay;
    private final int numberOfDays;
    private final Season season;
    private final DiscountType discountType;

    public PriceCalculator(DiscountType discountType, double pricePerDay, int numberOfDays, Season season) {
        this.discountType = discountType;
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
    }
    public double calculatedPrice(){
         return  pricePerDay*numberOfDays*season.getFactor()*discountType.getDiscount();


    }




}
