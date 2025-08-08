package Exercise_06.Dog;

import Exercise_06.Animal;

public class Dog extends Animal {
    public Dog(int age, String gender, String name) {
        super(age, gender, name);
    }
    @Override
    public String produceSound() {
        return "Woof!";
    }
}
