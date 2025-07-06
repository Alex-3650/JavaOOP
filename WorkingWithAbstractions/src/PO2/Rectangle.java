package PO2;

public class Rectangle {

    private final Point bottomLeft;
    private final Point topRight;



    public Rectangle(int bottomX,int bottomY,int TopX,int TopY){
        this.bottomLeft=new Point(bottomX,bottomY);
        this.topRight=new Point(TopX,TopY);

    }

    public boolean contains(Point point){

        return (point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()) && point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
    }
}
