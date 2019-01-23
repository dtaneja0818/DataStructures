package Medium;
import Easy.ListNode;
/*
 * http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 * https://leetcode.com/problems/sort-list/
 * SLL_034: http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class M_148_SortList {

	public static ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		int size = 0;
		ListNode temp = head;
		// Finding list size
		while(temp != null){
			size++;
			temp = temp.next;
		}
		int mid = size/2;
		ListNode left = head;
		ListNode right = null;
		int  i = 0;
		temp = head;
		// Break list in 2 parts left and right
		while(temp != null){
			i++;
			ListNode next = temp.next;
			if(i == mid){
				temp.next = null;
				right = next;
			}
			temp = next;
		}
		ListNode h1 = sortList(left);
		ListNode h2 = sortList(right);
		ListNode merged = merge(h1,h2);
		return merged;
	}

	public static ListNode merge(ListNode leftList, ListNode rightList){

		ListNode newList = new ListNode(100);
		ListNode newPtr = newList;
		while(leftList != null || rightList != null){
			if(leftList == null){
				newPtr.next = new ListNode(rightList.val);
				rightList = rightList.next;
				newPtr = newPtr.next;
			}
			else if(rightList == null){
				newPtr.next = new ListNode(leftList.val);
				leftList = leftList.next;
				newPtr = newPtr.next;
			}
			else{
				if(leftList.val < rightList.val){
					newPtr.next = new ListNode(leftList.val);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.val > rightList.val){
					newPtr.next = new ListNode(rightList.val);
					rightList = rightList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.val == rightList.val){
					newPtr.next = new ListNode(rightList.val);
					rightList = rightList.next;
					newPtr = newPtr.next;
					newPtr.next = new ListNode(leftList.val);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
			}
		}
		return newList.next;
	}

	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
	
	public static void main(String[] args) {	
		M_148_SortList obj = new M_148_SortList();
		
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
 
		ListNode n4 = new ListNode(3);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println("Before");
 		printList(n1);
		n1 = obj.sortList(n1);
 		System.out.println("After");
		printList(n1);
	}

}
