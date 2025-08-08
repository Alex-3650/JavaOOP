package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestHero {

 private final static int EXPERIENCE=200;

    @Test
    public void test_Hero_Gets_Experience_AfterTargetDies(){

           Weapon weapon= mock(Weapon.class);

       Target target= mock(Target.class);
      when(target.isDead()).thenReturn(true);
      when(target.giveExperience()).thenReturn(EXPERIENCE);
        Hero hero=new Hero("Ivan",weapon);

        hero.attack(target  );
        assertEquals(EXPERIENCE,hero.getExperience());
    }
}
