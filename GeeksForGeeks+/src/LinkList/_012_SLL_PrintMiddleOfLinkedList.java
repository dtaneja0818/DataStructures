//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
package LinkList;

public class _012_SLL_PrintMiddleOfLinkedList {

	public int getMiddle(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		
		if(head != null){
			while(fast != null && fast.next != null){
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow.data;
		}
		throw new Error("List Empty");	
}
	
	public static void main(String[] args) {
		_012_SLL_PrintMiddleOfLinkedList obj = new _012_SLL_PrintMiddleOfLinkedList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		System.out.println("Middle node is: "+obj.getMiddle(head));
	}
}
