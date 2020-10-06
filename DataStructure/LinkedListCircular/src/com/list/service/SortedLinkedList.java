package com.list.service;

import java.util.Scanner;

public class SortedLinkedList {

	// reference to first node
	private Node head;

	SortedLinkedList() {
		head = null;
	}

	// Class for nodes
	static class Node {
		// data
		int i;
		Node next;

		Node(int i) {
			this.i = i;
			this.next = null;
		}

		public void displayData() {
			System.out.print(i + " ");
		}
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		Node current = head;
		Node previous = null;
		while (current != null && data > current.i) {
			previous = current;
			current = current.next;
		}
		// insertion at beginning of the list
		if (previous == null) {
			head = newNode;
		} else {
			previous.next = newNode;
		}
		newNode.next = current;
	}

	public Node remove() {
		if (head == null) {
			throw new RuntimeException("List is empty..");
		}
		Node temp = head;
		head = head.next;
		return temp;
	}

	// Method to traverse and display all nodes
	public void displayList() {
		Node current = head;
		while (current != null) {
			current.displayData();
			current = current.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		SortedLinkedList list = new SortedLinkedList();

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo Add element.\n2\tTo Display element.\n3\tTo Remove Node.\n4\tTo Exit From Program.\nEnter your option:- ");
			select = input.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				int ele = input.nextInt();
				list.insert(ele);
				break;
			}
			case 2: {
				list.displayList();
				break;
			}
			case 3: {
				@SuppressWarnings("unused")
				Node node = list.remove();
				break;
			}
			case 4: {
				term = 1;
				System.out.println("Thank you!");
				break;
			}
			default:
				System.out.println("Enter a valid options");
			}
		}
	}

}
