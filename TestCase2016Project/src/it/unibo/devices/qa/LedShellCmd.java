package it.unibo.devices.qa;

import it.unibo.sartiballanti.utils.Utils;

public class LedShellCmd implements ILed{

	private String command;
	private int nPin;	//BCM
	
	public LedShellCmd(String command, int nPin) {
		super();
		this.command = command;
		this.nPin = nPin;
	}

	@Override
	public void turnOn() {
		Utils.executeShellCommand(command+" "+nPin+" "+0);
	}

	@Override
	public void turnOff() {
		Utils.executeShellCommand(command+" "+nPin+" "+1);
	}
	
	
	
}
