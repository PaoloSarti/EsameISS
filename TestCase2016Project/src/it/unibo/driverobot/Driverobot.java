/* Generated by AN DISI Unibo */ 
package it.unibo.driverobot;
import java.util.Base64;


import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.ActorContext;
import it.unibo.sartiballanti.camera.CameraFactory;
public class Driverobot extends AbstractDriverobot { 
	public Driverobot(String actorId, ActorContext myCtx, IOutputEnvView outEnvView ,it.unibo.iot.executors.baseRobot.IBaseRobot baserobot) throws Exception{
		super(actorId,myCtx,outEnvView ,baserobot );
	}
	
	public String takeStringifiedPhoto(){
		byte[] img= CameraFactory.getInstance().getCamera().takePhoto();
		
		return Base64.getEncoder().encodeToString(img);
	}
	
}
