package it.unibo.devices.qa;

import com.pi4j.io.gpio.*;

import it.unibo.gpio.base.GpioOnPi4j;

public class Pi4jLed implements ILed{
	
	private GpioController controller;
	private GpioPinDigitalOutput myLed;
	
	public Pi4jLed(int pinNum){
		controller = GpioFactory.getInstance();
		myLed = controller.provisionDigitalOutputPin(GpioOnPi4j.getPin(pinNum));
	}
	
	public void turnOn(){
		myLed.high();
	}
	
	public void turnOff(){
		myLed.low();
	}

}
