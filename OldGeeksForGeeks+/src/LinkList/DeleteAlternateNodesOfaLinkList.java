package LinkList;
/*
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 */
 
public class DeleteAlternateNodesOfaLinkList {

	public ListNode deleteAlternateNodes(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode ptr = head;
		while(ptr != null && ptr.next != null){
			ptr.next = ptr.next.next;
			ptr = ptr.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		DeleteAlternateNodesOfaLinkList obj = new DeleteAlternateNodesOfaLinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.deleteAlternateNodes(head);
        ll.printLinkList(head);
	}
}
