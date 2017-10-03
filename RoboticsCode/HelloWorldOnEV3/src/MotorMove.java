import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class MotorMove {

	public static void main(String[] args) {
		//Motors
		RegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor mB = new EV3MediumRegulatedMotor(MotorPort.B);
		mA.synchronizeWith(new RegulatedMotor[] { mB });

		//Top button
		EV3TouchSensor topButton = new EV3TouchSensor(SensorPort.S1);

		//Front button
		EV3TouchSensor frontButton = new EV3TouchSensor(SensorPort.S1);

		//Sensor Setup
		SensorMode touch1 = topButton.getTouchMode();
		SensorMode touch2 = frontButton.getTouchMode();
		float[] sampleTop = new float[touch1.sampleSize()];
		float[] sampleFront = new float[touch2.sampleSize()];

		float speed = 500;


		//Do nothing until button press
		while (sampleTop[0] == 0) { // 0 is unpressed, 1 is pressed
			// mA.forward();
			// touch.fetchSample(sample, 0);
			// // System.out.println(Arrays.toString(sample));
		}
		Delay.msDelay(200);

		//Move 1.5 meters and stop
		float distance = 0;
		float start = System.currentTimeMillis();
		float elapsed = 0;
		while(distance < 150) {
			elapsed = System.currentTimeMillis() - start;
		}

		//Beep

		//Do nothing until button press
		while (sampleTop[0] == 0) { // 0 is unpressed, 1 is pressed
		}
		Delay.msDelay(200);

		//Move until 45cm from wall

		//Beep

		//Do nothing until button press
		while (sampleTop[0] == 0) { // 0 is unpressed, 1 is pressed
		}
		Delay.msDelay(200);

		//Move forward until we hit the wall
		while (sampleFront[0] == 0) { // 0 is unpressed, 1 is pressed
			mA.forward();
			mB.forward();
		}
		Delay.msDelay(200);

		//Backup 45cm

		// mA.setSpeed(720);
		// mB.setSpeed(720);
		// for (int i = 0; i < motorA.length; i++) {
		// mA.startSynchronization();
		// mA.rotateTo(motorA[i]);
		// mB.rotateTo(motorB[i]);
		// mA.endSynchronization();
		// mA.waitComplete();
		// mB.waitComplete();
		//
		// }

	}

}
