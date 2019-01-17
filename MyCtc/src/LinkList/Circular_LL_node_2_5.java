/*First I have created at circular link list then create 2 pointers fast and slow fst ptr jumps
 * one node each time whereas slowptr moves one by one when both the ptrs are together 
 * move one of the pts to head and then move both the pts one by one wherever they meet again
 * is the point of cycle
 * */
package LinkList;

import java.util.Scanner;

public class Circular_LL_node_2_5 {

		static linklistOpeartions ll=new linklistOpeartions(); 
		public static void main(String[] args) {
			Node head=null;
			head=push(2,head);
			head=push(3,head);
			head=push(4,head);
			head=pushCircular(5,head);
			int data=catchCircularNode(head);
			//ll.print(head);
			System.out.println("Loop exists at: "+data);

	}
		private static int catchCircularNode(Node head) {//.,System.out.println("got in");
			Node fastPtr=head.next.next;
			Node slowPtr=head.next;
			while(fastPtr!=slowPtr){
				fastPtr=fastPtr.next.next;//System.out.println("fastPtr data is: "+fastPtr.data);
				slowPtr=slowPtr.next;//System.out.println("slowPtr data is: "+slowPtr.data);
			}
			//System.out.println(slowPtr.data);
			fastPtr=head;
			while(fastPtr!=slowPtr){
				fastPtr=fastPtr.next;
				slowPtr=slowPtr.next;
			}
			return fastPtr.data;
		}
		private static Node pushCircular(int data, Node head) {
			Node temp=new Node(data);
			Node ptr=head;
			while(ptr.next!=null){
				ptr=ptr.next;
			}
			ptr.next=temp;
			temp.next=head.next;
			return head;
		}
		public static Node push(int data,Node head){
			Node temp=new Node(data);
			if(head==null){
				temp.next=head;
				head=temp;
				return head;
			}
			Node ptr=head;
			while(ptr.next!=null){
				ptr=ptr.next;
			}
			ptr.next=temp;
			return head;
		}

}
