package com.list.service;

import java.util.Scanner;

public class CircularLinkedList {
	// Represents the node of list.
	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// Declaring head and tail pointer as null.
	public Node head = null;
	public Node tail = null;

	// This function will add the new node at the end of the list.
	public void add(int data) {
		// Create new node
		Node newNode = new Node(data);
		// Checks if the list is empty.
		if (head == null) {
			// If list is empty, both head and tail would point to new node.
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {
			// tail will point to new node.
			tail.next = newNode;
			// New node will become new tail.
			tail = newNode;
			// Since, it is circular linked list tail will point to head.
			tail.next = head;
		}
	}

	// Displays all the nodes in the list
	public void display() {
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
		} else {
			System.out.println("Nodes of the circular linked list: ");
			do {
				// Prints each node by incrementing pointer.
				System.out.print(" " + current.data);
				current = current.next;
			} while (current != head);
			System.out.println();
		}
	}

	public void deleteNode(int valueToDelete) {
		Node currentNode = head;

		if (head != null) {
			if (currentNode.data == valueToDelete) {
				head = head.next;
				tail.next = head;
			} else {
				do {
					Node nextNode = currentNode.next;
					if (nextNode.data == valueToDelete) {
						currentNode.next = nextNode.next;
						break;
					}
					currentNode = currentNode.next;
				} while (currentNode != head);
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();
		Scanner input = new Scanner(System.in);

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo Add element.\n2\tTo Display element.\n3\tTo Delete the Node.\n4\tTo Exit the Program.\nEnter your option:- ");
			select = input.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				int ele = input.nextInt();
				cl.add(ele);
				break;
			}
			case 2: {
				cl.display();
				break;
			}
			case 3: {
				int ele = input.nextInt();
				cl.deleteNode(ele);
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
