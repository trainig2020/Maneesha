package com.linkedlist.service;


public class LoopDetection {
	
	private Node head;

	LoopDetection() {
		head = null;
	}

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

	}

	static boolean detectAndRemoveLoopInDLL(Node head){
	    Node last = null;
	    while(head != null){
	        if(last != null && last != head.prev){
	        	
	        	System.out.println("Loop found at :  " +head.data);
	           
	            last.next = null;
	            return true;
	        }
	        last = head;
	        head = head.next;
	    }
	    System.out.println("No loop found");
	    return false;
	}

	public static void main(String[] args) {
		
		Node head = new Node(3);
		head.next = new Node(4);
		head.next.next = new Node(3);
		head.next.next.next = new Node(8);
	  //  head.next = new Node(2);
	    //head.next.next = new Node(3); head.next.prev=head;
	   // head.next.next.next = new Node(4); head.next.next.prev = head.next;
	  //  head.next.next.next.next = new Node(5); head.next.next.next.prev = head.next.next;
	  //  head.next.next.next.next.next = new Node(6); head.next.next.next.next.prev = head.next.next.next;
	   // head.next.next.next.next.next.next  = new Node(7); head.next.next.next.next.next.prev = head.next.next.next.next;
	   // head.next.next.next.next.next.next.next = new Node(8); head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
	    //comment this for no loop
	  //  head->next->next->next->next->next->next->next->next = head->next->next;
	  //  head->next->next->next->next->next->next->next->prev = head->next->next->next->next->next->next;
	    detectAndRemoveLoopInDLL(head);
	   
	}
	
	
	
	
	
	
}	


