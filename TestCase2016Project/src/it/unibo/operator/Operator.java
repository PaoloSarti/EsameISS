/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.operator;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.ActorContext;

public class Operator extends AbstractOperator {
	
	protected Map<String, String> driveCmdMap;
	
	public final static String Forward="Forward";
	public final static String Backward="Backward";
	public final static String Right="Right";
	public final static String Left="left";
	public final static String Halt="Halt";
	
	public Operator(String actorId, ActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	protected void initCmdMap(){
		driveCmdMap=new HashMap<>();
		driveCmdMap.put(Forward, "executeInput(move(mf,100,0))");
		driveCmdMap.put(Backward, "executeInput(move(mb,100,0))");
		driveCmdMap.put(Right, "executeInput(move(mr,100,0))");
		driveCmdMap.put(Left, "executeInput(move(ml,100,0))");
		driveCmdMap.put(Halt, "executeInput(move(h,100,0))");
	}
	
	@Override
	protected void addInputPanel(int size) {
	}
	
	@Override
	protected void addCmdPanels(){
		initCmdMap();
		((EnvFrame) env).setSize(800,700);
		Panel p = new Panel();
		GridLayout l =  new GridLayout();
		l.setVgap(10);
		l.setHgap(10);
		l.setColumns(3);
		l.setRows(3);
		p.setLayout(l);
		
		MouseListener ml =new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				execAction(Halt);
				System.out.println("DEBUG: UNPRESSED");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button b = (Button)e.getSource();
				execAction(b.getLabel());
				System.out.println("DEBUG: PRESSED" +  b.getLabel());
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}	
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		
		Button forward = new Button(Forward);
		forward.addMouseListener(ml);
		Button backward = new Button(Backward);
		backward.addMouseListener(ml);
		Button right = new Button(Right);
		right.addMouseListener(ml);
		Button left = new Button(Left);
		left.addMouseListener(ml);
		Button halt = new Button(Halt);
		halt.addMouseListener(ml);
		p.add(new Label(""));
		p.add(forward);
		p.add(new Label(""));
		p.add(left);
		p.add(halt);
		p.add(right);
		p.add(new Label(""));
		p.add(backward);
		p.add(new Label(""));
		((EnvFrame) env).add(p);
		((EnvFrame) env).validate();
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