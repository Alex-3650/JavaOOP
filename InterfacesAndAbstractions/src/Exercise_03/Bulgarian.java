package Exercise_03;

public class Bulgarian extends  PersonImpl{




    public Bulgarian(String name) {
        super(name);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
