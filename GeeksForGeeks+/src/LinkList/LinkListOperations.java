package LinkList;
import java.util.*;

public class LinkListOperations{
	
	public static void main(String[] args){
		LinkListNode head = null;
		printLinkList(head);
		head = addNodeAtBegining(head,4);
		printLinkList(head);
		head = addNodeAtBegining(head,3);
		printLinkList(head);
		head = addNodeAtBegining(head,2);
		printLinkList(head);
		head = addNodeAtBegining(head,1);
		printLinkList(head);
		head = addNodeAtEnd(head,5);
		printLinkList(head);
		head = addNodeAtEnd(head,6);
		printLinkList(head);
		head = addNodeAtNthPosition(head,7,7);
		printLinkList(head);
		head = deleteNodeAtNthPosition(head,7);
		printLinkListUsingRecursion(head);
	}
	
	public static LinkListNode createLinkList(){
		LinkListNode head = null;
		System.out.println("Enter number of elements u wanna have in your linklist.");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int input;
		System.out.println("Enter "+n+" elements.");
		for(int i = 0;i < n;i++){
			in = new Scanner(System.in);
			input = in.nextInt();
			head = addNodeAtEnd(head,input);
		}
		return head;
	}

	public static LinkListNode addNodeAtBegining(LinkListNode head, int data){
		LinkListNode newNode = new LinkListNode(data);
		LinkListNode ptr = head;
		ptr.next = head;
		head = ptr;
		return head;
	}
	
	public static LinkListNode addNodeAtEnd(LinkListNode head, int data){
		LinkListNode newNode = new LinkListNode(data);
		if(head == null){
			return newNode;
		}
		LinkListNode ptr = head;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = newNode;
		return head;
	}
	
	//inserting nodes on a one based index LL
	public static LinkListNode addNodeAtNthPosition(LinkListNode head, int data, int pos) {
		
		LinkListNode newNode = new LinkListNode(data);
		LinkListNode ptr = head;
		if(head == null && pos == 0){
			return newNode;
		}else if(head == null && pos > 0){
			System.out.println("Enter a valid position");
			return head;
		}
		int lLlength = 1;
		while(ptr.next != null){
			if(pos == lLlength+1){
				newNode.next = ptr.next;
				ptr.next = newNode;
				return head;
			}
			ptr = ptr.next;
			lLlength++;
		}
		if(pos > lLlength){
			System.out.println("Enter a valid position");
			return head;
		}else{ // will come here if pos == 1
			newNode.next = head;
			head = newNode;
			return head;
		}
	}

	public static LinkListNode deleteNodeFromEnd(LinkListNode head){
		 LinkListNode ptr = head;
		 
		 if(head == null) return head;
		 if(ptr.next == null) return null;
		 while(ptr.next.next != null) ptr = ptr.next;		 
		 ptr.next = null;
		 return head;
	}
	
	public static LinkListNode deleteNodeFromBeginning(LinkListNode head){
		LinkListNode ptr = head;
		// no node
		if(head == null) return head;
		//only 1 node
		if(ptr.next == null) return null;
		
		head = ptr.next;
		return head;
	}
	
	public static LinkListNode deleteNodeAtNthPosition(LinkListNode head,int pos){
		LinkListNode ptr = head;
		int lLength = 1;
		if(head == null) return head;
		while(ptr.next != null){
			if(pos == lLength+1){
				ptr.next = ptr.next.next;
			}
			lLength++;
			ptr = ptr.next;
		}
		
		if(pos > lLength) {
			System.out.println("Enter a valid position");
			return head;
		}else{ // pos = 1 and only 1 node present
			return null;
		}
	}
	
	//http://geeksquiz.com/linked-list-set-3-deleting-node
	public static LinkListNode deleteKey(int data){
		LinkListNode ptr = head;
		// no node present
		if(head == null) return head;
		 // If head node itself holds the key to be deleted
		if(head.data == data) return null;
		
		while(ptr.next != null){			
			if(data == ptr.next.data){
				ptr.next = ptr.next.next;
				return head;
			}
			ptr = ptr.next;
		}
		System.out.println("Node not found);
	}
	
	public static LinkListNode mergeLL(LinkListNode a, LinkListNode b){
		LinkListNode ptr = head;
	}
	
	public static int getLinkListLength(LinkListNode head){
		LinkListNode ptr = head;
		return 0;
	}
	
	public static void printLinkList(LinkListNode head){
		LinkListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static void printLinkListUsingRecursion(LinkListNode head){
		LinkListNode ptr = head;
		
	}
	
	public static LinkListNode reverseLinkList(LinkListNode currentPtr){
		LinkListNode ptr = head;
		
	}
	
	public static int getLinkListLength(LinkListNode head){
		LinkListNode ptr = head;
		
	}
	
	public static int getLinkListLengthUsingRecursion(LinkListNode head){
		LinkListNode ptr = head;
		
	}
	
	public static LinkListNode createCLL(){
		LinkListNode ptr = head;
	}
	
	public static LinkListNode createFullCLL(){
		LinkListNode ptr = head;
	}
	
	public static void printCLL(LinkListNode head){
		LinkListNode ptr = head;
	}
}
