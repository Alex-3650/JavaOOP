package Exercise_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collection  {

     private int maxSize=100;
     private final List<String>items;

    public Collection() {
        this.items=new ArrayList<>();
    }

    public List<String> getItems() {
        return  Collections.unmodifiableList(this.items);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void addItems(String item){

        this.items.add(item);
    }

    public String removeFirst(){
        return this.items.removeFirst();
    }
    public String removeLast(){
        return this.items.removeLast();
    }
    public void addFirst(String item){

        this.items.addFirst(item);
    }
}
