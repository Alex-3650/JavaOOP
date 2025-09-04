package Exe_01.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] declaredField = clazz.getDeclaredFields();

		String modifier= scanner.nextLine();

		while (!modifier.equals("HARVEST")){

            if (modifier.equals("all")) {
                Arrays.stream(declaredField).
                        forEach(Main::printField);
            } else {
                String finalLine = modifier;
                Arrays.stream(declaredField).filter(m -> Modifier.toString(m.getModifiers()).equals(finalLine)).
                        forEach(Main::printField);
            }

			modifier= scanner.nextLine();
		}

	}
	public static void printField(Field m){

		System.out.printf("%s %s %s\n",Modifier.toString(m.getModifiers()),m.getType().getSimpleName(),m.getName());
	}


}
