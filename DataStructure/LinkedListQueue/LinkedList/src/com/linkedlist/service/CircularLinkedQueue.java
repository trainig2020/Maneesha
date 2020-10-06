package com.linkedlist.service;

import java.util.Scanner;

public class CircularLinkedQueue {

	// Structure of a Node
	static class Node {
		int data;
		Node link;
	}

	static class Queue {
		Node front, rear;
	}

	// Function to create Circular queue
	static void enQueue(Queue q, int value) {
		Node temp = new Node();
		temp.data = value;
		if (q.front == null)
			q.front = temp;
		else
			q.rear.link = temp;

		q.rear = temp;
		q.rear.link = q.front;
	}

	// Function to delete element from Circular Queue
	static int deQueue(Queue q) {
		if (q.front == null) {
			System.out.printf("Queue is empty");
			return Integer.MIN_VALUE;
		}

		// If this is the last node to be deleted
		int value; // Value to be dequeued
		if (q.front == q.rear) {
			value = q.front.data;
			q.front = null;
			q.rear = null;
		} else // There are more than one nodes
		{
			Node temp = q.front;
			value = temp.data;
			q.front = q.front.link;
			q.rear.link = q.front;
		}

		return value;
	}

	// Function displaying the elements of Circular Queue
	static void displayQueue(Queue q) {
		Node temp = q.front;
		System.out.printf("\nElements in Circular Queue are: ");
		while (temp.link != q.front) {
			System.out.printf("%d ", temp.data);
			temp = temp.link;
		}
		System.out.printf("%d", temp.data);
	}

	/* Driver of the program */
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		// Create a queue and initialize front and rear
		Queue q = new Queue();
		q.front = q.rear = null;
		Scanner input = new Scanner(System.in);
		int term = 0;
		int select;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Display the Queue elements.\n4\tTo Exit the Program.\nEnter your option:- ");
			select = input.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				int ele = input.nextInt();
				enQueue(q, ele);
				break;
			}
			case 2: {
				deQueue(q);
				break;
			}
			case 3: {
				displayQueue(q);
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
