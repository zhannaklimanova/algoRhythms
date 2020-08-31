package Stack_Queue;

/*
 * A queue will be implemented using a circular array and using the
 * char primitive data type for simplicities sake. However, the 
 * principles used can apply to any other data type as well. 
 */

public class CircularArray { 
	private int size = 0;
	private char[] queue;
	private int head = 0;
//	the tail is ==> (head + (size - 1)) % queue.length
	
	public CircularArray(int initialLength, int size, int headIndex) {
		this.size = size;
		queue = new char[initialLength];
		this.head = headIndex;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void enqueue(char element) {
		if (size < queue.length) {
			queue[((head + (size - 1)) % queue.length + 1) % queue.length] = element; 
			System.out.println(element + " has been enqueued.");
		}
		else if (size == queue.length) {
			char[] tempQueue = new char[queue.length * 2];
			
			for (int i = 0; i < queue.length; i++) {
				tempQueue[i] = queue[(head + i) % queue.length];
			}
			head = 0;
			queue = tempQueue;
			queue[size] = element;
			System.out.println(element + " has been enqueued.");
		}
		size++;
	}
	
	public char dequeue() {
		if ((size-1) == 0) {
			char element = queue[head];
			queue[head] = 0;
			head = (head + 1) % queue.length;
			size--;
			head = 0;
			System.out.println(element + " has been removed. Queue is now empty.");
			return element;
		}
		else if (size == 0) {
			System.out.println("There are no elements to dequeue.");
			return 0;
		}
		else {
			char element = queue[head];
			queue[head] = 0;
			head = (head + 1) % queue.length;
			size--;
			System.out.println(element + " has been removed.");
			return element;
		}	
	}
	
	public static void main(String[] args) {
		CircularArray queue = new CircularArray(4, 0, 0);

		queue.enqueue('a'); 
		System.out.println(queue.getSize()); 
		queue.enqueue('b'); 
		System.out.println(queue.getSize()); 
		queue.enqueue('c'); 
		System.out.println(queue.getSize()); 
		queue.enqueue('d');
		System.out.println(queue.getSize());
		queue.enqueue('e'); 
		System.out.println(queue.getSize());
		
		queue.dequeue(); 
		System.out.println(queue.getSize()); 
		queue.dequeue(); 
		System.out.println(queue.getSize());
		queue.dequeue(); 
		System.out.println(queue.getSize()); 
		queue.dequeue(); 
		System.out.println(queue.getSize()); 
		queue.dequeue();
		System.out.println(queue.getSize()); 
		queue.dequeue(); 
		System.out.println(queue.getSize()); 
		queue.enqueue('z'); 
		System.out.println(queue.getSize()); 
	}

}
