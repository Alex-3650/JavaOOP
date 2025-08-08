package Exercise_07;

public class MyListImpl extends Collection implements MyList{
    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        String s=getItems().getFirst();
         super.removeFirst();
         return s;
    }

    @Override
    public int add(String s) {
        super.addFirst(s);
        return 0;
    }
}
