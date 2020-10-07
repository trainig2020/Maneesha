package com.principledemo.jansi;

public class Square extends Shape {

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	int getArea() {

		return size * size;
	}

}
