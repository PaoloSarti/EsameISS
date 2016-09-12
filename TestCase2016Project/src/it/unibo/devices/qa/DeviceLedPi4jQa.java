package it.unibo.devices.qa;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import it.unibo.bls.highLevel.interfaces.IDevLed.LedColor;
import it.unibo.bls.raspberry.components.DeviceLedPi4j;
import it.unibo.buttonLed.components.DeviceLedImpl;
import it.unibo.is.interfaces.IOutputEnvView;
/*
 * =======================================================================
 * The led is implemented as an observable by using the library pi4j
 * =======================================================================
 */
public class DeviceLedPi4jQa { 
private static 	DeviceLedPi4j myself = null;
protected GpioPinDigitalOutput ledpi4j; 

    public static DeviceLedImpl createLed( String name, IOutputEnvView outEnvView, int color, int pinNum){
  		try {
   			if( myself == null ){
   				LedColor ledcolor = (color == 0) ? LedColor.GREEN : LedColor.RED ;
 	  			myself = new DeviceLedPi4j( name,outEnvView, ledcolor, pinNum);  			 
  			}
  			return myself;
		} catch (Exception e) {
  			e.printStackTrace();
 			return null;
		}
  	}
    public static DeviceLedImpl getTheLed( ){
    	return myself;
    }
}