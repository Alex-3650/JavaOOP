package org.example;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestAxe {

    public static final int HEALTH = 100;
    public static final int EXPERIENCE = 200;
    private static final int ATTACK=45;
    private static final int DURABILITY=56;
    private Dummy dummy;
    private Axe axe;

  @Before
  public void setUp(){
       this.axe=new Axe(ATTACK,DURABILITY);
       this.dummy=new Dummy(HEALTH, EXPERIENCE) {
       };
  }


    @Test
    public void test_Axe_losesDurability_afterEveryAttack(){


        assertEquals(ATTACK,axe.getAttackPoints());
        assertEquals(DURABILITY,axe.getDurabilityPoints());

    }
    @Test(expected =  IllegalStateException.class)
    public void test_AttackingWith_BrokenExe(){
        Axe axe=new Axe(ATTACK,0);


        axe.attack(dummy);

    }
}

