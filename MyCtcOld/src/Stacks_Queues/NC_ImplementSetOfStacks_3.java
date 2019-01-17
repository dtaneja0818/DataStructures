package Stacks_Queues;

public class NC_ImplementSetOfStacks_3 {

	/*ArrayList<Stack> list = new ArrayList<Stack>();
	private int capacity;
	
	public ImplementSetOfStacks_NC_3(int capacity) { 
		this.capacity = capacity; 
	}
	
	private void push(int x){
		Stack last = getLastStack();
		if(last != null || !last.isFull()){
			last.push(x);
		}
		else{
			Stack stack = new Stack(capacity);
			stack.push(x);
			list.add(stack);
		}
	}
	
	private int pop(){
		Stack last = getLastStack();
		int x = last.pop();
		if(last.size() == 0) list.remove(list.size()-1);
		return x;
	}
	
	private Stack getLastStack(){
		if(list.size() == 0) return null;
		return list.get(list.size()-1)
	}
	
	private int popAt(int i){
		Stack temp = list.get(i);
		return temp.pop();
	}
	public static void main(String[] args) {
		ImplementSetOfStacks_3 obj = new ImplementSetOfStacks_3(2);
		obj.push(1);
		obj.push(2);
		obj.push(0);
		obj.push(4);
		obj.pop();
		obj.pop();
	}
*/
}
