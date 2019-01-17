package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 */
 
public class FindRowWithMaximumNumberOf1s {

	public int max(int[][] arr){
	
		int n = arr.length, i = 0, maxRowIndx = 0;
		int j = first(arr[0],0,n-1) -1;
		if(j == -1) j = n-1;
		
		for(i = 1;i < n;i++){
			while(j >= 0 && (arr[i][j] == 1)){
				j = j-1;
				maxRowIndx = i;
			}
		}
		return maxRowIndx;
	}

	/* A function to find the index of first index of 1 in an array arr[] */
	public int first(int arr[], int low, int high){
		if(high >= low){
			// get the middle index  
			int mid = low + (high - low)/2; 

			// check if the element at middle index is first 1
			if (( mid == 0 || arr[mid-1] == 0) && arr[mid] == 1)
				return mid;

			// if the element is 0, recur for right side
			else if (arr[mid] == 0)
				return first(arr, (mid + 1), high);

			else // If element is not first 1, recur for left side
				return first(arr, low, (mid -1));
		}
		return -1;
	}


	public static void main(String[] args) {
		FindRowWithMaximumNumberOf1s obj = new FindRowWithMaximumNumberOf1s();
		int[][] arr = { {0, 0, 0, 1},
						{0, 1, 1, 1},
						{0, 0, 0, 0},
						{1, 1, 1, 1}
					   };

		int result = obj.max(arr);
		System.out.println("Max 1 in row:"+result);
	}
}
