package com.linkedlist.service;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Deque deque = new LinkedList();

		// We can add elements to the queue in various ways

		deque.add("Element 1 (Tail)");
		// add to tail
		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)");
		deque.push("Element 4 (Head)"); // add to head
		deque.offer("Element 5 (Tail)");
		deque.offerFirst("Element 6 (Head)");
		deque.offerLast("Element 7 (Tail)");

		System.out.println("Deque elements: ");
		System.out.println(deque);
		System.out.println("*********************************************");
		// Iterate through the queue elements.
		System.out.println("Iterating over Deque with Standard Iterator");
		Iterator iterator = deque.iterator();
		while (iterator.hasNext()) {
			System.out.println("\t" + iterator.next());
		}
		System.out.println("*********************************************");

		// Reverse order iterator
		Iterator reverse = deque.descendingIterator();
		System.out.println("Iterating over Deque with Reverse Iterator");
		while (reverse.hasNext()) {
			System.out.println("\t" + reverse.next());
		}
		System.out.println("*********************************************");

		// Peek returns the head, without deleting it from the deque
		System.out.println("Peek into the Deque" + deque.peek());
		System.out.println("After peek: \n");
		System.out.println(deque);
		System.out.println("*********************************************");

		// Pop returns the head, and removes it from the deque
		System.out.println("Pop from Deque" + deque.pop());
		System.out.println("After pop: \n");
		System.out.println(deque);
		System.out.println("*********************************************");

		// We can check if a specific element exists in the deque
		System.out.println("Contains element 3: " + deque.contains("Element 3 (Tail)"));
		System.out.println("*********************************************");
		// We can remove the first / last element.
		deque.removeFirst();
		deque.removeLast();
		System.out.println("Deque after removing first and last: " + deque);
	}

}
