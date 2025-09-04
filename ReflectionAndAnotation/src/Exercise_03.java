import Exe_05.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise_03 {
    public static void main(String[] args) {

        Class<Reflection> aClass = Reflection.class;
        Field[] fields = aClass.getDeclaredFields();

        Arrays.stream(fields).
                sorted(Comparator.comparing(Field::getName))
                .filter(m-> !Modifier.isPrivate(m.getModifiers()))
                .forEach(m-> System.out.println(m.getName()+" must be private"));

        System.out.println();
        Arrays.stream(aClass.getDeclaredMethods()).
        filter(m->!m.getName().equals("toString")).
        sorted(Comparator.comparing(Method::getName)).
        filter(Exercise_03::filterByType).
                forEach(m-> System.out.println(formatPrint(m)));

    }
    public static boolean filterByType(Method method){
        return (method.getName().startsWith("get")&& !Modifier.isPublic(method.getModifiers()))
                ||(method.getName().startsWith("set")&& !Modifier.isPrivate(method.getModifiers()));

    }
    private static String formatPrint(Method method){

        String postFix = method.getName().startsWith("get") ?  "public!":"private!";

        return String.format("%s have to be %s",method.getName(),postFix);
    }
}
