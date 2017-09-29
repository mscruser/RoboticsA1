import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;

public class MotorMove {

	public static void main(String[] args) {
		RegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor mB = new EV3MediumRegulatedMotor(MotorPort.B);
		EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
		mA.synchronizeWith(new RegulatedMotor[] { mB });
		SensorMode touch = touchSensor.getTouchMode();
		float[] sample = new float[touch.sampleSize()];
		while (sample[0] == 0) { // 0 is unpressed, 1 is pressed
			mA.forward();
			touch.fetchSample(sample, 0);
			// System.out.println(Arrays.toString(sample));
		}

		// int motorA[] = { 0, 360, 720, 1080, 360, 0, 180, 0 };
		// int motorB[] = { 0, 360, 720, 1080, 360, 0, 180, 0 };
		// Delay.msDelay(1000);
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
