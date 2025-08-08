package Exercise_06.CAT;

public class Tomcat extends Cat{
    private static final String GENDER="Male";
    public Tomcat(int age, String gender, String name) {
        super(age,  GENDER,name);
    }


    @Override
    public String produceSound() {
        return "MEOW";
    }
}
