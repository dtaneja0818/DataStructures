package Sorting_Searching;

/*
 * 11.1 You are given two sorted arrays, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 */
public class Merge2SortedArrays_1{

	
	private void Merge2SortedArrays_1(int[] a, int[] b , int actualIndxA){
		int len1 = actualIndxA;
		int len2 = b.length;
		int len3 = len1 + len2;
		int indxLastA = len1 - 1;
		int indxLastB = len2 - 1;
		int indxLastAB = len3 - 1;

		while((indxLastA >= 0) && (indxLastB >= 0)){
			if(a[indxLastA] > b[indxLastB]){
				a[indxLastAB] = a[indxLastA];
				indxLastA--;
			}
			else if(b[indxLastB] > a[indxLastA]){
				a[indxLastAB] = b[indxLastB];
				indxLastB--;
			}
			else if(a[indxLastA] == b[indxLastB]){
				a[indxLastAB] = b[indxLastB];
				indxLastB--;
				indxLastAB--;
				a[indxLastAB] = a[indxLastA];
				indxLastA--;
			}
			indxLastAB--;
		}
		
		if(indxLastA > 0){
			while(indxLastA != 0){
				a[indxLastAB] = a[indxLastA];
				indxLastA--;
				indxLastAB--;
			}
		}
		else if(indxLastB > 0){
			while(indxLastB != 0){
				a[indxLastAB] = b[indxLastB];
				indxLastB--;
				indxLastAB--;
			}
		}
	}

	public static void main(String[] args) {
		Merge2SortedArrays_1 obj = new Merge2SortedArrays_1();
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 6, 7, 7, 7};
		obj.Merge2SortedArrays_1(a, b, 8);
		for(int i = 0; i< a.length; i++){
			System.out.print(a[i]+",");
		}
	}
}
