package Exercise_03;

public class European extends PersonImpl{
    public European(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
