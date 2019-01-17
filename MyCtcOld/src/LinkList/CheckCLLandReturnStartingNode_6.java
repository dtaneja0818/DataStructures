package LinkList;

/*
 * 2.6	Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * Our algorithm is derived directly from parts 1,2 and 3.
 * 1. Create two pointers, FastPointer and SlowPointer.
 * 2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
 * 3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer
 * 4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point
 */
public class CheckCLLandReturnStartingNode_6 {

	private ListNode createCll(ListNode head){
		ListNode ptr = head;
		if(ptr == null || ptr.next == null) return head;
		while(ptr.next != null) ptr = ptr.next;
		ptr.next = head.next.next;
		return head;
	}
	
	private ListNode checkCll(ListNode head){
		ListNode current = head;
		ListNode runner = head;
		if(current == null || current.next == null) return head;

		while(current != null || runner != null){
			current = current.next;
			runner = runner.next.next;
			if(current == runner) break;
		}
		
		if(current == null || runner == null){
		 	System.out.println("No Loop");
		 	return null;
		}
		current = head;
		while(current != runner){
			current = current.next;
			runner = runner.next;
		}
		return runner;
	}
	
	public static void main(String[] args) {
		CheckCLLandReturnStartingNode_6 obj = new CheckCLLandReturnStartingNode_6();
		// create a linked list
 		ListNode head = LinkListOperations.createLinkList();
 		System.out.println("List is:");
 		LinkListOperations.printLinkList(head);
 		head = obj.createCll(head);
 		ListNode circularBeginNode = obj.checkCll(head);
 		System.out.println("circularBeginNode is:"+circularBeginNode.data);
	}

}
