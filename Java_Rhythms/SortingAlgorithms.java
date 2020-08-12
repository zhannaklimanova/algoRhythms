package Java_Rhythms;

public class SortingAlgorithms {
	
	/* O(n^2)
	 * bubbleSort maintains a sorted list at the end and 
	 * add biggest elements one by one.
	 * 
	 * Best case: O(n) when there's no swapping and list is sorted initially
	 * Worst case: O(n^2) 
	 */
	public static void bubbleSort(int[] list) {
		int counter = 0;
		boolean swapHappened = false;
		
		do {
			swapHappened = false;
			for (int i = 0; i < list.length - 1 - counter; i++) {
				if (list[i] > list[i+1]) {
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					swapHappened = true;
				}
			}
		} while (swapHappened != false);
		counter++;
	}
	
	/* O(n^2)
	 * selectionSort maintains finds the smallest element and adds it at the 
	 * start.
	 * selectionSort partitions the list into two parts: 
	 * 1. a sorted part, initially empty, in which elements are sorted
	 * 2. a "rest" part, initially of size N, in which elements can be in any order
	 * 
	 * Best case: O(n^2)
	 * Worst case: O(n^2)
	 */
	public static void selectionSort(int[] list) {
		for (int currentPosition = 0; currentPosition < list.length-1; currentPosition++) {
			int movingIndex = currentPosition;
			int smallestElement = list[currentPosition];
			int i;
			
			for (i = currentPosition + 1; i < list.length; i++) {
				if (list[i] < smallestElement) {
					movingIndex = i;
					smallestElement = list[i];
				}
			}
			if (movingIndex != currentPosition) {
				int temp = list[currentPosition];
				list[currentPosition] = list[movingIndex];
				list[movingIndex] = temp;
			}
		}
	}
	
	/* O(n^2)
	 * insertionSort inserts the current element into its correct position with respect
	 * to the elements throughout the rest of the list.
	 * Like selection sort we keep an unsorted part of the list and a sorted part and 
	 * at each step we add an element from the unsorted region to the sorted region.
	 * 
	 * Best case: O(n) already sorted list; the algorithm iterates n times but at each time 
	 * it does nothing (constant time to look and realize it needs to do nothing)
	 * Worst case: O(n^2) 
	 * 
	 */
	public static void insertionSort(int[] list) {
		for (int currentPosition = 1; currentPosition < list.length; currentPosition++) {
			int shiftPosition = currentPosition;
			int element = list[shiftPosition];
			
			while (shiftPosition > 0 && element < list[shiftPosition-1]) {
				list[shiftPosition] = list[shiftPosition-1];
				shiftPosition--;
			}
			list[shiftPosition] = element;
		}
	}
}
