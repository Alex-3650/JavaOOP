package Exercise_02;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer TIRES=4;
    String getModel();
    String getColor();
    String countryProduced();
    int getHorsePower();
}
