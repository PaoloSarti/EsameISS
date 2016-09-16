package it.unibo.sartiballanti.utils;

import java.io.IOException;
import java.io.OutputStream;

public class Utils {
	
	public static long getCurrentTimeMillis(){
		return System.currentTimeMillis();
	}
	
	public static void executeShellCommand(String command){
		try {
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static OutputStream executeShellCommandOutput(String command){
		try {
			Process p = Runtime.getRuntime().exec(command);
			return p.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
