package Exercise_03;

public class Main {
    public static void main(String[] args) {

        RandomArrayList <Integer>numbers=new RandomArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(9);
        System.out.println(  numbers.getRandomElement());
        System.out.println(numbers);
    }
}
