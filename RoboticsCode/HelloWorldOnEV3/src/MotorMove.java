import lejos.hardware.Button;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;

public class MotorMove {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Motors
		
		EV3MediumRegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
		EV3MediumRegulatedMotor mB = new EV3MediumRegulatedMotor(MotorPort.B);
		
		EV3UltrasonicSensor ultra = new EV3UltrasonicSensor(SensorPort.S2);
		SensorMode distance = ultra.getMode("Distance");		
		float[] sample = new float[distance.sampleSize()];
		
		//Front button
		EV3TouchSensor frontButton = new EV3TouchSensor(SensorPort.S3);

		//Sensor Setup
		SensorMode touch2 = frontButton.getTouchMode();
		float[] sampleFront = new float[touch2.sampleSize()];

		int speed = 90;


		//Do nothing until button press
		Button.ENTER.waitForPress();
		Thread.sleep(200);

		//Move 1.5 meters and stop
//		float distance = 0;
//		float start = System.currentTimeMillis();
//		float elapsed = 0;
//		elapsed = System.currentTimeMillis() - start;
		mA.setSpeed(speed);
		mB.setSpeed(speed);
		mA.forward();
		mB.forward();
		Thread.sleep(25063);
		mA.stop();
		mB.stop();

		//Beep
		lejos.hardware.Sound.beep();

		//Do nothing until button press
		Button.ENTER.waitForPress();
		Thread.sleep(200);

		//Move until 45cm from wall
		while ( sample[0] < 45) { // 0 is unpressed, 1 is pressed
			distance.fetchSample(sample, 0);
		}
		Thread.sleep(200);
		
		//Beep
		lejos.hardware.Sound.beep();

		//Do nothing until button press
		Button.ENTER.waitForPress();
		Thread.sleep(200);

		//Move forward until we hit the wall
		while (sampleFront[0] == 0) { // 0 is unpressed, 1 is pressed
			distance.fetchSample(sample, 0);
			mA.setSpeed(speed);
			mB.setSpeed(speed);
			mA.forward();
			mB.forward();
		}
		mA.stop();
		mB.stop();

		//Backup 45cm
		mA.setSpeed(-1*speed);
		mB.setSpeed(-1*speed);
		mA.forward();
		mB.forward();
		Thread.sleep(19098);
		mA.stop();
		mB.stop();
		
		frontButton.close();
		mA.close();
		mB.close();
		ultra.close();

	}

}
