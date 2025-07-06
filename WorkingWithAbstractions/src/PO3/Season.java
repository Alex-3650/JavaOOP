package PO3;

public enum Season {
    WINTER(3),SPRING(2),SUMMER(4),AUTUMN(1);

    private final int factor;
    Season(int factor) {
        this.factor=factor;
    }

    public int getFactor() {
        return factor;
    }
}
