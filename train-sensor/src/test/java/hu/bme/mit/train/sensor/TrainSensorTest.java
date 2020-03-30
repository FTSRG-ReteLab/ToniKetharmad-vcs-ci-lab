package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void override_BetweenAbs_Success() {
        trainSensor.overrideSpeedLimit(6);
        verify(mockTU, times(1)).setAlarmState(false);
    }

    @Test
    public void override_LessThanAbs_Fail() {
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void override_MoreThanAbs_Fail() {
        trainSensor.overrideSpeedLimit(1000);
        verify(mockTU, times(1)).setAlarmState(true);
    }

    @Test
    public void override_RelMargin_Success() {
        trainSensor.overrideSpeedLimit(3);
        verify(mockTU, times(1)).setAlarmState(false);
    }

    @Test
    public void override_RelMargin_Fail() {
        trainSensor.overrideSpeedLimit(1);
        verify(mockTU, times(1)).setAlarmState(true);
    }
}
