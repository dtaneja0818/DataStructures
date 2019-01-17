package Sorting_Searching;

/*
 * 11.5  Given a sorted array of strings which is interspersed with empty strings, write a
 * method to find the location of a given string.
 * 
 * 
 */
public class FindaStringInSortedArrOfStringsContainingEmptyStrings_5 {

	private boolean isEmpty(String s){
		if(s.length() > 0 ) return false;
		return true;
	}

	private int search(String[] arr, String s){
		int start = 0;
		int end = arr.length - 1;
		int left,right,mid;
		boolean flag = false;
		mid = (start + end)/2;
		left = mid-1;
		right = mid+1;
		
		while(start <= end){
			if(!flag){
				mid = (start + end)/2;
				left = mid-1;
				right = mid+1;
			}
			
			if((right > arr.length - 1) || (left < 0)) return -1;

			String midElem = arr[mid];			
			if(!isEmpty(midElem)){
				if(midElem.compareTo(s) == 0) return mid;
				else if(midElem.compareTo(s) > 0){
					end = mid-1;
				}
				else if(midElem.compareTo(s) < 0){
					start = mid+1;
				}
				flag = false;
			}
			else{
				flag = true;
				if(!isEmpty(arr[left])){	
					if(arr[left].compareTo(s) == 0) return left;			
					if(arr[left].compareTo(s) < 0){
						start = right;
						flag = false;
					}
					else if(arr[left].compareTo(s) > 0){
						end = left;
						flag = false;
					}
				}
				else if(!isEmpty(arr[right])){
					if(arr[right].compareTo(s) == 0) return right;
					if(arr[right].compareTo(s) > 0){
						end = left;
						flag = false;
					}
					else if(arr[right].compareTo(s) < 0){
						start = right;
						flag = false;
					}
				}
				else{
					left--;
					right++;
				} 
			}
		}		
		return -1;
	}

	public static void main(String[] args) {
		FindaStringInSortedArrOfStringsContainingEmptyStrings_5 obj = new FindaStringInSortedArrOfStringsContainingEmptyStrings_5();
		String[] stringList = {"", "", "eel", "", "", "", "", "", "", "", "", "", "eelw", ""};
		System.out.println(obj.search(stringList, "eelw"));
	}

}
