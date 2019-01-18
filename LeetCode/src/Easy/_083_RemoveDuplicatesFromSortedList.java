package Easy;
/*
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class _083_RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		int flag = 0;
		ListNode current = head;
		ListNode runner = head.next;
		while(runner != null){
			while(runner.val == current.val){
				runner = runner.next;
				flag = 1;
				if(runner == null) break;
			}
			
			if(flag == 1){
				current.next = runner;
				if(runner != null){
					current = current.next;
					runner = runner.next;
				}
				flag = 0;
			}
			else{
				current = current.next;
				runner = runner.next;
			}
		}
		return head;
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
		_083_RemoveDuplicatesFromSortedList obj = new _083_RemoveDuplicatesFromSortedList();
		ListNode head1 = null;
		ListNode temp[] = new ListNode[6];

		for(int i=0;i<6;i++)	temp[i] = new ListNode(0);
		// 1->1->2->null

		temp[0].val = 1;
		temp[0].next = temp[1];
		temp[1].val = 1;
		temp[1].next = temp[2];
		temp[2].val = 2;
		temp[2].next = temp[3];
		temp[3].val = 1;
		temp[3].next = temp[4];
		temp[4].val = 1;
		temp[4].next = temp[5];
		temp[5].val = 1;
		head1 = temp[0];
		obj.printLinkList(head1);
		ListNode result = obj.deleteDuplicates(head1);
		obj.printLinkList(result);
	}
}
