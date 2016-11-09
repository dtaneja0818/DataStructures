package LinkList;
/*
 * http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
 */
 
public class InsertInaSortedCLL {

	public ListNode insertCLL(ListNode head){
		return null;
	}
	
	
	public static void main(String[] args) {
		InsertInaSortedCLL obj = new InsertInaSortedCLL();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createFullCLL();
       	ll.printCLL(head);
        head = obj.insertCLL(head);
        ll.printCLL(head);
	}
}
