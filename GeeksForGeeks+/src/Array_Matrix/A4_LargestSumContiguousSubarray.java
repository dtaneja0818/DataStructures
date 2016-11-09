package Array_Matrix;
/*	http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * 
 * Kadane's Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */
 
public class A4_LargestSumContiguousSubarray {

	private void largestSum(int[] arr){
		int startIndx = 0, endIndx = 0, maxSum = 0, currentSum = 0, maxstartIndx = 0, maxendIndx = 0;
		
		for(int i = 0;i < arr.length; i++){
			currentSum += arr[i];
			if(currentSum > maxSum){
				maxSum = currentSum;
				endIndx = i;
				maxendIndx = i;
				maxstartIndx = startIndx;
			}
			if(currentSum < 0){
				startIndx = i+1;
				endIndx = i+1;
				currentSum = 0;
			}
		}
		System.out.println("Max sum is:"+ maxSum);
		System.out.println("Elem are:");
		for(int i = maxstartIndx; i <= maxendIndx; i++) System.out.print(arr[i]+",");
	}
	
	    /*
     * the first for loop is 2 decide sub array size, the 2nd loop is to iterate thru that sub array and
     * 3rd loop is to cal the sum of elem in the sub array. O(n^3)
     */
    public int maxSumBruteForce1(int[] arr, int n){
        int ans = Integer.MIN_VALUE;
        for(int sub_array_size = 1; sub_array_size <= n; ++sub_array_size){
            for(int start_arr = 0; start_arr < n; ++start_arr){
                if((start_arr + sub_array_size) > n) break;
                int sum = 0;
                for(int i = start_arr; i < (start_arr + sub_array_size); i++)
                    sum += arr[i];
                 ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    /*
     * O(n^2)
     * here we can reduce 1 for loop if we fix the first elem of the array and calculate sum for all its
     * pairs by simply adding the last elem in the previous sum.
     */
    public int maxSumBruteForce2(int[] arr, int n){
        int ans = Integer.MIN_VALUE;
        for(int start_arr = 0; start_arr < n; ++start_arr){
            int sum = 0;
            for(int sub_array_size = 1; sub_array_size <= n; ++sub_array_size){
                if((start_arr + sub_array_size) > n) break;
                sum += arr[start_arr + sub_array_size -1];
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public int maxSumNlogN(int[] arr, int n){
        /*if(n==1){
		    return arr[0];
	    }
	    int m = n/2;
	    int left_MSS = maxSumNlogN(arr,m);
	    int right_MSS = maxSumNlogN(arr+m,n-m);
	    int leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE, sum=0;
	    for(int i=m;i < n; i++){
		    sum += arr[i];
		    rightsum = Math.max(rightsum,sum);
	    }
	    sum = 0;
	    for(int i= (m-1);i >= 0; i--){
		    sum += arr[i];
		    leftsum = Math.max(leftsum,sum);
	    }
	    int ans = Math.max(left_MSS,right_MSS);
	    return Math.max(ans,leftsum+rightsum);*/
        return -1;
    }

    /*
     * Here we are taking an extra sum array which stores the max of the (current,previous_sum+current)
     * and we also compare the max with the last element in sum array and take max of that.
     * http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
     */ 
    public int maxSumKandane(int[] arr, int n){
        int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
 		for (int i = 1; i < arr.length; i++) {
			sum[i] = Math.max(arr[i], sum[i - 1] + arr[i]);
			max = Math.max(max, sum[i]);
		}
 		return max;
    }

    // Algorithm doesn't work for all negative numbers. It simply returns 0 if all numbers are negative.
    public int maxSumKandaneWithIndex(int[] arr, int n){
	    int startIndex = 0,endIndex = n-1,i;
	    int max_so_far, max_ending_here;
	    max_so_far = Integer.MIN_VALUE;
	    max_ending_here = 0;
	    for(i = 0; i < n; i++){
		    max_ending_here = max_ending_here + arr[i];
		    
		    //if (max_ending_here < 0) max_ending_here = 0;
		    
		    if(arr[i] > max_ending_here){
			    max_ending_here = arr[i]; 
			    startIndex = i;
		    }
		    if(max_ending_here > max_so_far){
			    max_so_far = max_ending_here;
			    endIndex = i;
		    }
	    }
        System.out.print("Max Sub Array is: [");
		for(i=startIndex;i<=endIndex;i++){
			System.out.print(arr[i]+",");
		}
		System.out.print("]");
        System.out.println();
	    return max_so_far;
    }
	
	public static void main(String[] args) {
		A4_LargestSumContiguousSubarray obj = new A4_LargestSumContiguousSubarray();
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Max: "+obj.maxSumKandaneWithIndex(arr, arr.length));
	}

}
