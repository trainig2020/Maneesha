package com.principledemo.jansi;

public class GoogleDriveWriter implements IWriter {

	@Override
	public void saveTo(String filename) {
		System.out.println("Save this file to Google Drive");
		
	}

}
