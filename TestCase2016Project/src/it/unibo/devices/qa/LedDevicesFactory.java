package it.unibo.devices.qa;

import java.util.HashMap;
import java.util.Map;

public class LedDevicesFactory {
	
	private static Map<Integer, ILed> leds;
	
	private static String command="sudo bash/gpioPin.sh";
	private static String commandInterpreter="sudo bash/gpioPinInterpreter.sh";
	
	static {
		leds = new HashMap<>();
	}
	
	/**
	 * @param nPin BCM convention!!!
	 * @return
	 */
	public static ILed getTheLedCmd(int nPin){
		if(leds.containsKey(nPin)){
			return leds.get(nPin);
		}
		leds.put(nPin, new LedShellCmd(command, nPin));
		return leds.get(nPin);
	}
	
	public static ILed getTheLedCmdInterpreter(int nPin){
		if(leds.containsKey(nPin)){
			return leds.get(nPin);
		}
		leds.put(nPin, new LedShellCmdInterpreter(command, nPin));
		return leds.get(nPin);
	}
	
	/**
	 * @param nPin BCM convention!!!
	 * @return
	 */
	public static ILed getTheLedPi4j(int nPin){
		if(leds.containsKey(nPin)){
			return leds.get(nPin);
		}
		leds.put(nPin, new Pi4jLed(nPin));
		return leds.get(nPin);
	}
	
}
