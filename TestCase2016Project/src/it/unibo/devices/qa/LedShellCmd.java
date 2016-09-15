package it.unibo.devices.qa;

import java.io.IOException;

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
		Utils.executeShellCommand(command.replace("X", "On")+" "+nPin);
	}

	@Override
	public void turnOff() {
		Utils.executeShellCommand(command.replace("X", "Off")+" "+nPin);
	}
	
	
	
}
