package com.principledemo.jansi;

public class LspDemo {

	public static void printInfo(Shape shape) {
		System.out.println("The result is " + shape.getArea());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle square = new Rectangle();
		square.setheight(4);
		square.setwidth(3);
		printInfo(square);

	}

}
