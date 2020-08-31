package Heaps;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int length;
	
	public MaxHeap(int length) {
		this.length = length;
		this.size = 0;
		heap = new int[length + 1]; // length + 1 because the first index is not used
	}
	
	private int getLeftChildIndex(int currentIndex) {
		return currentIndex * 2;
	}
	
	private int getRightChildIndex(int currentIndex) {
		return (currentIndex * 2) + 1; 
	}
	
	private void swap(int element1, int element2) {
		int temp = heap[element1];
		heap[element1] = heap[element2];
		heap[element2] = temp;
	}
	
	private void add(int element) {
		size++;
		heap[size] = element;
		int temp = size;
		
		while ((temp > 1) && (heap[temp] > heap[temp / 2])) {
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
				if (heap[getLeftChildIndex(currentIndex)] > heap[getRightChildIndex(currentIndex)]) {
					if (heap[currentIndex] < heap[getLeftChildIndex(currentIndex)]) {
						int minChild = getLeftChildIndex(currentIndex);
						swap(currentIndex, minChild);
						currentIndex = minChild;
					}
					else {
						return elementToRemove;
					}	
				}
				else if (heap[getLeftChildIndex(currentIndex)] < heap[getRightChildIndex(currentIndex)]) {
					if (heap[currentIndex] < heap[getRightChildIndex(currentIndex)]) {
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
				if (heap[currentIndex] < heap[getLeftChildIndex(currentIndex)]) {
					int minChild = getLeftChildIndex(currentIndex);
					swap(currentIndex, minChild);
					currentIndex = minChild;
				}
				else {
					return elementToRemove;
				}
			}
			else if ((heap[getLeftChildIndex(currentIndex)] == 0) && (heap[getRightChildIndex(currentIndex)] != 0)) {
				if (heap[currentIndex] < heap[getRightChildIndex(currentIndex)]) {
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
		MaxHeap maxHeap = new MaxHeap(15);
//		maxHeap.add(1);
//		maxHeap.add(2);
//		maxHeap.add(3);
//		maxHeap.add(4);
//		maxHeap.add(5);
//		maxHeap.add(6);
//		maxHeap.add(7);
//		maxHeap.add(8);
//		maxHeap.add(9);
		
		maxHeap.add(5);
		maxHeap.add(3);
		maxHeap.add(17);
		maxHeap.add(10);
		maxHeap.add(84);
		maxHeap.add(19);
		maxHeap.add(6);
		maxHeap.add(22);
		maxHeap.add(9);
	
		maxHeap.printHeap();
		
		System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        System.out.println("The max val is " + maxHeap.remove()); 
        
    } 
}
