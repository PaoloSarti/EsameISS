package it.unibo.devices.qa;

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
		pw.print("1\n");
		pw.flush();
	}

	@Override
	public void turnOff() {
		pw.print("0\n");
		pw.flush();
	}
	
	public void turnOffForever(){
		turnOff();
		pw.close();
	}
	
}
