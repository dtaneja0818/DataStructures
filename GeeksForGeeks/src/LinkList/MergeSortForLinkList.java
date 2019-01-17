package LinkList;
/*
 * http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 * http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class MergeSortForLinkList {

	public static ListNode mergeSort(ListNode head){
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
		ListNode h1 = mergeSort(left);
		ListNode h2 = mergeSort(right);
		ListNode merged = merge(h1,h2);
		return merged;
	}

	public static ListNode merge(ListNode leftList, ListNode rightList){

		ListNode newList = new ListNode(100);
		ListNode newPtr = newList;
		while(leftList != null || rightList != null){
			if(leftList == null){
				newPtr.next = new ListNode(rightList.data);
				rightList = rightList.next;
				newPtr = newPtr.next;
			}
			else if(rightList == null){
				newPtr.next = new ListNode(leftList.data);
				leftList = leftList.next;
				newPtr = newPtr.next;
			}
			else{
				if(leftList.data < rightList.data){
					newPtr.next = new ListNode(leftList.data);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.data > rightList.data){
					newPtr.next = new ListNode(rightList.data);
					rightList = rightList.next;
					newPtr = newPtr.next;
				}
				else if(leftList.data == rightList.data){
					newPtr.next = new ListNode(rightList.data);
					rightList = rightList.next;
					newPtr = newPtr.next;
					newPtr.next = new ListNode(leftList.data);
					leftList = leftList.next;
					newPtr = newPtr.next;
				}
			}
		}
		return newList.next;
	}

	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.data + " ");
			while (x.next != null) {
				System.out.print(x.next.data + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
	
	public static void main(String[] args) {	
		MergeSortForLinkList obj = new MergeSortForLinkList();
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println("Before");
 		printList(n1);
		n1 = obj.mergeSort(n1);
 		System.out.println("After");
		printList(n1);
	}

}
