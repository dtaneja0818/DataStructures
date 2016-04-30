//http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
package LinkList;

import java.util.Hashtable;

public class RemoveDuplicatesFromSortedAndUnsortedLinkeList {

	//Time Complexity: O(n) where n is number of nodes in the given linked list
	public LinkListNode removeDuplicatesFromSortedLL(LinkListNode head){
		if(head == null){
			return null;
		}
		LinkListNode current = head;
		LinkListNode temp = null;
		
		while(current.next != null){
			if(current.data == current.next.data){
				temp = current.next.next;
				current.next = null;
				current.next = temp;
			}else{
				current = current.next;
			}
		}
		return head;
	}
	
	//Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).
	public LinkListNode removeDuplicatesFromUnSortedLL(LinkListNode head){
		if(head == null){
			return null;
		}
		LinkListNode current = head;
		LinkListNode temp = null;
		Hashtable<Integer,Boolean> hash = new Hashtable<Integer,Boolean>();
		while(current.next != null){
			if(hash.containsKey(current.next.data)|| current.data == current.next.data){
				temp = current.next.next;
				current.next = null;
				current.next = temp;
			}else{
				hash.put(current.data, true);
				current = current.next;
			}
		}
		return head;
	}
		
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedAndUnsortedLinkeList obj = new RemoveDuplicatesFromSortedAndUnsortedLinkeList();
		LinkListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		obj.removeDuplicatesFromSortedLL(head);
		ll.printLinkList(head);
		head = ll.createLinkList();
		ll.printLinkList(head);
		obj.removeDuplicatesFromUnSortedLL(head);
		ll.printLinkList(head);
	}
}
