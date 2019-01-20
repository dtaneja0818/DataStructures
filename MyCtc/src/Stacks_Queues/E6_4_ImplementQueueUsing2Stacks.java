package Stacks_Queues;
import java.util.Stack;
/*
 * 3.5	Implement a MyQueue class which implements a queue using two stacks
 */
 
public class E6_4_ImplementQueueUsing2Stacks<T> {
	Stack s1,s2; 
		
	public E6_4_ImplementQueueUsing2Stacks(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	private void enQueue(T x){
		System.out.println("enQueue:"+x);
		s1.push(x);
	}
	
	private T deQueue() throws Exception{
		if(s1.isEmpty()) throw new Exception("UnderFlow");
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		
		T x = (T) s2.pop();
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
		return x;
	}
	
	public static void main(String[] args) {
		E6_4_ImplementQueueUsing2Stacks<Integer> obj = new E6_4_ImplementQueueUsing2Stacks<Integer>();
		try{
			obj.enQueue(1);
			obj.enQueue(2);
			obj.enQueue(3);
			System.out.println("deQueue:"+(Integer)obj.deQueue());
			obj.enQueue(4);
			System.out.println("deQueue:"+(Integer)obj.deQueue());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("hello");
		}
	}

}
