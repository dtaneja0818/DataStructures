package LinkList;

public class SwapNodesInLinkedListWithoutSwappingData {

	public LinkListNode swapNodes(LinkListNode head, int x, int y){
		if(head == null || head.next == null){
			return;
		}
		LinkListNode ptr1 =  head;
		LinkListNode ptr2 = head;
		
		while(ptr1.next != null && ptr1.next.data != x){
			ptr1 = ptr1.next;
		}
		while(ptr2.next != null && ptr2.next.data != y) {
			ptr2 = ptr2.next;
		}
		 
	}
	
	public static void main(String[] args) {
		SwapNodesInLinkedListWithoutSwappingData obj = new SwapNodesInLinkedListWithoutSwappingData();
		LinkListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.swap(head,3, 4);
		ll.printLinkList(head);
	}

}
