package Exercise_07;

public class AddCollection extends Collection implements Addable{


    @Override
    public int add(String s) {
        super.addItems(s);
        return super.getItems().size()-1;
    }
}
