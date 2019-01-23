package Easy;
import java.util.Stack;

/*
 * https://oj.leetcode.com/problems/min-stack/
 */
public class E_155_SpecialStack extends Stack<Integer> {
	
	Stack s = new Stack();
	
	public void push(int x) {
		if(s.isEmpty() || x <= (int)s.peek()){
			s.push(x);
		}
		super.push(x);
	}

	public Integer pop() {
		if(super.isEmpty()) return null;
		if(super.peek().equals(s.peek())){
			s.pop();
		}
		return super.pop();
	}

	public int top() {
		return super.peek();
	}

	public Integer getMin() {
		if(s.isEmpty()) return Integer.MAX_VALUE;
		return (Integer) s.peek();
	}
	
	public static void main(String[] args) {
		E_155_SpecialStack obj = new E_155_SpecialStack();
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