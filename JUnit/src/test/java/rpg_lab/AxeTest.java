package rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static rpg_lab.Axe.DAMAGE_POINTS;

public class AxeTest {
    private static final Dummy DUMMY = Mockito.mock(Dummy.class);

    private static final int ATTACK=10;
    private static final int DURABILITY=50;

    @Test
    public void  axe_losesDurability_afterEvery_attack(){
        //A
        Axe axe=new Axe(ATTACK,DURABILITY);


        //A
        axe.attack(DUMMY);
        //A


        assertEquals( DURABILITY-DAMAGE_POINTS, axe.getDurabilityPoints());
    }

    @Test
    public void axe_Attack_WhenBroken_Throws(){
        Axe brokenAxe=new Axe(5,0);


        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> brokenAxe.attack(DUMMY));
        assertEquals("Axe is broken.",illegalStateException.getMessage());


    }

    @Disabled
    @Test
    public void mockito_Demo(){
        Dummy dummy = Mockito.mock(Dummy.class);
         when(DUMMY.giveExperience()).thenReturn(12);
         when(DUMMY.isDead()).thenReturn(true);

    }
}
