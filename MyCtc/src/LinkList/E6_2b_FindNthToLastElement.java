/*In this I have created 2 pointers fwdptr will move till the number specified
 * by user and once the fwdptr reaches that point then we will start the bckptr
 * Now both the pointers will start till fwdptr points to null 
 * now we can return the bckptr.data
 * */
package LinkList;

import java.util.Scanner;

public class E6_2b_FindNthToLastElement {

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
			if(i>n){
				System.out.println("LL has only "+ i +" elements");System.exit(0);
			}
			int res=nthToLastElm(head,i);
			System.out.println(i+" elem from last is:"+res);
		}
		private static int nthToLastElm(Node head,int pos) {
			Node bckptr=null;
			Node fwdptr=head;
			while(pos!=0){
				fwdptr=fwdptr.next;
				pos--;
			}
			bckptr=head;
			while(fwdptr!=null){
				fwdptr=fwdptr.next;
				bckptr=bckptr.next;
			}
			return bckptr.data;			
		}
}


