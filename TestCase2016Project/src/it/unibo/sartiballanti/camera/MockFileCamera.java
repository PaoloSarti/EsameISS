package it.unibo.sartiballanti.camera;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import rx.Single;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
	
	@Override
	public void observableTakePhoto(Action1<? super byte[]> onPhotoTaken) {
		
		Single.<byte[]>create(sub->{
			try {
				sub.onSuccess(Files.readAllBytes(Paths.get(imgPath)));
			} catch (IOException e) {
				sub.onError(e);
			}
		}).subscribeOn(Schedulers.io()).subscribe(onPhotoTaken);
	}
}