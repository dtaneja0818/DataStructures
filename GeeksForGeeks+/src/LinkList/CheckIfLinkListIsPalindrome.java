//http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
package LinkList;

public class CheckIfLinkListIsPalindrome {

	public boolean isPalindrome(LinkListNode head){
		
		return false;
	}
	
	public static void main(String[] args) {
		CheckIfLinkListIsPalindrome obj = new CheckIfLinkListIsPalindrome();
		LinkListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		System.out.println(obj.isPalindrome(head));
	}
}
