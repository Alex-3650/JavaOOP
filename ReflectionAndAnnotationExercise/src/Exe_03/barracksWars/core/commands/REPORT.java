package Exe_03.barracksWars.core.commands;

import Exe_03.barracksWars.interfaces.Executable;

public class REPORT implements Executable {
    private String[] data;

    public REPORT(String[] data) {
        this.data = data;
    }
    @Override
    public String execute() {
        return "";
    }
}
