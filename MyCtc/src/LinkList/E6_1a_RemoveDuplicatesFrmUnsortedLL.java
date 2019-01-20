package LinkList;
import java.util.*;
/*2.1
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * Solution:

 * 
*/

public class E6_1a_RemoveDuplicatesFrmUnsortedLL {

	// using internal LinkList
	private LinkedList removeDuplicateApproach1(LinkedList head){
		if(head == null) return head;
		Hashtable table = new Hashtable();
		Iterator itr = head.iterator();
		while(itr.hasNext()){
			Object value = itr.next();
			//System.out.println(value);
			if(table.containsKey(value)){
				itr.remove();
			}
			else{
				table.put(value,true);
			}
		}
		return head;
	}
		
	
	private ListNode removeDuplicateApproach2(ListNode head){
		if(head == null)
            return head;
 
        Hashtable table = new Hashtable();
        ListNode ptr = head;
        ListNode prev = null;
        while(ptr != null){
        	if(table.containsKey(ptr.data))
        		prev.next = ptr.next;
        	else{
        		table.put(ptr.data,true);
        		prev = ptr;
        	}
        	ptr = ptr.next;
        }
        return head;
    }
    
	/*	No Buffer Allowed
		If we don't have a buffer, we can iterate with two pointers: current which iterates
		through the linked list, and runner which checks all subsequent nodes for duplicates.
		0(1) space, but 0(N 2 ) time
	*/
	private ListNode removeDuplicateApproach3(ListNode head){
		if(head == null)
            return head;
            
        ListNode current = head;
        while(current != null){
            ListNode ptr = current;
        	while(ptr.next != null){
        		if(current.data == ptr.next.data){
        			ptr.next = ptr.next.next;
        		}
        		else
        			ptr = ptr.next;
        	}
   			current = current.next;
        }
        return head;
	}
	
	public static void main(String[] args) {
		E6_1a_RemoveDuplicatesFrmUnsortedLL obj = new E6_1a_RemoveDuplicatesFrmUnsortedLL();
		//LinkListOperations list = new LinkListOperations();
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(4);
 		// create a linked list
 		//ListNode head = list.createLinkList();
 		//list.printLinkList(head);
      	obj.removeDuplicateApproach1(list);
     	//list.printLinkList(head);
     	System.out.println(list);
   	}
}
