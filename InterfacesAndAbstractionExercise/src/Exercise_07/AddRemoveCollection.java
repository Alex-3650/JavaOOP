package Exercise_07;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String  remove() {
        String s=getItems().getLast();
     super.removeLast();
     return s;
    }

    @Override
    public int add(String s) {
       super.addFirst(s);
       return 0;
    }
}
