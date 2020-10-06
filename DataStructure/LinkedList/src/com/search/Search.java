package com.search;

import java.util.Scanner;

public class Search {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void searchNode(int data) {
		Node current = head;
		int i = 1;
		boolean flag = false;
		if (head == null) {
			System.out.println("List is empty");
		} else {
			while (current != null) {
				if (current.data == data) {
					flag = true;
					break;
				}
				i++;
				current = current.next;
			}
		}
		if (flag)
			System.out.println("Element is present in the list at the position : " + i);
		else
			System.out.println("Element is not present in the list");
	}

	public void removeDuplicate() {

		Node current = head, index = null, temp = null;

		if (head == null) {
			return;
		} else {
			while (current != null) {

				temp = current;

				index = current.next;

				while (index != null) {

					if (current.data == index.data) {

						temp.next = index.next;
					} else {

						temp = index;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	public void display() {

		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		while (current != null) {

			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Search sList = new Search();

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number- ");
		int a = sc.nextInt();
		System.out.print("Enter Second number- ");
		int b = sc.nextInt();
		System.out.print("Enter Third number- ");
		int c = sc.nextInt();
		System.out.print("Enter Fourth number- ");
		int d = sc.nextInt();
		System.out.print("Enter Fifth number- ");
		int g = sc.nextInt();
		System.out.print("Enter Sixth number- ");
		int h = sc.nextInt();
		System.out.print("Enter Seventh number- ");
		int i = sc.nextInt();

		sList.addNode(a);
		sList.addNode(b);
		sList.addNode(c);
		sList.addNode(d);
		sList.addNode(g);
		sList.addNode(h);
		sList.addNode(i);

		System.out.println("Originals list: ");
		sList.display();

		sList.removeDuplicate();
		System.out.println("List after removing duplicates: ");
		sList.display();

		Scanner find = new Scanner(System.in);
		System.out.print("Enter the number to be searched in list - ");
		int e = find.nextInt();
		sList.searchNode(e);
		System.out.print("Enter the number to be searched in list - ");
		int f = find.nextInt();
		sList.searchNode(f);
		System.out.print("Enter the number to be searched in list - ");
		int j = find.nextInt();
		sList.searchNode(j);

	}

}
