package Exe_02.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

         Scanner scanner = new Scanner(System.in);

            String line=scanner.nextLine();


        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBox = declaredConstructor.newInstance();

        while (!line.equals("END")){
            String command= line.split("_")[0];
            int value= Integer.parseInt(line.split("_")[1]);

            Method declaredMethod = clazz.getDeclaredMethod(command, int.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(blackBox,value);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBox));


            line=scanner.nextLine();


        }


    }

    }


