package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

class DummyTest {
    private static final int HEALTH=100;
    private static final int EXPERIENCE=12;
    private static final int ATTACK=22;
    private Dummy dummy;
    private Dummy deadDummy;

    @BeforeEach
            public void setUp(){
        this.dummy= new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }


    @Test
    public void dummy_loseHealth_onAttack(){
        //A
        Dummy dummy=new Dummy(HEALTH,EXPERIENCE);
        //A
        dummy.takeAttack(ATTACK);
        //A
        assertEquals(HEALTH-ATTACK,dummy.getHealth());
    }
    @Test
    public void aliveDummy_ThrowsWhen_GiveExperience(){
        //A
        Dummy dummy=new Dummy(HEALTH,EXPERIENCE);
        //A
        IllegalStateException e = assertThrows(IllegalStateException.class, dummy::giveExperience);
        //A
        assertEquals("Target is not dead.",e.getMessage());
    }
    @Test
    public void deadDummy_cannot_GiveExperience(){

        assertEquals(EXPERIENCE,deadDummy.giveExperience());
    }
    @Test
    public void deadDummy_Throws_WhenAttacked(){

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> deadDummy.takeAttack(ATTACK));

        assertEquals("Dummy is dead.",e.getMessage());
    }


}