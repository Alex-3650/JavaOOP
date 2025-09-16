import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;
    private Boolean AlarmIsOn;

    @BeforeEach
    public void setUp(){
        this.sensor= Mockito.mock(Sensor.class);
       this.alarm=new Alarm(sensor);
       this.AlarmIsOn=true;
    }


    @Test
    public void test_whenTirePressureIsOver21_ThenAlarmIsOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(23.00);
        alarm.check();
        Assertions.assertEquals(AlarmIsOn,alarm.getAlarmOn());
    }

    @Test
    public void test_whenTirePressureIsLess17_ThenAlarmIsOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.00);
        alarm.check();
        Assertions.assertEquals(AlarmIsOn,alarm.getAlarmOn());
    }
    @Test
    public void test_whenTirePressureIsBetween17And21_ThenAlarmIsOff(){
        this.AlarmIsOn=false;
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.00);
        alarm.check();
        Assertions.assertEquals(AlarmIsOn,alarm.getAlarmOn());
    }




}
