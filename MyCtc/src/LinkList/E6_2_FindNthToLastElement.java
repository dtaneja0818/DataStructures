package LinkList;
/*
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 */
 
class Wrapper{
	public int value = -1;
}

public class E6_2_FindNthToLastElement {
	/*
	 * We described earlier that the issue was that we couldn't simultaneously return a counter
	 * and an index. If we wrap the counter value with simple class (or even a single element
	 * array), we can mimic passing by reference
	 * recursive solutions takes 0(n) space due to the recursive calls.
	*/
	private ListNode nthToLastElemApproach1(ListNode head, int k, Wrapper i){
		if(head == null) return null;
		ListNode node = nthToLastElemApproach1(head.next, k,i);
		i.value = i.value+1;
		if(i.value == k) return head;
		return node;
	}
	/*	A more optimal, but less straightforward, solution is to implement this iteratively. We can
	use two pointers, pi and p2. We place them k nodes apart in the linked list by putting p1
	at the beginning and moving p2 k nodes into the list. Then, when we move them at the
	same pace, p2 will hit the end of the linked list after LENGTH - k steps. At that point, pi
	will be LENGTH - k nodes into the list, or k nodes from the end.
	This algorithm takes 0(n) time and 0(1) space.
	*/
	private ListNode nthToLastElemApproach2(ListNode head, int k){
		if(head == null) return head;
		int len = 1;
		ListNode lengthPtr = head;
		while(lengthPtr != null){
			lengthPtr = lengthPtr.next;
			len++;
		}
		if(k > len){
			System.out.println("Enter valid index");
			return null;
		}
		ListNode current = head;
		ListNode runner = head;
		while(k > 0){ 
			runner = runner.next;
			k--;
		}
		while(runner.next != null){
			runner = runner.next;
			current = current.next;
		}
		return current;
	}
	
	public static void main(String[] args) {
		E6_2_FindNthToLastElement obj = new E6_2_FindNthToLastElement();
		LinkListOperations list = new LinkListOperations();
 		// create a linked list
 		ListNode head = list.createLinkList();
 		list.printLinkList(head);
      	ListNode result = obj.nthToLastElemApproach1(head,1,new Wrapper());
     	System.out.println(result.data);
     	result = obj.nthToLastElemApproach2(head,1);
     	System.out.println(result.data);
	}

}
