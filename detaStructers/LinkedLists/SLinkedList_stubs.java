package LinkedLists;

/**
 * A basic implementation of some methods in a singly linked list class.
 * @author Michael Langer and several methods completed by @author zhanna klimanova
 * 
 * (Most of this code was adapted from textbooks 
 * e.g. by Frank Carrano,  Mark Allen Weiss, 
 *         Michael Goodrich and Roberto Tomassia)
 *         
 *  I put some Javadoc in this code, e.g.  @param, @return
 *  But I do not expect you to do so in this course 
 *  (and I generally don't do it when I am writing my own Java code)
 *  
 */

public class SLinkedList_stubs<E>  {

	
/* 
 *  Fields
 */
	
	private 	SNode<E> head;			 
	private		SNode<E> tail;		
	private		int 	 size; 	

	/*
	 * Constructor
	 */
	
	SLinkedList_stubs(){
    	head  = null;
	    tail  = null;
	    size  = 0;
	}
	
	/** @author zhanna klimanova **/
	public int getSize() { 
		return this.size;
	}
	
	/**
	 * Inserts the element to the specified position in this list
	 * where index is from 0 to size.   If the position is size, then 
	 * add element to the end of the list. 
	 * @param <T>
	 * @param i  the position where the element should go
	 * @param element is the element to be added 
	 */
	
	public <T> void add(int i, E element){
		if ((i < 0) || (i > size)){
			  throw new IndexOutOfBoundsException();
		}
		if (i == 0){
			addFirst(element);
		}
		else if (i == size){        //  Both necessary to do this test.  Only do it because 
			addLast(element);       //  it is more efficient than what is below.
		}
		else {  /** @author zhanna klimanova **/
			SNode<E> elementToAdd = new SNode<E>(element);
			SNode<E> elementBeforeI = getNode(i-1);
			elementToAdd.next = elementBeforeI.next;
			elementBeforeI.next = elementToAdd;
			size++;
		}			
	}
	
	/**
	 * add a new element to front of list 
	 * @param element the new element
	 */
	
	public void addFirst(E element){	
		SNode<E> newNode = new SNode<E>(element); 
		size++;
		if (head == null){
			head = newNode;
			tail = head; 
		}
		else{
			newNode.next = head;  //  Why not newNode.setNext(head)  ?  You could but you don't need to.                           
			head = newNode;       //  i.e. Don't need to use get and set methods inside the class.
		}
	}

	/**
	 * add a new element to the end of the list
	 * @param element is the new element 
	 */
	
	public void addLast(E element){
		SNode<E> newNode = new SNode<E>(element); 
		size++;
		if (head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail      = newNode;
		}
	}
	      
	/**
	 * remove all elements from the list
	 */
	
	public void clear(){
		head  = null;
		tail  = null;
		size  = 0;
	}

	/**
	 * get the element at position i in the list (0,..., size -1 )
	 * @param i  the index of the element
	 * @return the element to get
	 */
	
	public E get(int i){
		return getNode(i).getElement();
		
	}
	
	/**
	 * get the first element in a list (index position 0)
	 * @return element stored at front of list.
	 */
	
	public  E  getFirst(){
		if (head != null)
			return head.getElement();	
		else
			return null;
	}

	
	/**
	 * get the last element in a list (index position size-1)
	 * @return element (an object of type E) stored at last node of list
	 */

	public E  getLast(){
		if (tail != null)
			return tail.getElement();
		else
			return null;
	}
	
	/**
	 *   If e is an element in the list, then return the index
	 *   of the first occurence of that element.   Otherwise, return -1.  
	 *   @return the first index where element e occurs
	 */

	public int getIndexOf(E  e){ 
		SNode<E>  cur = head;
		int i = 0;     
		
		if (cur == null)
			return -1;
		
	
		else { 	/** @author zhanna klimanova **/
			try {
				while (!cur.getElement().equals(e)) {
					cur = cur.getNext();
					i++;
				}
			}
			catch (Exception exception) {
				System.out.println("The element you have entered is not in the list! ");
			}
		}
		return i;   
	}
	
	public boolean isEmpty() { 
		return (size == 0); 
	}

	/**
	 *   Removes the first occurrence of an element e from a list
	 *   If element is not in the list, then do nothing.	
	 */

	public void remove(E element){		 
		int index = getIndexOf(element);
		if (index >= 0){
			remove(index);
		}
	}

