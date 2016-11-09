package LinkList;

/*
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 */
 
public class MergeTwoSortedLinkList {

	public ListNode merge(ListNode a, ListNode b){
		ListNode result = null;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(a != null && b != null){
				if(a.data == b.data){
					result = LinkListOperations.addNodeAtEnd(result,a.data);
					a = a.next;
					b = b.next;
				}else if(a.data < b.data){
					result = LinkListOperations.addNodeAtEnd(result,a.data);
					a = a.next;
				}else{
					result = LinkListOperations.addNodeAtEnd(result,b.data);
					b = b.next;
				}
			}
			if(a != null){
				while(a != null){
					result = LinkListOperations.addNodeAtEnd(result,a.data);
					a = a.next;
				}
			}else if(b != null){
				while(b != null){
					result = LinkListOperations.addNodeAtEnd(result,b.data);
					b = b.next;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLinkList obj = new MergeTwoSortedLinkList();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        head = obj.merge(head1,head2);
        System.out.println("Merged List is:");
        ll.printLinkList(head);
	}
}
