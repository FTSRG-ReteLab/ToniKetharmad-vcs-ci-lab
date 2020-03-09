package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.tachograph.TrainTachograph;

public class TrainTachographTest {

	TrainTachograph tach;
	
	@Before
	public void before() {
		tach = new TrainTachograph();
	}

	@Test
	public void EmptyTest() {
		tach.meassure();
		Assert.assertEquals(false, tach.isEmpty());
	}
}
