package Easy;
/*
 * https://oj.leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs_70 {

	public int climbStairs(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		int[] cache = new int[n];
		cache[0] = 1;
		cache[1] = 2;
		return climbStairsHelper(n,cache);
	}
	
	public int climbStairsHelper(int n, int[] cache){
		if(cache[n-1] != 0) return cache[n-1];
		cache[n-1] = climbStairsHelper(n-1,cache)+climbStairsHelper(n-2,cache);
		return cache[n-1];
	}
	
	public static void main(String[] args) {
		ClimbingStairs_70 obj = new ClimbingStairs_70();
		System.out.println("Distinct ways: "+obj.climbStairs(1));
	}
}
