package Exe_03.barracksWars.core.commands;

import Exe_03.barracksWars.interfaces.Executable;

public class FIGHT implements Executable {

    private String[] data;

    public FIGHT(String[] data) {
        this.data = data;
    }
    @Override
    public String execute() {
        return "";
    }
}
