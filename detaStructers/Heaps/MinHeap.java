package Heaps;


public class MinHeap {
	private int[] heap;
	private int size;
	private int length;
	
	public MinHeap(int length) {
		this.length = length;
		this.size = 0;
		heap = new int[length + 1]; // length + 1 because the first index is not used
//		for (int i = 0; i < heap.length-1; i++) {
//			heap[i] = 0;
//		}
	}
	
	private int getLeftChildIndex(int currentIndex) {
		return currentIndex * 2;
	}
	
	private int getRightChildIndex(int currentIndex) {
		return (currentIndex * 2) + 1; 
	}
	
	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	private void add(int element) {
		size++;
		heap[size] = element;
		int temp = size;
		
		while ((temp > 1) && (heap[temp] < heap[temp / 2])) {
			swap(temp, temp/2);
			temp /= 2;
		}
	}
	
	private int remove() {
		int elementToRemove = heap[1];
		heap[1] = heap[size];
		heap[size] = 0;
		size--;
		int currentIndex = 1;

		while (getLeftChildIndex(currentIndex) <= this.length || 
				getRightChildIndex(currentIndex) <= this.length) {
			
			if ((heap[getLeftChildIndex(currentIndex)] != 0) && (heap[getRightChildIndex(currentIndex)] != 0)) {
				if (heap[getLeftChildIndex(currentIndex)] < heap[getRightChildIndex(currentIndex)]) {
					if (heap[currentIndex] > heap[getLeftChildIndex(currentIndex)]) {
						int minChild = getLeftChildIndex(currentIndex);
						swap(currentIndex, minChild);
						currentIndex = minChild;
					}
					else {
						return elementToRemove;
					}	
				}
				else if (heap[getLeftChildIndex(currentIndex)] > heap[getRightChildIndex(currentIndex)]) {
					if (heap[currentIndex] > heap[getRightChildIndex(currentIndex)]) {
						int minChild = getRightChildIndex(currentIndex);
						swap(currentIndex, minChild);
						currentIndex = minChild;
					}
					else {
						return elementToRemove;
					}
				}
			}
			else if ((heap[getLeftChildIndex(currentIndex)] != 0) && (heap[getRightChildIndex(currentIndex)] == 0)) {
				if (heap[currentIndex] > heap[getLeftChildIndex(currentIndex)]) {
					int minChild = getLeftChildIndex(currentIndex);
					swap(currentIndex, minChild);
					currentIndex = minChild;
				}
				else {
					return elementToRemove;
				}
			}
			else if ((heap[getLeftChildIndex(currentIndex)] == 0) && (heap[getRightChildIndex(currentIndex)] != 0)) {
				if (heap[currentIndex] > heap[getRightChildIndex(currentIndex)]) {
					int minChild = getRightChildIndex(currentIndex);
					swap(currentIndex, minChild);
					currentIndex = minChild;
				}
				else {
					return elementToRemove;
				}
			}
			else {
				if ((heap[getLeftChildIndex(currentIndex)] == 0) && (heap[getRightChildIndex(currentIndex)] == 0)) {
					return elementToRemove;
				}
			}
		}
		return 0;
	}
	
	private void printHeap() {
	       for (int i = 1; i <= size / 2; i++) { 
	            System.out.print(
	            		" Parent : " + heap[i] + 
	            		" Left : " + heap[2 * i] + 
	            		" Right:" + heap[2 * i + 1]); 
	            System.out.println(); 
	        }
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(25);
		minHeap.add(1);
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(4);
		minHeap.add(5);
		minHeap.add(6);
		minHeap.add(7);
		minHeap.add(8);
		minHeap.add(9);
		
//		minHeap.add(5);
//		minHeap.add(3);
//		minHeap.add(17);
//		minHeap.add(10);
//		minHeap.add(84);
//		minHeap.add(19);
//		minHeap.add(6);
//		minHeap.add(22);
//		minHeap.add(9);
	
		minHeap.printHeap();
		
		System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
        System.out.println("The min val is " + minHeap.remove()); 
	} 
}
