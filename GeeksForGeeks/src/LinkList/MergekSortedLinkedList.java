package LinkList;
import java.util.*;
/*
 * http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
 */
public class MergekSortedLinkedList {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;

		//PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return (a.data - b.data);
			}
		});

		//add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);//there is only first node of each list not the whole list
		}

		ListNode head = new ListNode(0);
		ListNode p = head; // serve as a pointer/cursor

		while (q.size() > 0) {
			ListNode temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;

			// takes out one elem each time and inserts the next lem in the queue, keep adding next element of each list
			if (temp.next != null){
				q.add(temp.next);
			}
			p = p.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		MergekSortedLinkedList obj = new MergekSortedLinkedList();
		LinkListOperations op = new LinkListOperations();
		ListNode list1 = op.createLinkList();
		ListNode list2 = op.createLinkList();
		ListNode list3 = op.createLinkList();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ListNode result = obj.mergeKLists(lists);	
		op.printLinkList(result);
	}
}
