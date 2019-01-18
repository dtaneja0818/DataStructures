package Easy;
/*
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class _019_RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return head;
		ListNode ptr = head;
		int len = 1,i = 1;
		while(ptr.next != null){
			ptr = ptr.next;
			len++;
		}
		ptr = head;
		int x = len-n+1;
		if(x == 1){
			head = head.next;
			return head;
		}
		while(i < x-1){
			ptr = ptr.next;
			i++;
		}
		ptr.next = ptr.next.next;
		return head;
	}

	public static void main(String[] args) {

	}
}
