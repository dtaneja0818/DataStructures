/*First create 2 LL and traverse one by one and add node1 of LL1 to node1 of LL2.
 * if the SUM IS >10 then add the carry to next number and then push the resultant into the list
 * it will fail for 999 and 999 and also num of digits shud be same for both
 * */
package LinkList;

public class Add_two_LL_2_4 {

	static linklistOpeartions ll=new linklistOpeartions(); 
	public static void main(String[] args) {
		Node firstHead=null;
		firstHead=ll.pushAtBegin(5,firstHead);
		firstHead=ll.pushAtBegin(2,firstHead);
		firstHead=ll.pushAtBegin(2,firstHead);
		ll.print(firstHead);
		Node secondHead=null;
		secondHead=ll.pushAtBegin(2,secondHead);
		secondHead=ll.pushAtBegin(9,secondHead);
		secondHead=ll.pushAtBegin(5,secondHead);
		ll.print(secondHead);
		addLL(firstHead,secondHead);
	}
	private static void addLL(Node firstHead, Node secondHead) {
		int data=0,carry=0;
		Node resHead=null;
		while(firstHead!=null){
			data=firstHead.data+secondHead.data;//System.out.println(data);
			data=data+carry;
			if(data>=10){
				carry=1;data=data%10;
			}
			resHead=ll.pushAtEnd(data,resHead);
			firstHead=firstHead.next;
			secondHead=secondHead.next;
		}System.out.println("out");
		ll.print(resHead);
		
	}

}
