package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 */
public class CheckIfanArrayContainsDuplicateElementsWithinkDistanceFromEachOther {

	public boolean containsDup(int[] arr, int k){
		// Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Traverse the input array
        for (int i=0; i<arr.length; i++){
            // If already present n hash, then we found a duplicate within k distance
            if (set.contains(arr[i]))	return true;
             // Add this item to hashset
            set.add(arr[i]);
             // Remove the k+1 distant item
            if (i >= k)		set.remove(arr[i-k]);
        }
        return false;
	}
	public static void main(String[] args) {
		CheckIfanArrayContainsDuplicateElementsWithinkDistanceFromEachOther obj = new CheckIfanArrayContainsDuplicateElementsWithinkDistanceFromEachOther();
		int[] arr = {1, 2, 3, 1, 4, 5};
		System.out.println(obj.containsDup(arr,3));
	}
}
