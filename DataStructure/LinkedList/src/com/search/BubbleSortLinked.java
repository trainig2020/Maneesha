package com.search;

public class BubbleSortLinked {
	
	static class Node 
	{  
	    int data;  
	    Node prev;  
	    Node next;  
	};  
	  
	// Function to insert a node at the beginning of a linked list  
	static Node insertAtTheBegin( Node start_ref, int data)  
	{  
	    Node ptr1 = new Node();  
	    ptr1.data = data;  
	    ptr1.next = start_ref;  
	    if (start_ref != null)  
	    (start_ref).prev = ptr1;  
	    start_ref = ptr1; 
	    return start_ref; 
	}  
	  
	// Function to print nodes in a given linked list  
	static void printList( Node start)  
	{  
	    Node temp = start;  
	    System.out.println();  
	    while (temp != null)  
	    {  
	        System.out.print( temp.data + " ");  
	        temp = temp.next;  
	    }  
	}  
	  
	// Bubble sort the given linked list  
	static Node bubbleSort( Node start)  
	{  
	    int swapped, i;  
	    Node ptr1;  
	    Node lptr = null;  
	  
	    // Checking for empty list  
	    if (start == null)  
	        return null;  
	  
	    do
	    {  
	        swapped = 0;  
	        ptr1 = start;  
	  
	        while (ptr1.next != lptr)  
	        {  
	            if (ptr1.data > ptr1.next.data)  
	            {  
	                int t = ptr1.data; 
	                ptr1.data = ptr1.next.data; 
	                ptr1.next.data = t; 
	                swapped = 1;  
	            }  
	            ptr1 = ptr1.next;  
	        }  
	        lptr = ptr1;  
	    }  
	    while (swapped != 0);  
	        return start; 
	}  
	  
	// Driver code 
	public static void main(String args[]) 
	{  
	    int arr[] = {90, 1, 11, 2, 56, 12};  
	    int list_size, i;  
	  
	    // start with empty linked list  
	    Node start = null;  
	  
	    // Create linked list from the array arr[].  
	    for (i = 0; i < 6; i++)  
	        start=insertAtTheBegin(start, arr[i]);  
	  
	    // print list before sorting  
	    System.out.printf("\n Linked list before sorting ");  
	    printList(start);  
	  
	    // sort the linked list  
	    start = bubbleSort(start);  
	  
	    // print list after sorting  
	    System.out.printf("\n Linked list after sorting ");  
	    printList(start);  
	}  

}
