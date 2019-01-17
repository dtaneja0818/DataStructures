package Stacks_Queues;
import java.util.Stack;
/*
 * 3.6
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek, and isEmpty
 * 
 * Here we have taken an additional stack and we check peek of that elem with olderstack popped elem if popped elem is larger than push in 
 * newstack otherwise push all the elem from newer stack to older stack and follow procedure again.
 * Below algorithm is 0(N 2 ) time and 0(N) spac
 */
public class SortStackInDescendingOrder_6 {

	private Stack sort(Stack s){
		if(s.isEmpty() || s.size() == 1) return s;
		
		Stack tempStack = new Stack();
		int temp;
		while(!s.isEmpty()){
			temp = (int)s.pop();
			if(tempStack.isEmpty()) tempStack.push(temp);
			else{
				while(!(temp >= (int)tempStack.peek())){
						s.push(tempStack.pop());
						if(tempStack.isEmpty()) break;	
				}	
				tempStack.push(temp);
			}
		}
		return tempStack;
	}
	
	public static void main(String[] args) {
		SortStackInDescendingOrder_6 obj = new SortStackInDescendingOrder_6();
		Stack s = new Stack();
		s.push(-4);
		s.push(0);
		s.push(-3);
		s.push(10);
		s.push(100);
		s = obj.sort(s);
		while(!s.isEmpty()){
			int temp = (int)s.pop();
			System.out.println(temp);
		}
	}

}
