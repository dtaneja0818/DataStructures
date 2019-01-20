package LinkList;
/*
 * 2.4 Write code to partition a linked list around a value x, such that all nodes less than x	
 * come before alt nodes greater than or equal to x
 */
public class E6_4_PartitionLinkListAroundNodeX {

	private ListNode partitionApproach1(ListNode head, int x){
		ListNode ptr1 = head, ptr2 = head, ptr3 = head, temp = head, prev = head, ptr4 = head;
		int flag = 0;

		while(ptr2.data != x)
			ptr2 = ptr2.next;
		if(ptr2.next == null){
			flag = 1;
		}else{
			ptr4 = ptr2.next;
		}
		ptr3 = ptr2;
		while(ptr1 != ptr2){

			if(ptr1.data > ptr2.data){
				temp = ptr1;
				ptr1 = ptr1.next;
				if(head == temp){
					//System.out.println("in corner case");
					head = ptr1;
				}
				if(flag == 1){
					ptr3.next = temp;
					temp.next = null;
				}else{
					temp.next = ptr4;
					ptr3.next = temp;
				}
				ptr3 = ptr3.next;
				if(head == ptr1) prev = head;
				else	prev.next = ptr1;
			}
			else{
				prev = ptr1;
				ptr1 = ptr1.next;
			}
		}
		System.out.println("After moving larger to right side");
		ListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.println();
		if(flag == 0){
			while(ptr4 != null){
				if(ptr4.data < ptr2.data){
					temp = ptr4;
					ptr4 = ptr4.next;
					ptr3.next = ptr4;
					temp.next = ptr2;
					if(head == ptr2){
						head = temp;
						prev = temp;
					}else{
						prev.next = temp;
						prev = prev.next;
					}
				}else{
					ptr4 = ptr4.next;
					ptr3 = ptr3.next;
				}
			}
		}
		return head;
	}
	public static void main(String[] args) {
		E6_4_PartitionLinkListAroundNodeX obj = new E6_4_PartitionLinkListAroundNodeX();
		LinkListOperations list = new LinkListOperations();
		// create a linked list
		ListNode head = list.createLinkList();
		list.printLinkList(head);
		head = obj.partitionApproach1(head,2);
		list.printLinkList(head);
	}

}
