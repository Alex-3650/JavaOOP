package Exercise_03;

public abstract class PersonImpl implements Person{
    protected String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    public abstract String getName();

    public abstract String sayHello();
}