	/**
	 *   Removes the element at index i  in  0 to size-1, and return it.
	 *   @return the element at index i.
	 */

	public E remove(int i){ 
		try {
			if ((i < 0) || (i >= size)){
				  throw new IndexOutOfBoundsException();
			}
			else{
				
				//  first deal with special case that size == 1, i == 0
				
				if ((size == 1) && (i == 0)){  	//  only one node in list
					size--;
					SNode<E> cur = head;
					head = null;  
					tail = null;
					return cur.getElement(); 
				}
				
				//  Now we can assume that size > 1.   
				//  We first deal with case that i == 0
				
				if (i == 0){
					SNode<E> cur = head;
					head = head.next;
					size--;
					return cur.getElement();
				}
				else if (i == size-1) { /** @author zhanna klimanova **/
					SNode<E> current = tail;
					SNode<E> beforeCurrent = getNode(size-2);
					beforeCurrent.next = null;
					size--;
					return current.getElement();
				}
				// we can assume that i > 0;
				else {  /** @author zhanna klimanova **/
					SNode<E> elementToRemove = getNode(i);
					SNode<E> elementPrevious = getNode(i-1);
					elementPrevious.next = elementToRemove.next;
					size--;
					return elementToRemove.getElement();   
				}
			}
		}
		catch (Exception e) {
			System.out.println("Index is not in this list! ");
		}
		return null;
	}

	/**
	 * Remove element at front of the list.
	 * @return first element in list
	 */
	
	public	E removeFirst(){  
		return remove(0);
	}

	/**
	 * Remove element at back of list.
	 * @return  last element 
	 */
	
	public E removeLast(){		
		return remove(size-1);
	}
	

	/**
	 *   Sets the ith element in the list.   
	 *   @param i  the index of element to be set
	 *   @param e  the new element that replaces the old element   
	 */
	
	public void set(int i,  E  e){
		if ((i < 0) || (i >= size)){
			  throw new IndexOutOfBoundsException();
		}
		else{
			getNode(i).setElement(e);
		}
	}
	/**
     *   Puts the list nodes in opposite order.
     *
     *   The links must all go in the opposite direction, and head and tail must be swapped.
     *   To do it, we walk from head to tail, maintaining a partition of the nodes into two
     *   lists:  the nodes up to the current node, and the nodes beyond the current node.
     */
	
    public void reverse() { /** @author zhanna klimanova **/
        SNode<E> a, b, temp;
        if (head != null){
            a = null; // always pointing to the element before
            b = head; // pointing to the element ahead
            while (b != null) {
            	temp = b.next;
            	b.next = a;
            	a = b; 
            	b = temp;
            	
            }
            tail = head;
            head = a;
        }
    } 
    
	/**
	 *    Show all elements in list.    Alternatively I could have overriden the toString() method and then
	 *    just print the object,  since printing an object automatically calls the toString() method.
	 */
	
	public void show(){			 
		SNode<E> cur = head;
		while (cur != null){
			System.out.print("  " + cur.getElement().toString());
			cur = cur.next;
		}
		System.out.println("  (size is " + size + " )");
	}

	//   The next two methods are private.  The client has no access to the nodes of the linked list, 
	//   but rather the client can only access the elements that are stored in the list.
	
	
	/*
	 *     @param  index of node to get
	 *     @return ith SNode of the linked list
	 *     
	 */
	
	public SNode<E> getNode(int i){
		if ((i < 0) || (i >= size)){
			  throw new IndexOutOfBoundsException();
		}
		else {		
			if (i == 0){  	//  only one node in list
				return head; 
			}
			/** @author zhanna klimanova **/
			else if (i == size-1) {
				return tail;
			}
			else { 
				SNode<E> current = head;
				int counter = 0;
				
				try {			
					while (counter != i) {
						current = current.next;
						counter++;
					} 
				}
				catch (Exception e) {
					System.out.println("Out of bounds! ");
				}
				return current;  
			}
		}
	}
	
	//  inner class
	
	private class SNode<T> {    //  I have to use a different generic type since I am defining a class here. 

		private 	T	  		element;		
		private		SNode<T> 	next;		

		SNode(T element){
			this.element = element; 
			next = null;
		}
		
		T  getElement(){
			return this.element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}

		SNode<T>  getNext(){
			return this.next;
		}
		
	}
}
