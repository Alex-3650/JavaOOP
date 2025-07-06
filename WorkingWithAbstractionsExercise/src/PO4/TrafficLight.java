package PO4;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color){
        this.color=color;
    }

    public void changeColor(){


        switch (color){


            case RED -> this.color=Color.GREEN;
            case GREEN -> this.color=Color.YELLOW;
            case YELLOW -> this.color=Color.RED;
            default -> throw new IllegalArgumentException("The data entered is incorrect!");
        }

    }
    public String getColor(){
        return color.name();
    }
}
