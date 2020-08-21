package Java_algoRhythms;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgorithmsTester {
	
	public static void main(String[] args) {
		int[] unsortedArray = {5,4,3,2,1};
		int[] sortedArray = {1,2,3,4,5};
		int[] anotherArray = {1,5,3,4,2};
		
		ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(5,4,3,2,1));
		ArrayList<Integer> intArray2 = new ArrayList<>(Arrays.asList(1,5,3,4,2));
		
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
//		SortingAlgorithms.insertionSort(sortedArray); // best case O(n)
//		System.out.println(Arrays.toString(sortedArray)); // prints {1,2,3,4,5}
//		
//		SortingAlgorithms.insertionSort(anotherArray); 
//		System.out.println(Arrays.toString(anotherArray)); // prints {1,2,3,4,5}
		
		// mergeSort Tester
//		System.out.println(SortingAlgorithms.mergeSort(intArray).toString());
//		System.out.println(SortingAlgorithms.mergeSort(intArray2).toString());
	
		// quickSort Tester 
//		SortingAlgorithms.quickSort(unsortedArray, 0, unsortedArray.length-1);
//		System.out.println(Arrays.toString(unsortedArray));
//		
//		SortingAlgorithms.quickSort(anotherArray, 0, anotherArray.length-1);
//		System.out.println(Arrays.toString(anotherArray));
		
	}
}
 