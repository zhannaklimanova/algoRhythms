package Stack_Queue;

/* Queue are first in first out (FIFO): best use case when we want to do things 
 * in order.
 * 
 * Queue will be implemented using a Singly Linked List where the most efficient 
 * way to do it would be to enqueue at the end and dequeue at the start. 
 * 
 * If Queue is implemented using an ArrayList it will not be particularly efficient 
 * because adding and removing has to be done at different ends of ArrayList which 
 * requires shifting which increases the time complexity. 
 * 
 * If Queue is implemented using a Doubly Linked List, it will not be much different
 * from the Singly Linked List implementation. DLL will be slightly more complicated
 * than SLL as it uses more space and time to store the extra references. 
 */

public class Queue<T> {
	private Node<T> root;
	private Node<T> end;

	Queue() {
		this.root = this.end = null;
	}
	
	private class Node<E> {
		private E data;
		private Node<E> next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void enqueue(T data) {
		Node<T> nodeToEnqueue = new Node<T>(data);
		
		if (this.end == null) {
			this.root = nodeToEnqueue;
			this.end = nodeToEnqueue;
		}
		this.end.next = nodeToEnqueue;
		this.end = nodeToEnqueue;
		System.out.println(nodeToEnqueue.data + " enqueued to queue.");
	}
	
	public void dequeue() {
		if (this.root == null) {
			System.out.println("Queue is empty, nothing to dequeue!");
			return;
		}
		Node<T> nodeToDequeue = this.root;
		this.root = this.root.next;
		if (this.root == null) {
			this.end = null;
		}
		System.out.println(this.root.data + " is at the top of the queue and " + nodeToDequeue.data + " has been dequeued.");
		
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		queue.dequeue(); // 2 is at the top of the queue and 1 has been dequeued.
		queue.dequeue(); // 3 is at the top of the queue and 2 has been dequeued.
		queue.dequeue(); // 4 is at the top of the queue and 3 has been dequeued.
		queue.dequeue(); // 5 is at the top of the queue and 4 has been dequeued.
		
		
		
		
		
	}
}
