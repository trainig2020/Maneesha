package com.search;

public class ReferenceList {
	
	class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public ListNode head = null;
	public ListNode tail = null;

	public ListNode findReference(ListNode head, ListNode node) {
		ListNode current = head;
		if (node == head) {
			
			System.out.println("The reference for head node is " );
		}
		while (current.next != null) {

			if (current.next == node) {
				
				System.out.println("Reference of given node is : "
						+ current.data);
				return current;
			} else {
				current = current.next;
			}
		}

		return null;

	}
	

	public static void main(String[] args) {
		ReferenceList rList = new ReferenceList();

		ListNode head = rList.new ListNode(12);
		ListNode second = rList.new ListNode(9);
		ListNode third = rList.new ListNode(4);
		ListNode fourth = rList.new ListNode(6);

		head.next = second;
		second.next = third;
		third.next = fourth;

		rList.findReference(head, fourth);

	}

}
