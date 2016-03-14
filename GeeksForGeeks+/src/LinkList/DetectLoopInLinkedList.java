//http://www.geeksforgeeks.org/write-a-c-function-to-detect-loop-in-a-linked-list/
package LinkList;

public class DetectLoopInLinkedList {

	//Time Complexity: O(n),	Auxiliary Space: O(1)
	public int isLoop(LinkListNode head){
		LinkListNode fast = head;
		LinkListNode slow = head;
		
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
		DetectLoopInLinkedList obj = new DetectLoopInLinkedList();
		LinkListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createCLL();
		System.out.println("There is a loop at:"+obj.isLoop(head));
	}
}
