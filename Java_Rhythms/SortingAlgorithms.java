package Java_algoRhythms;
import java.util.ArrayList;

public class SortingAlgorithms {
	
	/* O(nlog(n))
	 * mergeSort is a divide and conquer algorithm: 
	 * 1. partitions the list into two halves 
	 * 2. sorts each half recursively 
	 * 3. merge the sorted half maintaining the order
	 * 
	 * Best case: O(nlog(n))
	 * Worst case: O(nlog(n))
	 * 
	 * mergeSort is more efficient and works faster than quickSort
	 * when dealing with larger data sets. However, mergeSort does take up 
	 * more space as it uses an extra list, which can hurt the sorting 
	 * performance for big data sets. 
	 */
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		if (list.size() == 1) {
			return list;
		}
		else {
			int middle = (int) Math.ceil((list.size()-1)/2.0);			
			ArrayList<Integer> list1 = new ArrayList<Integer>(middle);
			ArrayList<Integer> list2 = new ArrayList<Integer>(list.size() - middle);
			
			for (int i = 0; i < middle; i++) {
				list1.add(list.get(i));
			}
			for (int i = middle; i < list.size(); i++) {
				list2.add(list.get(i));
			}
			
			list1 = mergeSort(list1);
			list2 = mergeSort(list2);
			
			int listSize = list.size();
			return merge(listSize, list1, list2);
		}
	}
	
	public static ArrayList<Integer> merge(int listSize, ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> sortedList = new ArrayList<Integer>(listSize);
		
		while (!list1.isEmpty() && !list2.isEmpty()) {
			if (list1.get(0) < list2.get(0)) {
				sortedList.add(list1.remove(0));
			}
			else {
				sortedList.add(list2.remove(0));
			}
		}
		while (!list1.isEmpty()) {
			sortedList.add(list1.remove(0));
		}
		while (!list2.isEmpty()) {
			sortedList.add(list2.remove(0));
		}
		return sortedList;
	}
	
	/* O(nlog(n))
	 * quickSort is a divide and conquer algorithm: 
	 * 1. pick an element of the array (the pivot)
	 * 2. partition the list moving the pivot to its correct position 
	 * 	  making sure all the lower elements are on its left and all 
	 *    the larger elements are on its right
	 * 3. sort the left part and the right part recursively
	 * 4. keep repeating until there's nothing left to sort
	 * 
	 * Best case: O(nlog(n))
	 * Worst case: O(n^2) when list is already sorted in either ascending or descending order
	 * 
	 * quickSort is more efficient and works faster than mergeSort
	 * when dealing with smaller data sets. 
	 */
	
	public static void quickSort(int[] list, int leftSide, int rightSide) {
		if (leftSide >= rightSide) { // base case where there is only one element which does not need sorting
			return;
		}
		else {
			int i = placeAndDivide(list, leftSide, rightSide); // i is index where the pivot is placed
			quickSort(list, leftSide, i-1); 
			quickSort(list, i+1, rightSide);
		}
	}
	
	public static int placeAndDivide(int[] list, int leftSide, int rightSide) {
		int pivot = list[rightSide]; // pick the rightmost element for the pivot
		int wall = leftSide-1; // place wall to the left
		
		for (int i = leftSide; i < rightSide; i++) { // go through all elements and compare them to the pivot
			if (list[i] < pivot) {
				wall++;  // move wall 
				int temp = list[wall]; // move element behind wall
				list[wall] = list[i];
				list[i] = temp;
			}
		}
		
		int temp = list[wall+1]; // move pivot next to the wall
		list[wall+1] = list[rightSide];
		list[rightSide] = temp;
		
		return wall+1;
	}
	
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
