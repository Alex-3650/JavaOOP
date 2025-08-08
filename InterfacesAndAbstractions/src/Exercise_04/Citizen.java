package Exercise_04;

public class Citizen implements Identifiable{

    private final String name;
    private final String id;
    private final int age;

    public Citizen(String name,int age,String id){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return this.id;
    }



}
