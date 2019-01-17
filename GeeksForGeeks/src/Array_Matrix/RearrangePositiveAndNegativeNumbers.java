package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 * An array contains both positive and negative numbers in random order. 
 * Rearrange the array elements so that positive and negative numbers are placed alternatively. 
 * Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. 
 * If there are more negative numbers, they too appear in the end of the array.
 */
public class RearrangePositiveAndNegativeNumbers {

	public void rearrange(int[] arr){
		int n = arr.length;
		if(n == 1 || n == 0) return;
		// The following few lines are similar to partition process of QuickSort.  
		// The idea is to consider 0 as pivot and divide the array around it.
		int i = -1;
		for (int j = 0; j < n; j++){
			if (arr[j] < 0){
				i++;
				swap(arr,i,j);
			}
		}
		// Now all positive numbers are at end and negative numbers at the beginning of array. 
		// Initialize indexes for starting point of positive and negative numbers to be swapped
		int pos = i+1, neg = 0;

		// Increment the negative index by 2 and positive index by 1, i.e., swap every alternate negative number with next positive number
		while (pos < n && neg < pos && arr[neg] < 0){
			swap(arr,neg, pos);
			pos++;
			neg += 2;
		}
	}

	public void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;;
	}
	
	public static void main(String[] args) {
		RearrangePositiveAndNegativeNumbers obj = new RearrangePositiveAndNegativeNumbers();
		int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		obj.rearrange(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
