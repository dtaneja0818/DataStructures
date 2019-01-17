package RecursionAndDynamicProgramming;
/*
 * 9.3
 * A magic index in an array A [ 0 . . .n-1] is defined to be an index such that A[i] = i. 
 * Given a sorted array of distinct integers, write a method to find a magic
 * index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex_3 {

	// elem distint
	private int magicIndex1(int[] arr){
		int len = arr.length;
		int index = searchSpecial(arr,0,len-1);
		return index;
		
	}
	
	private int search(int[] temp, int start, int end){
		if(start > end) 
			return Integer.MIN_VALUE;
		int mid = (start+end)/2;
		if(temp[mid] == mid) return mid;
		if(temp[mid] >  mid) end = mid-1;
		else start = mid+1;
		int result = search(temp,start,end);
		return result;
	}
	
	//here first it will search on left side if found it will return it else will search on right side if not found will returm min_value
	private int searchSpecial(int[] temp, int start, int end){
		if(start > end || start < 0 || end >= temp.length) 
			return Integer.MIN_VALUE;
		int midIndex = (start+end)/2;
		int midValue = temp[midIndex];
		if(midValue == midIndex) return midIndex;
		// search left
		int leftIndex = Math.min(midIndex-1,midValue);
		int resultLeft = searchSpecial(temp,start,leftIndex);
		if(resultLeft >= 0) return resultLeft;
		//search right
		int rightIndex = Math.max(midIndex+1,midValue);
		int resultRight = searchSpecial(temp,rightIndex,end);
		return resultRight;
	}
	// elem not distinct(repetition)
	private int magicIndex2(int[] arr){
		return 0;
	}
	
	public static void main(String[] args) {
		MagicIndex_3 obj = new MagicIndex_3();
		int arr[] = {1,2,4,4,4};
		System.out.println(obj.magicIndex1(arr));
		//System.out.println(obj.magicIndex2(arr));
	}

}
