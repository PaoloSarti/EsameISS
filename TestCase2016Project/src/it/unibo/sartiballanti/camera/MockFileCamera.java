package it.unibo.sartiballanti.camera;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

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
