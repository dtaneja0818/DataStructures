package Easy;
/*
 * SLL_018: http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class E_021_MergeTwoSortedLists {

	public ListNode mergeTwoListsOptimized(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode startNode = new ListNode(-1);
		ListNode result = startNode;
		ListNode ptr = startNode;
		ListNode newNode = null;

		boolean specialCase = false;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(a != null && b != null){
				if(a.val == b.val){
					newNode = new ListNode(a.val);
					specialCase = true;
				}else if(a.val < b.val){
					newNode = new ListNode(a.val);
					a = a.next;
				}else if(b.val < a.val){
					newNode = new ListNode(b.val);
					b = b.next;
				}
				ptr.next = newNode;
				ptr = ptr.next;
				if(specialCase){
					ListNode newNode2 = new ListNode(a.val);
					ptr.next = newNode2;
					ptr = ptr.next;
					a = a.next;
					b = b.next;
					specialCase = false;
				}
			}
			if(a != null){
				ptr.next = a;
			}else if(b != null){
				ptr.next = b;
			}
		}
		return result.next;
	}
	public static void main(String[] args) {
		E_021_MergeTwoSortedLists obj = new E_021_MergeTwoSortedLists();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		ListNode head = obj.mergeTwoLists(head1,head2);
		System.out.println("Merged List is:");
		LinkListOperations ll = new LinkListOperations();
		ll.printLinkList(head);
		head = obj.mergeTwoListsOptimized(head1,head2);
		System.out.println("Merged List optimized is:");
		ll.printLinkList(head);
	}
}