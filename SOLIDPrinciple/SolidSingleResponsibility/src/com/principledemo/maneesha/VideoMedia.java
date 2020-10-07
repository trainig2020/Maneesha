package com.principledemo.jansi;

public class VideoMedia extends Media{

	@Override
	void printInfo() {
		System.out.println("This is a Video.Its name is  "+getName() + " and its duration is "+getDuration());
		
	}

}
