package Exe_03.barracksWars.core.commands;

import Exe_03.barracksWars.core.Engine;
import Exe_03.barracksWars.interfaces.Executable;
import Exe_03.barracksWars.interfaces.Repository;
import Exe_03.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ADD implements Executable {

    private String[] data;

    public ADD(String[] data) {
        this.data = data;
    }

    @Override
    public String execute() {
            try {
                Class<Engine> clazz = Engine.class;
                Method addUnitCommand = clazz.getDeclaredMethod("addUnitCommand", String[].class);
                addUnitCommand.setAccessible(true);
                return (String) addUnitCommand.invoke(clazz,  data);

            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }



    }
}
