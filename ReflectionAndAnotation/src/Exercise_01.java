import Exe_05.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exercise_01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass().getName());

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i.getName());
        }

        Constructor<Reflection> constructor=clazz.getDeclaredConstructor();
        Reflection reflection = constructor.newInstance();
        constructor.setAccessible(true);
        System.out.println(reflection);

        Field[] declaredFields = clazz.getDeclaredFields();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        Field webAddress = clazz.getDeclaredField("webAddress");
        Field zip = clazz.getDeclaredField("zip");

        Class<?> type = webAddress.getType();
        webAddress.setAccessible(true);
        webAddress.set(reflection,"georgievalex807@gmail.com");

        System.out.println(reflection);

        Field nickName = clazz.getDeclaredField("nickName");
        nickName.setAccessible(true);
        //nickName.set(null,"Pig");



    }
}
