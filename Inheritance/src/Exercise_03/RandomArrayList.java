package Exercise_03;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement(){
        Random random=new Random();
        int index=ThreadLocalRandom.current().nextInt(0,size());
      return remove(index);
    }
}
