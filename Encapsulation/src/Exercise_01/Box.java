package Exercise_01;

public class Box {
    private  double length;
    private  double width;
    private  double height;

    public Box(double height, double length, double width) {
          validation(height,length,width);
        setHeight(height);
       setLength(length);
        setWidth(width);
    }



    private static void validation(double height, double length, double width) {
      if (height<=0){
          throw new IllegalArgumentException("Height cannot be 0 or negative!");
      }
        if (length<=0){
            throw new IllegalArgumentException("Length cannot be 0 or negative!");
        }
        if (width<=0){
            throw new IllegalArgumentException("Width cannot be 0 or negative!");
        }
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setLength(double length) {
        this.length = length;
    }

   private void setWidth(double width) {
        this.width = width;
    }


    public double calculateSurfaceArea(){
          return  2 * length * width+ 2 * length * height + 2 * width * height;
    }
    public double calculateLateralSurface(){
          return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume(){
        return length * height * width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume - %.2f",calculateSurfaceArea(),calculateLateralSurface(),calculateVolume());
    }
}
