package EXE_02;

import Exe_05.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Exercise_02 {

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();


       Arrays.stream(methods).filter(m->!m.getName().equals("toString"))
        .sorted(new ComparatorMethod())
               .forEach(m-> System.out.println(formatMethods(m)));






    }
    public static String formatMethods(Method method){
        if (method.getName().startsWith("get")){
            return String.format("%s will return class %s",method.getName(),method.getReturnType().getSimpleName());
        }
        return String.format("%s and will set field of class %s",method.getName(),method.getParameterTypes()[0]);

    }
}
