package it.unibo.sartiballanti.camera;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MockFileCamera implements ICamera {

	private String imgPath;
	
	public MockFileCamera(String imgPath){
		this.imgPath=imgPath;
	}
	
	@Override
	public BufferedImage takePhoto() {
		try {
			return ImageIO.read(new File(imgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
