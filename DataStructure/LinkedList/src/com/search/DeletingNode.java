package com.search;

import java.util.Scanner;

public class DeletingNode {
	

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
	

	
	 void deleteNode(int position) 
	    { 
	        // If linked list is empty 
	        if (head == null) 
	            return; 
	  
	        // Store head node 
	        Node temp = head; 
	  
	        // If head needs to be removed 
	        if (position == 0) 
	        { 
	            head = temp.next;   // Change head 
	            return; 
	        } 
	  
	        // Find previous node of the node to be deleted 
	        for (int i=0; temp!=null && i<position-1; i++) 
	            temp = temp.next; 
	  
	        // If position is more than number of nodes 
	        if (temp == null || temp.next == null) 
	            return; 
	  
	        // Node temp->next is the node to be deleted 
	        // Store pointer to the next of node to be deleted 
	        Node next = temp.next.next; 
	  
	        temp.next = next;  // Unlink the deleted node from list 
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
		 
		 DeletingNode sList = new DeletingNode();

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
			
			System.out.println("Enter the element to be deleted: ");
			int x = sc.nextInt();
			sList.deleteNode(x);
			
			System.out.print("After element deleted list- ");
			sList.display();

		 
	 }

}
