package LinkedLists;


public class DLinkedList_Test{
	 public static void main(String[] args){ /** @author zhanna klimanova **/
		 
		  DLinkedList_stubs<String> list = new DLinkedList_stubs<String>(); 
		  
		  list.addFirst("a");
		  list.addLast("b");
		  list.addLast("c");
		  list.addLast("d");
		  list.addLast("e");
		  list.show(); // [  a b c d e ]
		  
//		  list.remove(2);
//		  list.show(); // [  a b d e ]
//		  
//		  list.remove(0); 
//		  list.show(); // [  b d e ]
//		  
//		  list.remove(2);
//		  list.show(); // [  b d ]
//		  System.out.println(list.getSize()); // 2 

		  list.reverse();
  	      list.show();
  	      
  	      /* 
  	       *	[  a b c d e ] 	[  e d c b a ]
  	       */

	 }	  
}
