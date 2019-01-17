package LinkList;
/*
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 */
public class RotateALinkList {

	public ListNode rotate(ListNode head, int k){
		if(head == null || head.next == null || k == 0) return head;
		int count = 1;
		ListNode ptr = head;
		ListNode kthNode = null;
		while(count < k && ptr != null){
			ptr = ptr.next;
			count++;
		}
		
		if(ptr == null) return head;
		kthNode = ptr;
		
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head;
		head = kthNode.next;
		kthNode.next = null;
		return head;
	}
	
	
	public static void main(String[] args) {
		RotateALinkList obj = new RotateALinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.rotate(head,4);
        ll.printLinkList(head);
	}
}
