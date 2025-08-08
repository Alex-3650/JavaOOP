package Exercise_06;

public class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(int age, String gender, String name) {
       setAge(age);
       setGender(gender);
        setName(name);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s %d %s\n%s",this.getClass().getSimpleName(),name,age,gender,produceSound());
    }

    public String produceSound(){

        return "";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.isBlank()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        if (name.isBlank()){
            throw new IllegalArgumentException("Invalid input!");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
