package LinkList;
import java.util.*;

public class LinkListOperations{
	
	public static void main(String[] args){
		LinkListNode head = null;
		head = addNodeAtBegining(head,4);
		System.out.println("List after adding 4 at beginning");
		printLinkList(head);
		head = addNodeAtBegining(head,3);
		System.out.println("List after adding 3 at beginning");
		printLinkList(head);
		head = addNodeAtBegining(head,2);
		System.out.println("List after adding 2 at beginning");
		printLinkList(head);
		head = addNodeAtBegining(head,1);
		System.out.println("List after adding 1 at beginning");
		printLinkList(head);
		head = addNodeAtEnd(head,5);
		System.out.println("List after adding 5 at end");
		printLinkList(head);
		head = addNodeAtEnd(head,6);
		System.out.println("List after adding 6 at end");
		printLinkList(head);
		head = addNodeAtNthPosition(head,7,7);
		System.out.println("List after adding 7 at 7th position");
		printLinkList(head);
		head = deleteNodeAtNthPosition(head,7);
		System.out.println("List after deleting node at 7th position");
		printLinkList(head);
		System.out.println(getNthNode(head, 3));
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
		newNode.next = head;
		head = newNode;
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
			throw new Error("Enter a valid position head == null && pos > 0");
		}
		int length = 1;
		while(ptr != null){
			if(pos == length+1){
				newNode.next = ptr.next;
				ptr.next = newNode;
				return head;
			}
			ptr = ptr.next;
			length++;
		}
		length--;
		if(pos > length+2){
			throw new Error("Enter a valid position pos to insert: "+pos+" length:"+length);
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
		int length = 1;
		if(head == null) return head;
		while(ptr != null){
			if(pos == length+1){
				ptr.next = ptr.next.next;
				return head;
			}
			length++;
			ptr = ptr.next;
		}
		length--;
		if(pos > length) {
			System.out.println("Enter a valid position");
			return head;
		}else{ // pos = 1 and only 1 node present
			return null;
		}
	}
	
	//http://geeksquiz.com/linked-list-set-3-deleting-node
	public static LinkListNode deleteKey(LinkListNode head, int data){
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
		throw new Error("Node not found");
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
	
	public static LinkListNode reverseLinkList(LinkListNode head){
		LinkListNode ptr = head;
		return head;
	}
	
	public static int getLinkListLength(LinkListNode head){
		LinkListNode ptr = head;
		int lLength = 0;
				
		while(ptr != null){
			lLength++;
			ptr = ptr.next;
		}
		return lLength;	
	}
	
	public static int getLinkListLengthUsingRecursion(LinkListNode head){
		if(head == null){
			return 0;
		}
		return 1+getLinkListLengthUsingRecursion(head.next);
	}
	
	public static boolean findData(LinkListNode head, int data){
		LinkListNode ptr = head;
		
		while(ptr != null){
			if(ptr.data == data){
				return true;
			}
			ptr=ptr.next;
		}
		return false;
	}
	
	public static boolean findDataUsingRecursion(LinkListNode head, int data){
		if(head == null){
			return false;
		}
		if(head.data == data){
			return true;
		}		
		return findDataUsingRecursion(head.next, data);
	}
	
	//http://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
	public static int getNthNode(LinkListNode head, int idx){

		LinkListNode ptr = head;
		int nodeCount = 1;
		while(ptr != null){
			if(idx == nodeCount){
				return ptr.data;
			}
			nodeCount++;
			ptr = ptr.next;
		}		
		throw new Error("List Empty/Node not found");
	}
	
	//http://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
	//Time Complexity: O(n) where n is the length of linked list.
	public static int getNthNodeFromLast(LinkListNode head, int idx){

		LinkListNode slow = head;
		LinkListNode fast = head;
		
		int nodeCount = 0;
		if(head != null){
			while(nodeCount < idx){
				if(fast == null){
					throw new Error("index in greater then count of node");
				}
				nodeCount++;
				fast = fast.next;
			}
	
			while(fast != null){
			 	fast = fast.next;
				slow = slow.next;			
			}
			return slow.data;	
		}
		throw new Error("Not found");
	}
	
	public static LinkListNode mergeLL(LinkListNode a, LinkListNode b){
		LinkListNode ptr = a;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(ptr.next != null){
				ptr = ptr.next;
			}
			ptr.next = b;
		}
		return a;
	}
	
	public static LinkListNode createCLL(){
		LinkListNode head = createLinkList();
		LinkListNode ptr = head;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head.next.next;
		return head;
	}
	
	public static LinkListNode createFullCLL(){
		LinkListNode head = createLinkList();
		LinkListNode ptr = head;
		while(ptr.next != null){
			ptr = ptr.next;
		}
		ptr.next = head;
		return head;
	}
	
	public static void printCLL(LinkListNode head){
		LinkListNode ptr = head;
	}
}
