package LinkList;
/*
 * 2.5
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
 * of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Procedure:
 * Q: 1234 + 123
 * Ans:
 * 1.	padlist list1 = 1234,list2 = 0123
 * 2.	reverse list1 = 4321, list2 = 3210
 * 3.	Add reverses and then again reverse the resultant link list

 */
public class Add2LinkListAndReturnResultAsLinkList_5 {

	private ListNode addLinkList(ListNode head1, ListNode head2){
 		LinkListOperations.printLinkList(head1);
 		LinkListOperations.printLinkList(head2);
		int value = 0, carry = 0, n = 0;
		ListNode ptr1 = head1;
		ListNode ptr2 = head2;
		ListNode result = null;
		while(ptr1 != null){
			value = 0;
			if(carry != 0){
				value = ptr1.data + ptr2.data + carry;
				carry = 0;
			}
			else{
				value = ptr1.data + ptr2.data;
			}
			System.out.println("value is:"+value);
			if(value >= 10) carry = 1;
			n = value%10;
			result = LinkListOperations.addListNodeAtEnd(result,n);
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		System.out.println("carry is:"+carry);
		if(carry != 0){
			result = LinkListOperations.addListNodeAtEnd(result,carry);
		}
		return result;
	}

	private ListNode listFraming(ListNode head1, ListNode head2){
		int len1 = LinkListOperations.length(head1);
		int len2 = LinkListOperations.length(head2);
		int diff = Math.abs(len1 - len2);
		ListNode result;
		if(len1 < len2){
			while(diff > 0){
				head1 = LinkListOperations.addListNodeAtBegining(head1,0);
				diff--;
			}
		}else{
			while(diff > 0){
				head2 = LinkListOperations.addListNodeAtBegining(head2,0);
				diff--;
			}
		}
		head1 = LinkListOperations.reverseList(head1);
		head2 = LinkListOperations.reverseList(head2);
		result = addLinkList(head1,head2);
		result = LinkListOperations.reverseList(result);
		return result;
	}
	
	public static void main(String[] args) {
		Add2LinkListAndReturnResultAsLinkList_5 obj = new Add2LinkListAndReturnResultAsLinkList_5();
		// create a linked list
 		ListNode head1 = LinkListOperations.createLinkList();
 		ListNode head2 = LinkListOperations.createLinkList();
 		System.out.println("List1 is:");
 		LinkListOperations.printLinkList(head1);
 		System.out.println("List2 is:");
 		LinkListOperations.printLinkList(head2);
      	ListNode result = obj.listFraming(head1,head2);
      	System.out.println("result is:");
     	LinkListOperations.printLinkList(result);
	}
}
