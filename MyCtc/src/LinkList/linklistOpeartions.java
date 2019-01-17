package LinkList;

public class linklistOpeartions {
	//Below function pushes node at the end of list with mentioned data and returns the modified head pointer
	public static Node pushAtEnd(int data,Node head){
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
	//Below function pushes node at the end of list with mentioned data and returns the modified head pointer
		public static Node pushAtBegin(int data,Node head){
			Node temp=new Node(data);
				temp.next=head;
				head=temp;
				return head;			
		}
//Below function deletes a node at a given addr and returns the modified head pointer
	public static Node deleteAddr(Node temp,Node head){
		if(temp==head){
			head=head.next;
			return head;
		}
		Node ptr=head;
		Node preptr=null;
		while(ptr!=temp){
			preptr=ptr;
			ptr=ptr.next;
		}
		preptr.next=ptr.next;
		return head;
	}
	//Below function deletes a node at a given pos and returns the modified head pointer
	public static Node deletePos(int pos,Node head){
		int n=1;
		if(pos==1){
			head=head.next;
			return head;
		}
		Node ptr=head;
		Node preptr=null;
		while(n!=pos){
			preptr=ptr;
			ptr=ptr.next;
			n++;
		}
		preptr.next=ptr.next;
		return head;
	}
	//Below function prints the link list
	public static void print(Node head){
		Node ptr=head;//System.out.println("got in print");
		while(ptr!=null){
			System.out.print(ptr.data+"->");
			ptr=ptr.next;
		}
		System.out.println();
	}
}
