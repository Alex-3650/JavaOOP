package Exercise_03;

public class Chinese extends PersonImpl{
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
