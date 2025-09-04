package Exe_05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredMethods()).
        filter(m-> m.getAnnotation(Author.class)!=null).
         forEach(m-> System.out.println(m.getAnnotation(Author.class).value()+
                 ": " +m.getName()));

    }
}
