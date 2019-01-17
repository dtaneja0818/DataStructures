package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * http://leetcodesolution.blogspot.com/2014/09/leetcode-maximum-product-subarray.html
 * Time Complexity: O(n)
Auxiliary Space: O(1)
 */
public class A64_MaximumProductSubarray {

	public int getMaxProductSubarray2(int[] A) {
        int n  = A.length;
        int maxProd = Integer.MIN_VALUE;
        int prod = 1;
        for(int i=0; i <n; i++){
            prod = prod * A[i];
            maxProd = Math.max(maxProd, prod);
            if (A[i] == 0)
                prod = 1;
        }
        prod = 1;
        for(int i=n-1; i >=0; i--){
            prod = prod * A[i];
            maxProd = Math.max(maxProd, prod);
            if (A[i] == 0)
                prod = 1;
        }
        return maxProd;
    }
    
	private int getMaxProductSubarray(int [] arr){
		int n = arr.length;
		// max positive product ending at the current position
		int max_ending_here = 1;
		// min negative product ending at the current position
		int min_ending_here = 1;
		// Initialize overall max product
		int max_so_far = 1;
		/* Traverse throught the array. Following values are maintained after the ith iteration:
       		max_ending_here is always 1 or some positive product ending with arr[i]
       		min_ending_here is always 1 or some negative product ending with arr[i] */
		for (int i = 0; i < n; i++){
			/* If this element is positive, update max_ending_here. Update min_ending_here only if min_ending_here is negative */
			if (arr[i] > 0){
				max_ending_here = max_ending_here*arr[i];
				min_ending_here = Math.min(min_ending_here * arr[i], 1);
			}
			/* If this element is 0, then the maximum product cannot end here, make both max_ending_here and min_ending_here 0
           		Assumption: Output is alway greater than or equal to 1. */
			else if (arr[i] == 0){
				max_ending_here = 1;
				min_ending_here = 1;
			}
			/* If element is negative. This is tricky 
			 * max_ending_here can either be 1 or positive. 
			 * min_ending_here can either be 1 or negative.
			 * next min_ending_here will always be prev. 
			 * max_ending_here * arr[i] 
			 * next max_ending_here will be 1 if prev 
			 * min_ending_here is 1, otherwise 
			 * next max_ending_here will be prev min_ending_here * arr[i] 
			 * */
			else{
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}
			// update max_so_far, if needed
			if (max_so_far <  max_ending_here)
				max_so_far  =  max_ending_here;
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		A64_MaximumProductSubarray obj = new A64_MaximumProductSubarray();
		int[] arr = {1, -2, -3, 0, 7, -8, -2};
		int result = obj.getMaxProductSubarray2(arr);
		System.out.print("Max product is:"+result);
		System.out.println();
		result = obj.getMaxProductSubarray2(arr);
		System.out.print("Max product is:"+result);
	}
}
