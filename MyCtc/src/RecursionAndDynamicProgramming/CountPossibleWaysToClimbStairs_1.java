package RecursionAndDynamicProgramming;
/*
 * 9.1
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
 * 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs.
 * 
 * 
 */
 
	public class CountPossibleWaysToClimbStairs_1 {

	private int countWaysDP(int n, int[] temp){
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(temp[n] > -1)
			return temp[n];
		else{
			temp[n] = countWaysDP(n-1,temp) + countWaysDP(n-2,temp) + countWaysDP(n-3,temp);
			return temp[n];
		}
	}
	
	private int countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
		}
	}
	public static void main(String[] args) {
		CountPossibleWaysToClimbStairs_1 obj = new CountPossibleWaysToClimbStairs_1();
		for (int i = 0; i < 30; i++) {
			long t1 = System.currentTimeMillis();
			int[] map = new int[30 + 1];
			for (int j = 0; j < map.length; j++) {
				map[j] = -1;
			}
			int c1 = obj.countWaysDP(i, map);
			long t2 = System.currentTimeMillis();
			long d1 = t2 - t1;
			
			long t3 = System.currentTimeMillis();
			int c2 = obj.countWaysRecursive(i);
			long t4 = System.currentTimeMillis();
			long d2 = t4 - t3;			
			System.out.println(i + " " + c1 + " " + c2 + " " + d1 + " " + d2);
		}
		
	}

}
