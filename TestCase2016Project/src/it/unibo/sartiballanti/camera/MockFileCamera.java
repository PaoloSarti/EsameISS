package it.unibo.sartiballanti.camera;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MockFileCamera implements ICamera {

	private String imgPath;
	
	public MockFileCamera(String imgPath){
		this.imgPath=imgPath;
	}
	
	@Override
	public byte[] takePhoto() {
		try {
			return Files.readAllBytes(Paths.get(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
