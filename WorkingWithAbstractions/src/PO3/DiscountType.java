package PO3;

import java.lang.classfile.ClassElement;

public enum DiscountType {
    VIP(0.8),SECOND_VISIT(0.9),NONE(1);
      private final double discount;
    DiscountType(double discount) {
        this.discount=discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static DiscountType fromString(String text){


        switch (text){
            case "VIP"-> {
                return VIP;
            }
            case "SecondVisit"-> {
                return SECOND_VISIT;
            }
            case "NONE" -> {
                return NONE;
            }
            default -> {
                throw new IllegalArgumentException("The discount type: " +text+" is incorrect");
            }
        }
    }
}
