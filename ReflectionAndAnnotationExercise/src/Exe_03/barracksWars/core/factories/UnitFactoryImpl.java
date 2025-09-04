package Exe_03.barracksWars.core.factories;

import Exe_03.barracksWars.interfaces.Unit;
import Exe_03.barracksWars.interfaces.UnitFactory;
import Exe_03.barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Exe_03.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
            try {
                Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
				Constructor<Unit> declaredConstructor = clazz.getDeclaredConstructor();
				declaredConstructor.setAccessible(true);
				return declaredConstructor.newInstance();

			} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
				System.out.println(e.getMessage());
            }
			return null;
    }
}
