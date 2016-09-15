package it.unibo.devices.qa;

import java.util.HashMap;
import java.util.Map;

import it.unibo.gpio.base.GpioOnPi4j;

public class LedDevicesFactory {
	
	private static Map<Integer, ILed> leds;
	
	private static String command="./bash/gpioPin.sh";
	
	
	static {
		leds = new HashMap<>();
		
	}
	
	//BCM!!!
	public static ILed getTheLedCmd(int nPin){
		if(leds.containsKey(nPin)){
			return leds.get(nPin);
		}
		leds.put(nPin, new LedShellCmd(command, nPin));
		return leds.get(nPin);
	}
	
	public static ILed getTheLedPi4j(int nPin){
		if(leds.containsKey(nPin)){
			return leds.get(nPin);
		}
		leds.put(nPin, new Pi4jLed(nPin));
		return leds.get(nPin);
	}
	
}
