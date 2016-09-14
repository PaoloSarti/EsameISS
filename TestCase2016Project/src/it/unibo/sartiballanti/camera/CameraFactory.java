package it.unibo.sartiballanti.camera;

public class CameraFactory {
	
	private static CameraFactory instance=null;
	
	private String mockFilePath="./img/unattendedBag.jpg";
	
	private CameraFactory(){
	}
	
	public static CameraFactory getInstance(){
		if(instance==null)
			instance = new CameraFactory();
		return instance;
	}
	
	public ICamera getCamera(){
		return new MockFileCamera(mockFilePath);
	}
}
