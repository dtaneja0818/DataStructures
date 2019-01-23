//https://www.geeksforgeeks.org/write-a-c-function-to-detect-loop-in-a-linked-list/
package LinkList;

public class SLL_017_DetectLoopInLinkedList {

	//Time Complexity: O(n),	Auxiliary Space: O(1)
	public int isLoop(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		
		while(slow != null && fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return fast.data;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SLL_017_DetectLoopInLinkedList obj = new SLL_017_DetectLoopInLinkedList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createCLL();
		System.out.println("There is a loop at:"+obj.isLoop(head));
	}
}
