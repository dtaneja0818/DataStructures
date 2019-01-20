package Stacks_Queues;
/* 3.1 Describe how you could use a single array to implement three stacks
 */
public class E6_1_Implement3StacksUsingSingleArray {
	private int maxSize;
	private int[] top = {-1,-1,-1};
	private int[] arr;;
	
	public E6_1_Implement3StacksUsingSingleArray(int size){
		maxSize = size;
		arr = new int[maxSize];
	}
	private void push(int stackNum, int x) throws Exception{
		if(top[stackNum] == (maxSize/3) -1) throw new Exception();
		top[stackNum]++;
		arr[(stackNum)*(maxSize/3) + top[stackNum]] = x;
	} 
	
	private int pop(int stackNum) throws Exception{
		if(top[stackNum] == -1) throw new Exception();
		int temp = arr[(stackNum)*(maxSize/3) + top[stackNum]];
		top[stackNum]--;
		return temp;
	}
	
	private int peek(int stackNum) throws Exception{
		if(top[stackNum] == -1) throw new Exception();
		return arr[(stackNum)*(maxSize/3) + top[stackNum]];
	}
	
	private boolean isEmpty(int stackNum){
		if(top[stackNum] == -1) return true;
		return false;
	}
	
	public static void main(String[] args) {
		E6_1_Implement3StacksUsingSingleArray obj = new E6_1_Implement3StacksUsingSingleArray(9);
		try{
			obj.push(0,1);
			obj.push(0,1);
			obj.push(0,1);
			
			obj.push(1,2);
			obj.push(1,2);
			obj.push(1,2);
			
			obj.push(2,3);
			obj.push(2,3);
			obj.push(2,3);

            while(!obj.isEmpty(2)){
                int value = obj.pop(2);
                System.out.println("popped elem:"+value+"\n");
            }
             //int value = obj.pop(1);
        }catch(Exception e){
            System.out.println("Sorry, overflow/underflow");
            e.printStackTrace();
        }
	}
}
