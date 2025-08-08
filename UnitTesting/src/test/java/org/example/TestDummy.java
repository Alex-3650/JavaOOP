package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class TestDummy {

      private static final int HEALTH = 100;
    private static final int EXPERIENCE= 50;
    private static final int ATTACK_DAMAGE= 10;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() throws Exception {
       dummy=new Dummy(HEALTH,EXPERIENCE);
        deadDummy=new Dummy(0,EXPERIENCE);
    }
    @Test
    public void test_AliveDummy_LosesHealth_AfterAttack(){
        dummy.takeAttack(ATTACK_DAMAGE);
        assertEquals(HEALTH-ATTACK_DAMAGE,dummy.getHealth());

    }
    @Test(expected= IllegalStateException.class)
    public void test_DeadDummy_throwsException_IfAttacked(){

        deadDummy.takeAttack(ATTACK_DAMAGE);
    }
    @Test
    public void test_DeadDummy_CanGiveExperience(){

        assertEquals(EXPERIENCE,deadDummy.giveExperience());
    }
    @Test(expected = IllegalStateException.class)
    public void test_AliveDummy_CannotGiveExperience(){
        
        dummy.giveExperience();
    }
}
