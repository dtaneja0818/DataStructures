package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 */
 
class Pairs{
	int first;
	int second;
}

public class CountAllDistinctPairsWithDifferenceEqualToK {
	// not working for diff = 0
	public ArrayList<Pairs> isSumApproach1(int[] arr, int x){
		ArrayList<Pairs> result = new ArrayList<Pairs>();
		/*Arrays.sort(arr);
		int n = arr.length, diff = 0, start = 0, end = n-1;
		
		while(start < end){
			diff = arr[end] - arr[start];
			if(diff == x){
				Pairs pair = new Pairs();
				pair.first = arr[start];
				pair.second = arr[end];
				result.add(pair);
				start++;
				end--;
			}
			else if(diff > x){
				start++;
			}
			else end--;
		}*/
		return result;
	}

	public ArrayList<Pairs> isSumApproach2(int[] arr, int x){
		ArrayList<Pairs> result = new ArrayList<Pairs>();
		Hashtable<Integer,Boolean> hash = new Hashtable<Integer,Boolean>();
		int diff = 0;
		int i = 0;
		while(i < arr.length){
			diff = arr[i]+x;
			
			if(hash.containsKey(arr[i])){
				Pairs pair = new Pairs();
				pair.first = arr[i];
				pair.second = arr[i]-x;
				result.add(pair);
			}else{
				hash.put(diff,true);
			}
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		CountAllDistinctPairsWithDifferenceEqualToK obj = new CountAllDistinctPairsWithDifferenceEqualToK();
		int[] arr = {1, 5, 3, 4, 2};
		ArrayList<Pairs> result = obj.isSumApproach1(arr,3);
		for(Pairs p: result) {
    		System.out.println(p.first+","+p.second);
		}
		result = obj.isSumApproach2(arr,3);
		for(Pairs p: result) {
    		System.out.println(p.first+","+p.second);
		}
	}
}
