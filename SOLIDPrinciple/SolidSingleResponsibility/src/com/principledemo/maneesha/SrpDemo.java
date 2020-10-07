package com.principledemo.jansi;

public class SrpDemo {

	public static void main(String[] args) {
		
		Media media = new VideoMedia();
		media.setName("Solid Principle");
		media.setDuration("30");
		media.writeTo(new GoogleDriveWriter());
        media.printInfo();
	}

}
