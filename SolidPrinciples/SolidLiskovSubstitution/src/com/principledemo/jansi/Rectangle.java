package com.principledemo.jansi;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public int getwidth() {
		return width;
	}

	public void setwidth(int width) {
		this.width = width;
	}

	public int getheight() {
		return height;
	}

	public void setheight(int height) {
		this.height = height;
	}

	@Override
	int getArea() {
		
		return width*height;
	}

}
