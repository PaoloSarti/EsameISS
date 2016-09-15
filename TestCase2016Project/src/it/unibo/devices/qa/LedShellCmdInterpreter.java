package it.unibo.devices.qa;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

import it.unibo.sartiballanti.utils.Utils;

public class LedShellCmdInterpreter extends LedShellCmd {

	private PrintWriter pw;
	
	public LedShellCmdInterpreter(String command, int nPin) {
		super(command,nPin);
		this.pw=new PrintWriter(Utils.executeShellCommandOutput(command +" "+ nPin));
	}
	
	@Override
	public void turnOn() {
		pw.println("1");
	}

	@Override
	public void turnOff() {
		pw.println("0");
	}
	
	public void turnOffForever(){
		turnOff();
		pw.close();
	}
	
}
