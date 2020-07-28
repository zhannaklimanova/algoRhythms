package LinkedLists;

//  import java.util.Iterator;

public class TestSLinkedList {

	public	static	void   main(String[] args){	 
				
		SLinkedList_stubs<String> list = new SLinkedList_stubs<String>();		
		
		list.addFirst("a"); 
		list.show();
		
		list.addLast("b");  
		list.show();
		
		list.addLast("c"); 
		list.show();
		
		list.add(1,"d"); 
		list.show();   // output : a  d  b  c (size is 4 )
		
		list.add(4, "z");
		list.show();
		
		list.addFirst("e");
		list.show();
		
//		System.out.println("index of z is " + list.getIndexOf("z")); // index of z is 5
//		System.out.println("index of d is " + list.getIndexOf("d")); // index of d is 2
//		System.out.println("index of q is " + list.getIndexOf("q")); // index of q is -1
//	
//		System.out.println("THE CURRENT SIZE IS " + list.getSize());
//		
//		System.out.println("removed " + list.remove(5)); // removing "z"
//		list.show();
//		
//		System.out.println("THE CURRENT SIZE IS " + list.getSize());
//		
//		System.out.println("removed " + list.remove(0)); // removing "e"
//		list.show();
//		
//		System.out.println("THE CURRENT SIZE IS " + list.getSize());
//		
//		System.out.println("removed " + list.remove(2)); // removing "b"
//		list.show();
//		
//		System.out.println("THE CURRENT SIZE IS " + list.getSize());
//		System.out.println("removing something that's not there and returning " + list.remove(6));
		
		
		
	    list.reverse();
	    list.show();
	    list.reverse();
	    list.show();
	}
	
	/*
		  a  (size is 1 )
		  a  b  (size is 2 )
		  a  b  c  (size is 3 )
		  a  d  b  c  (size is 4 )
		  e  a  d  b  c  (size is 5 )
		  c  b  d  a  e  (size is 5 )
	 */
}
