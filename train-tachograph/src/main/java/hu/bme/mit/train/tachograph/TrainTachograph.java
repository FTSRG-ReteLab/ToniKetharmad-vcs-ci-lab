package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainTachograph {

	private Table<String, String, Integer> table;

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public void meassure() {
		List<String> rows = Lists.newArrayList("1", "2");
		List<String> columns = Lists.newArrayList("Time", "Joystick", "Speed");
		table = ArrayTable.create(rows, columns);

		table.put("1", "Time", 6);
		table.put("1", "Joystick", 5);
		table.put("1", "Speed", 4);
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

}
