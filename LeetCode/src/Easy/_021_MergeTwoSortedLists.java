package Easy;
/*
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class _021_MergeTwoSortedLists {

	 public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode result = null;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(a != null && b != null){
				if(a.val == b.val){
					result = addNodeAtEnd(result,a.val);
					result = addNodeAtEnd(result,a.val);
					a = a.next;
					b = b.next;
				}else if(a.val < b.val){
					result = addNodeAtEnd(result,a.val);
					a = a.next;
				}else{
					result = addNodeAtEnd(result,b.val);
					b = b.next;
				}
			}
			if(a != null){
				while(a != null){
					result = addNodeAtEnd(result,a.val);
					a = a.next;
				}
			}else if(b != null){
				while(b != null){
					result = addNodeAtEnd(result,b.val);
					b = b.next;
				}
			}
		}
		return result;
    }
    
    public ListNode addNodeAtEnd(ListNode head, int data){
		ListNode newNode = new ListNode(data);
		ListNode ptr = head;
		if(head == null){
			newNode.next = head;
			head = newNode;
			return head;
		}
		else{
			while(ptr.next != null) ptr = ptr.next;
			ptr.next = newNode;
			return head;
		}
	}
    
    public void printLinkList(ListNode head){
		ListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.val+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*IntersectionOfTwoLinkedLists_160 obj = new IntersectionOfTwoLinkedLists_160();
		ListNode head1 = null, head2 = null;
		ListNode temp[] = new ListNode[7];

		for(int i=0;i<7;i++)	temp[i] = new ListNode(0);
		// 4->6->7->1->null
		// 9->3->5->7
		temp[0].val = 4;
		temp[0].next = temp[1];
		temp[1].val = 6;
		temp[1].next = temp[2];
		temp[2].val = 7;
		temp[2].next = temp[3];
		temp[3].val = 1;
		temp[3].next = null;
		temp[4].val = 9;
		temp[4].next = temp[5];
		temp[5].val = 3;
		temp[5].next = temp[6];
		temp[6].val = 5;
		//temp[6].next = temp[2];

		head1 = temp[0];
		head2 = temp[4];
		ListNode result = obj.getIntersectionNode(head1,head2);
		if(result != null)System.out.println("merge point is at:"+result.val);*/
	}
}
