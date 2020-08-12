package Java_Rhythms;

import java.util.Arrays;

public class SortingAlgorithmsTester {
	
	public static void main(String[] args) {
		int[] unsortedArray = {5,4,3,2,1};
		int[] sortedArray = {1,2,3,4,5};
		int[] anotherArray = {1,5,3,4,2};
		
		// bubbleSort Tester
//		SortingAlgorithms.bubbleSort(unsortedArray); // worst case O(n^2)
//		System.out.println(Arrays.toString(unsortedArray)); // prints {1,2,3,4,5}
//
//		SortingAlgorithms.bubbleSort(sortedArray); // best case O(n)
//		System.out.println(Arrays.toString(sortedArray)); // prints {1,2,3,4,5}
		
		// selectionSort Tester
//		SortingAlgorithms.selectionSort(unsortedArray);
//		System.out.println(Arrays.toString(unsortedArray)); // prints {1,2,3,4,5}
//		
//		SortingAlgorithms.selectionSort(sortedArray); 
//		System.out.println(Arrays.toString(sortedArray)); // prints {1,2,3,4,5} 
//		
//		SortingAlgorithms.selectionSort(anotherArray);
//		System.out.println(Arrays.toString(anotherArray)); // prints {1,2,3,4,5}
		
		// insertionSort Tester
//		SortingAlgorithms.insertionSort(unsortedArray); // worst case O(n^2)
//		System.out.println(Arrays.toString(unsortedArray)); // prints {1,2,3,4,5}
//		
		SortingAlgorithms.insertionSort(sortedArray); // best case O(n)
		System.out.println(Arrays.toString(sortedArray)); // prints {1,2,3,4,5}
//		
//		SortingAlgorithms.insertionSort(anotherArray); 
//		System.out.println(Arrays.toString(anotherArray)); // prints {1,2,3,4,5}
	}
}
 