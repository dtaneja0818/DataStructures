package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/majority-element/
 * https://oj.leetcode.com/problems/majority-element/
 * Time Complexity: O(n)
 * Auxiliary Space : O(1)
 */

public class A002_MajorityElem {

	public int majority(int[] arr){
		int count = 1, majIndx = 0,i = 1, n = arr.length;

		while(i < n){
			if(arr[majIndx] == arr[i])		count++;
			else	count--;
			if(count == 0){
				majIndx = i;
				count = 1;
			}
			i++;
		}
		// above step uses Moore’s Voting Algorithm to get a candidate for majority element.
		// Check if the element obtained in step 1 is majority

		i = 0;
		count = 0;
		while(i < n){
			if(arr[i] == arr[majIndx]){
				count++;
			}
			i++;
		}
		if(count > n/2) return majIndx;
		else return -1;
	}

	public static void main(String[] args) {
		A002_MajorityElem obj = new A002_MajorityElem();
		int[] arr = {8,8,7,7,7};
		int indx = obj.majority(arr);
		if(indx == -1) System.out.println("No elem found");
		else{
			int result = arr[indx];
			System.out.println("majority elem is:"+result);
		}
	}
}
