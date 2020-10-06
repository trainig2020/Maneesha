package com.list.service;

// Java program to delete node at different 
// Positions from a circular linked list 
import java.util.*;

class DeleteList {

	// structure for a node
	static class Node {
		int data;
		Node next;
	};

	// Function to insert a node at the end of
	// a Circular linked list
	@SuppressWarnings("unused")
	static Node Insert(Node head, int data) {
		Node current = head;

		// Create a new node
		Node newNode = new Node();

		// check node is created or not
		if (newNode == null) {
			System.out.printf("\nMemory Error\n");
			return null;
		}

		// insert data into newly created node
		newNode.data = data;

		// check list is empty
		// if not have any node then
		// make first node it
		if (head == null) {
			newNode.next = newNode;
			head = newNode;
			return head;
		}

		// if list have already some node
		else {

			// move first node to last node
			while (current.next != head) {
				current = current.next;
			}

			// put first or head node address
			// in new node link
			newNode.next = head;

			// put new node address into last
			// node link(next)
			current.next = newNode;
		}
		return head;
	}

	// Function print data of list
	static void Display(Node head) {
		Node current = head;

		// if list is empty, simply show message
		if (head == null) {
			System.out.printf("\nDisplay List is empty\n");
			return;
		}

		// traverse first to last node
		else {
			do {
				System.out.printf("%d ", current.data);
				current = current.next;
			} while (current != head);
		}
	}

	// Function return number of nodes present in list
	static int Length(Node head) {
		Node current = head;
		int count = 0;

		// if list is empty
		// simply return length zero
		if (head == null) {
			return 0;
		}

		// traverse forst to last node
		else {
			do {
				current = current.next;
				count++;
			} while (current != head);
		}
		return count;
	}

	// Function delete First node of
	// Circular Linked List
	static Node DeleteFirst(Node head) {
		Node previous = head, next = head;

		// check list have any node
		// if not then return
		if (head == null) {
			System.out.printf("\nList is empty\n");
			return null;
		}

		// check list have single node
		// if yes then delete it and return
		if (previous.next == previous) {
			head = null;
			return null;
		}

		// traverse second to first
		while (previous.next != head) {
			previous = previous.next;
			next = previous.next;
		}

		// now previous is last node and
		// next is first node of list
		// first node(next) link address
		// put in last node(previous) link
		previous.next = next.next;

		// make second node as head node
		head = previous.next;

		return head;
	}

	// Function to delete last node of
	// Circular Linked List
	static Node DeleteLast(Node head) {
		@SuppressWarnings("unused")
		Node current = head, temp = head, previous = null;

		// check if list doesn't have any node
		// if not then return
		if (head == null) {
			System.out.printf("\nList is empty\n");
			return null;
		}

		// check if list have single node
		// if yes then delete it and return
		if (current.next == current) {
			head = null;
			return null;
		}

		// move first node to last
		// previous
		while (current.next != head) {
			previous = current;
			current = current.next;
		}

		previous.next = current.next;
		head = previous.next;

		return head;
	}

	// Function delete node at a given poisition
	// of Circular Linked List
	static Node DeleteAtPosition(Node head, int index) {
		// Find length of list
		int len = Length(head);
		int count = 1;
		Node previous = head, next = head;

		// check list have any node
		// if not then return
		if (head == null) {
			System.out.printf("\nDelete Last List is empty\n");
			return null;
		}

		// given index is in list or not
		if (index >= len || index < 0) {
			System.out.printf("\nIndex is not Found\n");
			return null;
		}

		// delete first node
		if (index == 0) {
			head = DeleteFirst(head);
			return head;
		}

		// traverse first to last node
		while (len > 0) {

			// if index found delete that node
			if (index == count) {
				previous.next = next.next;

				return head;
			}
			previous = previous.next;
			next = previous.next;
			len--;
			count++;
		}
		return head;
	}

	// Driver Code
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Node head = null;

		Scanner input = new Scanner(System.in);

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo Add element.\n2\tTo Display element.\n3\tTo Delete Node at Specific Position.\n4\tTo Delete First Node.\n5\tTo Delete Last Node.\n6\tTo Exit From Program.\nEnter your option:- ");
			select = input.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				int ele = input.nextInt();
				head = Insert(head, ele);
				break;
			}
			case 2: {
				Display(head);
				break;
			}
			case 3: {
				int ele = input.nextInt();
				head = DeleteAtPosition(head, ele);
				break;
			}
			case 4: {

				head = DeleteFirst(head);
				break;
			}
			case 5: {

				head = DeleteLast(head);
				break;
			}

			case 6: {
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
