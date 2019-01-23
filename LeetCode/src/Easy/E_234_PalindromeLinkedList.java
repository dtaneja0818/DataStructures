/* 
 * Function to check if a singly linked list is palindrome
 * SLL_022: http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
 * https://leetcode.com/problems/palindrome-linked-list/
 */
package Easy;

// use a fast and slow pointer to get the center of the list, then reverse the second list and compare two sublists. 
//The time is O(n) and space is O(1)

public class E_234_PalindromeLinkedList {

	public boolean isPalindrome(ListNode head){
		if(head == null || head.next==null)
			return true;

		//find list center
		ListNode fast = head;
		ListNode slow = head;

		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		//reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while(p1!=null && p2!=null){
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		//compare two sublists now
		ListNode p = (p2==null?p1:p2);
		ListNode q = head;
		while(p!=null){
			if(p.val != q.val)
				return false;

			p = p.next;
			q = q.next;	 
		}	 
		return true;
	}

	public static void main(String[] args) {
		E_234_PalindromeLinkedList obj = new E_234_PalindromeLinkedList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		System.out.println(obj.isPalindrome(head));
	}
}
