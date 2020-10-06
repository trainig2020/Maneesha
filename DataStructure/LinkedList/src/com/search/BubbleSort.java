package com.search;

public class BubbleSort {

	private static void bSort(int[] a) {
		int size = a.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 10, 15, 9, 20, 7, 3, 18 };
		bSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
