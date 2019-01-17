package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestSubarrayWithSumGreaterThanaValue {

	public int[] subarray(int[] arr, int x){
		int result[] = new int[2];
		int n = arr.length,start = 0,end = -1, minlen = n+1, sum = 0;
		if(sum > x) return result;

		while(end < n){
			// Keep adding array elements while current sum is smaller than x
			while ((sum <= x) && (end < n)){	
				end++;
				if(end < n) sum += arr[end];	
			}

			if(sum > x && start < n){
				int len = end - start;
				if(minlen > len){
					minlen = len;
					result[0] = start;
					result[1] = end;
				}
				sum -= arr[start];
				start++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SmallestSubarrayWithSumGreaterThanaValue obj = new SmallestSubarrayWithSumGreaterThanaValue();
		int[] arr = {1, 4, 45, 6, 10, 19};
		int[] result = obj.subarray(arr,51);
		for(int i = result[0]; i <= result[1];i++){
			System.out.print(arr[i]+",");
		}
	}
}
