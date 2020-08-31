package Stack_Queue;

/* Stacks are last in first out (LIFO): best use case when we want to go back on 
 * what was done in some order. 
 * 
 * Stack will be implemented using a Singly Linked List where the most efficient 
 * way to do it would be to push by adding first and pop by removing first.
 * 
 * If Stack is implemented using an ArrayList it would be more efficient to push 
 * by adding last and pop by removing last. If push/pop are implemented 
 * at the beginning of the ArrayList, a shifting and re-copying of the elements 
 * will be required, which is highly inefficient. 
 * 
 * If Stack is implemented using a Doubly Linked List, popping and pushing at the 
 * beginning or end of the list does not make a difference on efficiency. The only 
 * reason why it wouldn't be as efficient as a SLL is because DLL take up more 
 * space in memory. 
 */

public class Stack<T> {
	Node<T> root;
	
	private class Node<E> {	
		private E data;
		private Node<E> next;
		
		Node(E data) {
			this.data = data;
			this.next = null;
		}
		
//		public E getData() {
//			return this.data;
//		}
//		
//		public void setData(E data) {
//			this.data = data;
//		}
//		
//		public Node<E> getNext() {
//			return this.next;
//		}
		
	}
	public void push(T data) {
		Node<T> nodeToPush = new Node<T>(data);
		
		if (this.root == null) {
			this.root = nodeToPush;
		}
		else {
			Node<T> temp = this.root; 
			this.root = nodeToPush;
			nodeToPush.next = temp; 
			System.out.println(nodeToPush.data + " pushed to stack.");
		}
	}
	
	public Node<T> pop() {
		if (this.root == null) {
			System.out.println("Stack is empty, nothing to pop.");
			return null;
		}
		else {
			Node<T> nodeToPop = this.root;
			this.root = this.root.next;
			System.out.println(nodeToPop.data + " has been popped.");
			return nodeToPop;
		}
	}
	
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		}
		return false;
	}
	
	public Node<T> peek() {
		if (this.root == null) {
			System.out.println("Stack is empty, nothing to peek at.");
			return null;
		}
		else {
			System.out.println(this.root.data + " is at the top of the stack.");
			return this.root;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.pop(); // Stack is empty, nothing to pop.
		
		stack.peek(); // Stack is empty, nothing to peek at.

	}
}
