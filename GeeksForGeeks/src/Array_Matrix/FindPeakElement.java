package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element. 
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. 
 * Note that we need to return any one peak element.
 */
 
public class FindPeakElement {

	public int peak(int[] arr,int low,int high){
		int n = arr.length;
		// Fin index of middle element
		int mid = low + (high - low)/2;  /* (low + high)/2 */

		// Compare middle element with its neighbours (if neighbours exist)
		if ((mid == 0 || arr[mid-1] <= arr[mid]) &&	(mid == n-1 || arr[mid+1] <= arr[mid]))
			return mid;

		// If middle element is not peak and its left neighbor is greater than it then left half must have a peak element
		else if (mid > 0 && arr[mid-1] > arr[mid])
			return peak(arr, low, (mid -1));

		// If middle element is not peak and its right neighbor is greater than it then right half must have a peak element
		else return peak(arr, (mid + 1), high);
	}

	public static void main(String[] args) {
		FindPeakElement obj = new FindPeakElement();
		int[] arr = {1, 4, 4, 5, 10, 8};
		int result = obj.peak(arr,0,arr.length);
		System.out.println("Peak elem is:"+arr[result]);
	}
}
