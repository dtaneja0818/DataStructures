package Easy;
import java.util.*;

/*
 * https://oj.leetcode.com/problems/pascals-triangle/
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	[1,5,10,10,5,1]
]
 */
public class PascalTriangle_118 {

	public ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n < 1) return result;
		ArrayList prev = new ArrayList();
		prev.add(1);
		result.add(prev);

		for(int i = 1;i < n;i++){
			prev = result.get(i-1);
			ArrayList next = new ArrayList();
			next.add(1);
			for(int j = 0;j < i-1;j++)	next.add((int)prev.get(j) + (int)prev.get(j+1));
			next.add(1);
			result.add(next);
		}
		return result;
	}

	public static void main(String[] args) {
		PascalTriangle_118 obj = new PascalTriangle_118();
		ArrayList<ArrayList<Integer>> result = obj.generate(1);
		for(List a : result){
			System.out.println(a);
		}
	}
}
