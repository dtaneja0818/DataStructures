/*In remove duplicate method first i have created an outer ptr and and inner ptr for LL
 * The outer ptr will fix its position for 1st elm and then we will move the inner ptr one by one
 * and match the data with the outer ptr if they are equal we will delete the pos of inner ptr by calling delete(pos)
 * and also now we have to decr the pos bcoz 1 elem has been deleted.
 * Always the inner ptr has to be reset to outer.next once outr ptr has been incr
 */
package LinkList;
import java.util.*;
public class E6_1b_RemoveDuplicatesFrmUnsortedLL {
	static linklistOpeartions ll=new linklistOpeartions(); 
	public static void main(String[] args) {
		Node head=null;
		head=ll.pushAtEnd(2,head);
		head=ll.pushAtEnd(2,head);
		head=ll.pushAtEnd(2,head);
		head=ll.pushAtEnd(2,head);
		ll.print(head);
		removeDuplicates(head);
		ll.print(head);
	}
	private static void removeDuplicates(Node head) {
		Node temp=null;
		int pos=2;
		Node outptr=head;
		Node inptr=head.next;
		while(outptr.next!=null){
			while(inptr!=null){
				if(inptr.data==outptr.data){
					temp=inptr;
					inptr=inptr.next;
					head=ll.deleteAddr(temp,head);
				}
				else{
					inptr=inptr.next;
				}
			}
			if(outptr.next!=null){
				outptr=outptr.next;
				if(outptr.next!=null){
					inptr=outptr.next;
				}
			}
		}
	}
}
