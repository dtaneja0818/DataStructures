package LinkList;
/*
 * http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
 */
 
public class InsertInASortedLinkList {
	
	public ListNode insert(ListNode head, int x){
		ListNode ptr = head;
		ListNode newNode = new ListNode(x);
		if(head == null){
			head = newNode;
			return head;
		}
		if(head.data >= x){
			newNode.next = head;
			head = newNode;
			return head;
		}
		while(ptr.next != null){
			if(ptr.next.data >= x) break;
			ptr = ptr.next;
		}
		
		newNode.next = ptr.next;
		ptr.next = newNode;
		return head;
	}
	
	public static void main(String[] args) {
		InsertInASortedLinkList obj = new InsertInASortedLinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.insert(head,9);
        ll.printLinkList(head);
	}
}
