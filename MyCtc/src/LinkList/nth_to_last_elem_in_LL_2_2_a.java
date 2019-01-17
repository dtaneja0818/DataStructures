/*Nth to last elem in LL is len-n+1 from front*/
package LinkList;

import java.util.Scanner;

public class nth_to_last_elem_in_LL_2_2_a {
		static linklistOpeartions ll=new linklistOpeartions(); 
		public static void main(String[] args) {
			Node head=null;
			int n = 0;
			System.out.println("enter the elem u want from last");
			Scanner in=new Scanner(System.in);
			int i=in.nextInt();
			head=ll.pushAtEnd(2,head);
			head=ll.pushAtEnd(3,head);
			head=ll.pushAtEnd(4,head);
			head=ll.pushAtEnd(5,head);
			ll.print(head);
			Node ptr=head;
			while(ptr!=null){
				n++;
				ptr=ptr.next;
			}
			int newn=n-i+1;
			int res=nthToLastElm(head,newn);
			System.out.println(i+" elem from last is:"+res);
		}
		private static int nthToLastElm(Node head,int pos) {
			int n=1;
			if(pos==1){
				return head.data;
			}
			Node ptr=head;
			while(n!=pos){
				ptr=ptr.next;
				n++;
			}
			return ptr.data;			
		}

}


