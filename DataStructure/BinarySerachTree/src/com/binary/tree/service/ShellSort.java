package com.binary.tree.service;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
	
	//Binary Tree Sort
	

    // Class containing left and 
    // right child of current  
    // node and key value 
    class Node  
    { 
        int key; 
        Node left, right; 
  
        public Node(int item)  
        { 
            key = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    Node root; 
  
    // Constructor 
    ShellSort()  
    {  
        root = null;  
    } 
  
    // This method mainly 
    // calls insertRec() 
    void insert(int key) 
    { 
        root = insertRec(root, key); 
    } 
      
    /* A recursive function to  
    insert a new key in BST */
    Node insertRec(Node root, int key)  
    { 
  
        /* If the tree is empty, 
        return a new node */
        if (root == null)  
        { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur 
        down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the root */
        return root; 
    } 
      
    // A function to do  
    // inorder traversal of BST 
    void inorderRec(Node root)  
    { 
        if (root != null)  
        { 
            inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
    } 
    void treeins(int arr[],int num) 
    { 
        for(int i = 0; i < num; i++) 
        { 
            insert(arr[i]); 
        } 
          
    } 

	//Binary Search
    
    public static void binarySearch(int arr[], int first, int last, int key){  
    	   int mid = (first + last)/2;  
    	   while( first <= last ){  
    	      if ( arr[mid] < key ){  
    	        first = mid + 1;     
    	      }else if ( arr[mid] == key ){  
    	        System.out.println("Element is found at index: " + mid);  
    	        break;  
    	      }else{  
    	         last = mid - 1;  
    	      }  
    	      mid = (first + last)/2;  
    	   }  
    	   if ( first > last ){  
    	      System.out.println("Element is not found!");  
    	   }  
    	 } 
	
	
	
	
	//Selection Sort
	
	  public static void selectionSort(int[] arr,int num){  
	        for (int i = 0; i < num - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < num; j++){  
	                if (arr[j] < arr[index]){  
	                    index = j;//searching for lowest index  
	                }  
	            }  
	            int smallerNumber = arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = smallerNumber;  
	        }  
	    } 
	  
	  
	  //Linear Search
	  
	  public static int linearSearch(int[] arr, int key,int num){    
	        for(int i=0;i<num;i++){    
	            if(arr[i] == key){    
	                return i;    
	            }    
	        }    
	        return -1;    
	    }  
	
	
	
	//Insertion Sort
	
	 void insertionSort(int arr[],int num) 
	    { 
	        int n = num; 
	        for (int i = 1; i < n; ++i) { 
	            int key = arr[i]; 
	            int j = i - 1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j >= 0 && arr[j] > key) { 
	                arr[j + 1] = arr[j]; 
	                j = j - 1; 
	            } 
	            arr[j + 1] = key; 
	        } 
	    } 
	
	

	// Quick Sort

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (arr[j] < pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void Quicksort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			Quicksort(arr, low, pi - 1);
			Quicksort(arr, pi + 1, high);
		}
	}

	// Radix Sort

	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of size n using
	// Radix Sort
	static void radixsort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	// Heap Sort
	public void sort(int arr[], int num) {
		int n = num;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	// Bubble Sort
	static void bubbleSort(int[] arr, int num) {
		int n = num;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}

	// Shell Sort
	static void shellsort(int[] arr, int num) {
		int i, j, k, tmp;
		for (i = num / 2; i > 0; i = i / 2) {
			for (j = i; j < num; j++) {
				for (k = j - i; k >= 0; k = k - i) {
					if (arr[k + i] >= arr[k])
						break;
					else {
						tmp = arr[k];
						arr[k] = arr[k + i];
						arr[k + i] = tmp;
					}
				}
			}
		}
	}

	// Merge Sort
	public static void merge(int[] left_arr, int[] right_arr, int[] arr, int left_size, int right_size) {

		int i = 0, l = 0, r = 0;
		// The while loops check the conditions for merging
		while (l < left_size && r < right_size) {

			if (left_arr[l] < right_arr[r]) {
				arr[i++] = left_arr[l++];
			} else {
				arr[i++] = right_arr[r++];
			}
		}
		while (l < left_size) {
			arr[i++] = left_arr[l++];
		}
		while (r < right_size) {
			arr[i++] = right_arr[r++];
		}
	}

	// Merge Sort
	public static void mergeSort(int[] arr, int len) {
		if (len < 2) {
			return;
		}

		int mid = len / 2;
		int[] left_arr = new int[mid];
		int[] right_arr = new int[len - mid];

		// Dividing array into two and copying into two separate arrays
		int k = 0;
		for (int i = 0; i < len; ++i) {
			if (i < mid) {
				left_arr[i] = arr[i];
			} else {
				right_arr[k] = arr[i];
				k = k + 1;
			}
		}
		// Recursively calling the function to divide the subarrays further
		mergeSort(left_arr, mid);
		mergeSort(right_arr, len - mid);
		// Calling the merge method on each subdivision
		merge(left_arr, right_arr, arr, mid, len - mid);
	}

	public static void main(String[] args) {
		ShellSort sort = new ShellSort();

		// Shell Sort
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[30];
		int k, num;

		System.out.println("Enter total no. of elements : ");
		num = sc.nextInt();

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print("\nOption:\tTo Do:\n1\tTo Add element.\n2\tShell Sort.\n3\tTo view Sorted List."
					+ "\n4\tMerge Sort.\n5\tBubble Sort.\n6\tHeap Sort.\n7\tRadix Sort.\n8\tQuick Sort.\n9\tInsertion Sort"
					+ ".\n10\tSelection Sort.\n11\tBinary Tree Sort.\n12\tLinear Search..\n13\tBinary Search"
					+ "\n14\tTo Exit From Program.\nEnter your option:- ");
			select = sc.nextInt();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert:- ");

				for (k = 0; k < num; k++) {
					arr[k] = sc.nextInt();
				}
				break;
			}
			case 2: {
				System.out.println("\n Shell Sort is perfomed :");
				shellsort(arr, num);
				break;
			}
			case 3: {
				System.out.println("\n  Sorted List : ");
				for (k = 0; k < num; k++)
					System.out.println(arr[k] + " ");
				break;
			}
			case 4: {
				System.out.println("\nMerge Sort is perfomed :");
				mergeSort(arr, num);
				break;

			}
			case 5: {
				System.out.println("\n Bubble Sort is perfomed :");
				bubbleSort(arr, num);
				break;

			}
			case 6: {
				System.out.println("\n Heap Sort is perfomed :");
				sort.sort(arr, num);
				break;

			}
			case 7: {
				System.out.println("\n Radix Sort is perfomed :");
				radixsort(arr, num);
				break;

			}
			case 8: {
				System.out.println("\n Quick Sort is perfomed :");
				sort.Quicksort(arr, 0, num - 1);
				break;

			}
			case 9: {
				System.out.println("\n Insertion Sort is perfomed :");
				sort.insertionSort(arr, num);
				break;

			}
			case 10: {
				System.out.println("\n Selection Sort is perfomed :");
				selectionSort(arr, num);
				break;

			}
			
			case 11: {
				System.out.println("\n Binary Tree Sort is perfomed :");
				sort.treeins(arr,num); 
		        sort.inorderRec(sort.root); 
				break;

			}

			case 12: {
				System.out.println("\n Linear Search:");
				int a= sc.nextInt();
				int key = a;   
				System.out.println(key+" is found at index: "+linearSearch(arr, key,num));    
				break;

			}
			case 13: {
				System.out.println("\n Binary Search:");
				int a= sc.nextInt();
				int key = a;   
				 int last=num-1;
				 binarySearch(arr,0,last,key);    
				break;

			}

			case 14: {
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
