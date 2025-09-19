package BuilderPattern;

public class Builder_Demo {


    public static void main(String[] args) {
         Address address=Address.builder().
                         setAddress1("Str.Stefan Karadzha").
                         setName("Ivan").
                         setPostCode("8600").
                         build();
        StringBuilder builder=new StringBuilder().append(4).append(12.4).append("I");

    }
}
