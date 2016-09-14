package it.unibo.sartiballanti.camera;

import rx.functions.Action1;

public interface ICamera {
	public byte[] takePhoto();
	/**
	 * Non-blocking operation that calls the lambda passed as a parameter with the byte array of the photo as the argument
	 */
	public void observableTakePhoto(Action1<? super byte[]> onPhotoTaken);
}