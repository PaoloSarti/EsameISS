/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.operator;
import java.awt.Button;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alice.tuprolog.Term;
import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.ActorContext;

public class Operator extends AbstractOperator {
	
	protected Map<String, String> driveCmdMap;
	
	protected List<String> driveCmdsSorted;
	
	public Operator(String actorId, ActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);		

	}
	
	protected void initCmdMap(){
		driveCmdMap=new HashMap<>();
		driveCmdMap.put("Forward", "executeInput(move(mf,100,0))");
		driveCmdMap.put("Backward", "executeInput(move(mb,100,0))");
		driveCmdMap.put("Right", "executeInput(move(mr,100,0))");
		driveCmdMap.put("Left", "executeInput(move(ml,100,0))");
		driveCmdMap.put("Halt", "executeInput(move(h,100,0))");
		driveCmdsSorted=new ArrayList<>();
		driveCmdsSorted.add("Forward");
		driveCmdsSorted.add("Backward");
		driveCmdsSorted.add("Left");
		driveCmdsSorted.add("Right");
		driveCmdsSorted.add("Halt");
	}
	
	@Override
	protected void addCmdPanels(){
		super.addCmdPanels();
		initCmdMap();
		EnvFrame frame = (EnvFrame) env;
		frame.setLayout(new FlowLayout());
		frame.setSize(800, 450);
		
		driveCmdsSorted.forEach(cmd->{
			Button button = new Button(cmd);
			button.addActionListener(e->{
				this.execAction(((Button)e.getSource()).getLabel());
			});
			
			frame.add(button);
			
			//((EnvFrame) env).addCmdPanel(key,  new String[]{key}, this);
		});
		frame.validate();
	}
	
	@Override
	public void execAction(String cmd) {
		super.execAction(cmd);
		
		if(driveCmdMap.containsKey(cmd)){
			String actualCmd = driveCmdMap.get(cmd);
			platform.raiseEvent("input", "local_inputDrive", "local_inputDrive("+actualCmd+")");
			return;
		}
	}
	
}
