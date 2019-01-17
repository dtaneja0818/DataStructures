package Greedy_Backtracking_PS_DnC;
/*http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * http://professorjava.weebly.com/longest-increasing-subsequence.html
 */
import java.util.*;

public class LongestIncreasingSubsequence {

	public static int maxLisLength(int[] arr){
		int max = 0;
		int[] cache = new int[arr.length];

		/* Initialize LIS values for all indexes */
		for (int i = 0; i < arr.length; i++ )
			cache[i] = 1;
		
		for(int i = 1 ; i < arr.length ;i++){
			for(int j = 0 ;j < i; j++){
				if(arr[i] > arr[j] && cache[i] < cache[j] + 1){
					cache[i] = cache[j] + 1;
				}
			}
		}

		/* Pick maximum of all LIS values */
		for (int i = 0; i < arr.length; i++)
			if (max < cache[i])	max = cache[i];
		return max;

	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int[] arr = new int[] {10,1,2,3,4,11,12,13,14,15,5,6,7,8,9,16,17,18,19,20};
		System.out.println("MAX length:"+maxLisLength(arr));
	}

}
