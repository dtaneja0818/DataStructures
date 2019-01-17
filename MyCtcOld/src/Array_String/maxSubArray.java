package Array_String;
/*RubyQuiz#131 Maximum Sub-Array O(n)
 * Given an array of integers, find the sub-array with maximum sum. 
 * For example:
 * array:  [-1, 2, 5, -1, 3, -2, 1]
 * maximum sub-array:  [2, 5, -1, 3]
 * */

import java.util.*;
public class maxSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements you want in an array");
		int n=in.nextInt();
		int[] myIntArray = new int[n];
		System.out.println("Enter elements of an array");
		int elm;
		for(int i=0;i<n;i++){
			elm=in.nextInt();
			myIntArray[i]=elm;
		}
		maxSubArraySum(myIntArray, n);

	}
	// prints the max sub array and finds the indexes with max sum
	private static void maxSubArraySum(int[] myIntArray, int n) {
		int max_so_far = myIntArray[0], i,to = 0,frm = 0;
		int max_ending_here =  myIntArray[0];
		int old_max_so_far =  myIntArray[0];
		for (i = 1; i < myIntArray.length; i++){
			max_ending_here = max(myIntArray[i], max_ending_here+ myIntArray[i]); 
			old_max_so_far=max_so_far;
			max_so_far = max(max_so_far, max_ending_here);
			if(myIntArray[i]>0 && max_so_far>old_max_so_far){
				to=i;
			}
			if(max_so_far==myIntArray[i]){
				frm=i;
			}
		}
		System.out.println("Maximum contiguous sum is:"+ max_so_far);//Prints max sum of sub array
		System.out.print("Max Sub Array is: [");
		for(i=frm;i<=to;i++){
			System.out.print(myIntArray[i]+",");
		}
		System.out.print("]");
	}
	//compares two numbers and returns the max of them
	private static int max(int max_so_far, int curr_max) {
		return (curr_max> max_so_far)? curr_max : max_so_far;
	}

}
