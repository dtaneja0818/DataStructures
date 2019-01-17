package LinkList;

import java.util.*;

public class LinkListOperations{

    public static void main(String[] args){
        ListNode head = null;
        printLinkList(head);
        head = addListNodeAtBegining(head,4);
        printLinkList(head);
        head = addListNodeAtBegining(head,3);
        printLinkList(head);
        head = addListNodeAtBegining(head,2);
        printLinkList(head);
        head = addListNodeAtBegining(head,1);
        printLinkList(head);
        head = addListNodeAtEnd(head,5);
        printLinkList(head);
        head = addListNodeAtEnd(head,6);
        printLinkList(head);
        head = addListNodeAtNthPosition(head,7,7);
        printLinkList(head);
        head = deleteListNodeAtNthPosition(head,7);
        printLinkListUsingRecursion(head);
    }

    public static ListNode createLinkList(){
        ListNode head = null;
        System.out.println("Enter number of elements u wanna have in your linklist.");
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int input;
        System.out.println("Enter "+n+" elements.");
        for(int i = 0;i < n;i++){
            in = new Scanner(System.in);
            input = in.nextInt();
            head = addListNodeAtEnd(head,input);
        }
        return head;
    }

    public static ListNode addListNodeAtBegining(ListNode head, int data){
        ListNode newListNode = new ListNode(data);
        newListNode.next = head;
        head = newListNode;
        return head;
    }

    public static ListNode addListNodeAtEnd(ListNode head, int data){
        ListNode newListNode = new ListNode(data);
        ListNode ptr = head;
        if(head == null){
           newListNode.next = head;
           head = newListNode;
           return head;
        }
        else{
            while(ptr.next != null) ptr = ptr.next;
              ptr.next = newListNode;
              return head;
        }
    }

    //inserting ListNodes on a one based index LL
    public static ListNode addListNodeAtNthPosition(ListNode head, int data, int pos) {
        ListNode newListNode = new ListNode(data);
        ListNode ptr = head;
        int n = 1;
        while(ptr != null){
            n++;
            ptr = ptr.next;
        }
        if(pos > (n+2)){
           System.out.println("Enter a valid index");
           return head;
        }

        if(head == null){
           head = newListNode;
           return head;
        }
        ptr = head;
        for(int i = 1;i <= pos-2;i++) ptr = ptr.next;
        newListNode.next = ptr.next;     
        ptr.next = newListNode;
        return head;
    }

    public static ListNode deleteListNodeAtNthPosition(ListNode head,int pos){
        int n = 0;
        ListNode ptr = head;
        if(head == null){
            System.out.println("No element to delete");
            return head;
        }
        while(ptr.next != null){
            n++;
            ptr=ptr.next;
        }
        if(pos < n){
           System.out.println("Enter a valid index");
           return head;
        }
        if(pos == 1){
            head = ptr.next;
            return head;
        } 
        ptr = head;
        for(int i = 1;i <= pos-2;i++) ptr = ptr.next;
        ptr.next = (ptr.next).next;
        return head;
    }


    public static void printLinkList(ListNode head){
		ListNode ptr = head;
        if(head == null) System.out.println("List is empty");
        while(ptr != null){
			System.out.print(ptr.data+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}

    public static void printLinkListUsingRecursion(ListNode ptr){
        if(ptr == null){
            System.out.println();
            return;
        }
	    System.out.print(ptr.data+"->");
		printLinkListUsingRecursion(ptr.next);
    }
	
	public static int length(ListNode head){
		if(head == null) return 0;
		ListNode ptr = head;
		int n = 1;
		while(ptr.next != null){
			ptr = ptr.next;
			n++;	
		}
		return n;
	}
	
	public static ListNode reverseList(ListNode head){
        ListNode currentPtr, prevPtr, nextPtr;
        currentPtr = head;
        prevPtr = null;
        
        //below implementation covers both corner cases too i.e if head=null
        //and if there is only one node.
        while(currentPtr != null){
            nextPtr = currentPtr.next;
            currentPtr.next = prevPtr;
            prevPtr = currentPtr;
            currentPtr = nextPtr;
        }
        head = prevPtr;
        return head;
    }

    public static ListNode reverseLinkListUsingRecursion(ListNode currentPtr){
        if(currentPtr.next == null){
            ListNode head = currentPtr;
            return head;
        }
        ListNode ptr = reverseLinkListUsingRecursion(currentPtr.next); 
        ListNode nextPtr = currentPtr.next;
        nextPtr.next = currentPtr;
        currentPtr.next = null;
        return ptr;
    }

}