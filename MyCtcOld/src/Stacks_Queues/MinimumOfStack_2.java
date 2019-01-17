package Stacks_Queues;
import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */
 
public class MinimumOfStack_2 extends Stack<Integer> {
	
	Stack<Integer> stack;
	public MinimumOfStack_2(){
		stack = new Stack<Integer>();
	}
	
	public void push(int x){
		if(x <= getMin()){
			stack.push(x);
		}
		super.push(x);
	}
	
	public Integer pop(){
		Integer temp = super.pop();
		if(temp.equals(getMin())){
			stack.pop();
		}
		return temp;
	} 
	
	public Integer getMin(){
		if(stack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return stack.peek();
		}
	}
	
	public static void main(String[] args) {
		MinimumOfStack_2 obj = new MinimumOfStack_2();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
	}

}
