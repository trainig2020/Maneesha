package com.search;

import java.util.Scanner;

public class Reverse {

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}

		public int data() {
			return data;
		}

		public Node next() {
			return next;
		}
	}

	private Node head;

	public Reverse(Node head) {
		this.head = head;
	}

	public void add(Node node) {
		Node current = head;
		while (current != null) {
			if (current.next == null) {
				current.next = node;
				break;
			}
			current = current.next;
		}
	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data() + " ");
			node = node.next();
		}
		System.out.println("");
	}

	public void reverseElement() {
		Node pointer = head;
		Node previous = null, current = null;
		while (pointer != null) {
			current = pointer;
			pointer = pointer.next;
			current.next = previous;
			previous = current;
			head = current;

		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		// creating a singly linked list

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number- ");
		int a = sc.nextInt();
		
		Reverse.Node head = new Reverse.Node(a);
		Reverse linkedlist = new Reverse(head);
		
		
		System.out.print("Enter Second number- ");
		int b = sc.nextInt();
		

		System.out.print("Enter Third number- ");
		int c = sc.nextInt();
		System.out.print("Enter Third number- ");
		int d = sc.nextInt();
		System.out.print("Enter Third number- ");
		int e = sc.nextInt();

		// adding node into singly linked list
		linkedlist.add(new Reverse.Node(b));
		linkedlist.add(new Reverse.Node(c));
		linkedlist.add(new Reverse.Node(d));
		linkedlist.add(new Reverse.Node(e));

		// printing a singly linked list
		System.out.println("Singly Linked List Inserting order :");
		linkedlist.print();

		// reversing the singly linked list
		linkedlist.reverseElement();

		// printing the singly linked list again
		System.out.println("Singly Linked List Reverse order :");
		linkedlist.print();
	}
}
