package model;

import java.util.Random;

public class PinGenerator {

	private int pin = -1;

	public PinGenerator() {

	}

	public int generatePin() {
		System.out.println("PinGenerator; generating pin");
		Random r = new Random();
		this.pin = r.nextInt(99999 - 10000) + 10000;
		System.out.println("PinGenerator; pin generated: " + pin);
		return pin;
	}
}
