package com.principledemo.jansi;

public class AudioMedia extends Media{

	@Override
	void printInfo() {
		System.out.println("This is a Audio.Its name is  "+getName() + " and its duration is "+getDuration());
		
	}

}
