package com.principledemo.jansi;

public class FileWriter implements IWriter{

	@Override
	public void saveTo(String filename) {
		System.out.println("Save this file to file on disk");
		
	}

}
