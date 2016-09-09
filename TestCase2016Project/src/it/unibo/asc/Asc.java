/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.asc;
import java.awt.Button;
import java.awt.FlowLayout;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.ActorContext;

public class Asc extends AbstractAsc { 
	public Asc(String actorId, ActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	
	@Override
	protected void addCmdPanels(){
		super.addCmdPanels();
		
		((EnvFrame) env).addCmdPanel("Alarm", new String[]{"Alarm"}, this);
	}
	
	@Override
	public void execAction(String cmd) {
		super.execAction(cmd);
		if( cmd.equals("Alarm") ){
			platform.raiseEvent("input", "local_alarm", "local_alarm");
			return;
		}
	}
}