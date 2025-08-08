package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Dummy implements Target{

    private int health;
    private final int experience;
    private final List<Weapon> weaponsList;

    public Dummy(int health, int experience,List<Weapon>list) {
        this.health = health;
        this.experience = experience;
        this.weaponsList=list;
    }
    public Dummy(int health, int experience) {
       this(health,experience,new ArrayList<>());
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public Optional<Weapon> getInventory() {

        if (weaponsList.isEmpty()){
            return Optional.empty();
        }
        int index=ThreadLocalRandom.current().nextInt(0,weaponsList.size());
        return Optional.of(weaponsList.remove(index));

    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
