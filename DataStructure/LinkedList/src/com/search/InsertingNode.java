package com.search;

import java.util.Scanner;


public class InsertingNode {
	

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

 public static void main(String[] args) {
	 
	 InsertingNode sList = new InsertingNode();

		@SuppressWarnings("resource")
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

	 
 }

}
