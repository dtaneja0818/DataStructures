package LinkList;
/*
 * 
 */
public class DeleteNnodesAfterMnodesOfALinkList {

	public ListNode delete(ListNode head, int m, int n){
		if(head == null) return head;
		ListNode ptr = head;
		int count = 1;
		while(ptr.next != null){
			ptr = ptr.next;
			count++;
		}
		
		if(count < (m+n)) return head;
		
		ptr = head;
		while(m > 1){
			ptr = ptr.next;
			m--;
		}
		ListNode nthNode = ptr.next;
		while(n > 1){
			nthNode = nthNode.next;
			n--;
		}
		ptr.next = nthNode.next;
		return head;
	}
	
	public static void main(String[] args) {
		DeleteNnodesAfterMnodesOfALinkList obj = new DeleteNnodesAfterMnodesOfALinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.delete(head,2,2);
        ll.printLinkList(head);
	}
}
