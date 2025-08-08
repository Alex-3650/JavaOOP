package Exercise_06.CAT;

public class Kittens extends Cat{

    private static final String GENDER="Female";
    public Kittens(int age, String gender, String name) {
        super(age, GENDER, name);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
