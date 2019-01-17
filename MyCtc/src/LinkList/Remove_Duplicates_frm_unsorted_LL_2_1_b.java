/*Here we have created a hash table and inserted values in it.
 * Before inserting we are checking if there is any already existing key with that value
 * if not insert in else incr the counter for LL
 * */
package LinkList;

import java.util.*;

public class Remove_Duplicates_frm_unsorted_LL_2_1_b {

		static linklistOpeartions ll=new linklistOpeartions();
		
		public static void main(String[] args) {
			Node head=null;
			head=ll.pushAtEnd(2,head);
			head=ll.pushAtEnd(1,head);
			head=ll.pushAtEnd(1,head);
			head=ll.pushAtEnd(2,head);
			//ll.print(head);
			removeDuplicates(head);
			//ll.print(head);
		}
		private static void removeDuplicates(Node head) {
			Hashtable ht=new Hashtable();
			Node curptr=head;
			Node preptr=null;
			while(curptr!=null){
				if(ht.containsKey(curptr.data))preptr.next=curptr.next;
				else{
					ht.put(curptr.data,true);
					preptr=curptr;
				}
				curptr=curptr.next;	
			}
			 System.out.println(ht);
		        Enumeration<Integer> enumKey = ht.keys();
		        while(enumKey.hasMoreElements()) {
		            Integer key = enumKey.nextElement();
		            System.out.println(key);
		        }
	}

}
