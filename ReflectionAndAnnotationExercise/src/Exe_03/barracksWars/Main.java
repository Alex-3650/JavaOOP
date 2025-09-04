package Exe_03.barracksWars;

import Exe_03.barracksWars.interfaces.Repository;
import Exe_03.barracksWars.interfaces.Runnable;
import Exe_03.barracksWars.interfaces.UnitFactory;
import Exe_03.barracksWars.core.Engine;
import Exe_03.barracksWars.core.factories.UnitFactoryImpl;
import Exe_03.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
