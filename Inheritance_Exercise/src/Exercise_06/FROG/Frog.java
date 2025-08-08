package Exercise_06.FROG;

import Exercise_06.Animal;

public class Frog extends Animal {
    public Frog(int age, String gender, String name) {
        super(age, gender, name);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
