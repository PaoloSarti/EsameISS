package it.unibo.devices.qa;

import it.unibo.sartiballanti.utils.Utils;

public class LedShellCmd implements ILed{

	protected String command;
	protected int nPin;	//BCM
	
	public LedShellCmd(String command, int nPin) {
		super();
		this.command = command;
		this.nPin = nPin;
	}

	@Override
	public void turnOn() {
		Utils.executeShellCommand(command+" "+nPin+" "+1);
	}

	@Override
	public void turnOff() {
		Utils.executeShellCommand(command+" "+nPin+" "+0);
	}
	
	
	
}
