package LinkList;
import java.util.*;
/*
 * 2.7 Implement a function to check if a linked list is a palindrome
 * Here we are putting half elements in the stack and comparing them with the rest half of the link list if they are same it means
 * it is palindrome.
 */

public class E6_6_CheckIfaLinkListIsPalindrome {

	private boolean isPalindrome(ListNode head){
		ListNode ptr = head;
		int n = 1;
		int len = LinkListOperations.length(head);
		Stack stack = new Stack();
		while(n <= len/2){
			stack.push(ptr.data);
			ptr = ptr.next;
			n++;
		}
		
		if(len%2 != 0) ptr = ptr.next;
		while(ptr != null){
			if(ptr.data != (Integer)stack.pop()) return false;
			ptr = ptr.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		E6_6_CheckIfaLinkListIsPalindrome obj = new E6_6_CheckIfaLinkListIsPalindrome();
		// create a linked list
 		ListNode head = LinkListOperations.createLinkList();
 		System.out.println("List is:");
 		LinkListOperations.printLinkList(head);
 		boolean result = obj.isPalindrome(head);
 		System.out.println("ListList is palindrome:"+result);
	}

}
