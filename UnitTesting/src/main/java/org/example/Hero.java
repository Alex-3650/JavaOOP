package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;

    private List<Weapon> weaponList;

    public Hero(String name,Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.weaponList=new ArrayList<>();
        weaponList.add(axe);
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public List<Weapon> getWeapon() {
        return this.weaponList;
    }

    public void attack(Target target) {
        this.weaponList.stream().findFirst().orElseThrow(()->new IllegalStateException("No weapon found!")).attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
