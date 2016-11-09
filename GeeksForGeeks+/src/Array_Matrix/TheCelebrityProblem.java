package Array_Matrix;
import java.util.Stack;
/*
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 */
public class TheCelebrityProblem {

	public int getCelebrity(int[][] arr){
		int n = arr.length, candidate = -1, i = 0;
		Stack<Integer> s = new Stack<Integer>();
		for(i = 0;i < n;i++) s.push(i);
		
		while(s.size() != 1){
			int a = s.pop();
			int b = s.pop();
			if((arr[a][b] == 1) && (arr[b][a] == 1)) continue;
			else if(arr[a][b] == 1) s.push(b);
			else if(arr[b][a] == 1) s.push(a);
		}
		candidate = s.pop();
		i = 0;
		while(i < n){
			if(candidate != i)	s.push(i);
			i++;
		}
		while(!s.isEmpty()){
			int a = s.pop();
			if((arr[candidate][a] != 0) || (arr[a][candidate] == 0)) return -1;
		}
		return candidate;
	}
	
	public static void main(String[] args){
		TheCelebrityProblem obj = new TheCelebrityProblem();
		int arr[][] = new int[][]{
							 {0, 0, 1, 0}, 
							 {0, 0, 1, 0}, 
							 {0, 0, 0, 0}, 
							 {0, 0, 1, 0}
							 };
		int result = obj.getCelebrity(arr);
		System.out.println("Celebrity is:"+result);
	}
}
