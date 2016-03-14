package LinkList;

public class MergeTwoSortedLinkList {

	public LinkListNode merge(LinkListNode head1, LinkListNode head2) {
		LinkListNode result = null;
		if(head1 == null && head2 == null){
			return null;
		}else if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}else{
			while(head1 != null && head2 != null){
				if(head1.data == head2.data){
					result = LinkListOperations.addNodeAtEnd(result,head1.data);
					head1 = head1.next;
					head2 = head2.next;
				}else if(head1.data < head2.data){
					result = LinkListOperations.addNodeAtEnd(result,head1.data);
					head1 = head1.next;
				}else{
					 result = LinkListOperations.addNodeAtEnd(result,head2.data);
					 head2 = head2.next;
				}
				
			}
			if(head1 != null){
				LinkListOperations.mergeLL(result, head1);
			}else if(head2 != null){
				LinkListOperations.mergeLL(result, head2);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLinkList obj = new MergeTwoSortedLinkList();
		LinkListNode head1 = null;
		LinkListNode head2 = null;
		LinkListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        head = obj.merge(head1,head2);
        System.out.println("Merged List is:");
        ll.printLinkList(head);
	}
}
