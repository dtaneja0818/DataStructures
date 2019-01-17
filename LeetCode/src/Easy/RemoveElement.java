package Easy;
/*
 * https://oj.leetcode.com/problems/remove-element/
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		int i = 0,j = 0,n = A.length;
		while (i < n){
			if (A[i] != elem){
				A[j] = A[i];
				j++;
			}
			i++;
		}
		return j;
	}

	public static void main(String[] args) {
		RemoveElement obj = new RemoveElement();
		int arr[] = {4,5};
		System.out.println("New Length:"+obj.removeElement(arr,4));
		for(int i = 0;i < arr.length;i++) System.out.print(arr[i]+",");
	}
}
