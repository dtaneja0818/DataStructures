//http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
package LinkList;

public class ReverseLinkedList {

	public LinkListNode reverseLL(LinkListNode head){
		LinkListNode prev = null;
		LinkListNode curr = head;
		LinkListNode next = curr.next;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public void reverseLLUsingRecursion(LinkListNode head){
		
	}
	
	public static void main(String[] args) {
			ReverseLinkedList obj = new ReverseLinkedList();
			LinkListNode head = null;
			LinkListOperations ll = new LinkListOperations();
			head = ll.createLinkList();
			ll.printLinkList(head);
			head = obj.reverseLL(head);
			ll.printLinkList(head);
	}

}
