package it.unibo.devices.qa;

import java.util.HashMap;
import java.util.Map;

/**
 * BCM convention!!
 */
public class LedDevicesFactory {
	
	private static Map<Integer, ILed> leds;
	
	private static String command="sudo bash/gpioPin.sh";
	private static String commandInterpreter="sudo bash/gpioPinInterpreter.sh";
	
	static {
		leds = new HashMap<>();
	}
	
	public static ILed getTheLedCmd(int nPin){
		if(leds.containsKey(nPin)&&leds.get(nPin) instanceof LedShellCmd){
			return leds.get(nPin);
		}
		leds.put(nPin, new LedShellCmd(command, nPin));
		return leds.get(nPin);
	}
	
	public static ILed getTheLedCmdInterpreter(int nPin){
		if(leds.containsKey(nPin)&&leds.get(nPin) instanceof LedShellCmdInterpreter){
			return leds.get(nPin);
		}
		leds.put(nPin, new LedShellCmdInterpreter(commandInterpreter, nPin));
		return leds.get(nPin);
	}
	
	public static ILed getTheLedPi4j(int nPin){
		if(leds.containsKey(nPin)&&leds.get(nPin) instanceof Pi4jLed){
			return leds.get(nPin);
		}
		leds.put(nPin, new Pi4jLed(nPin));
		return leds.get(nPin);
	}
	
}
