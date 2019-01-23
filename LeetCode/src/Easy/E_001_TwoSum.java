package Easy;
import java.util.*;
/* https://leetcode.com/problems/two-sum/
 * Time complexity : O(n). We traverse the list containing n elements only once. 
 * Each look up in the table costs only O(1) time.
 * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, 
 * which stores at most nn elements.
*/
public class E_001_TwoSum {
	// This method works in O(n) time.
	public int[] twoSum(int[] nums, int target){
		Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int diff = 0;
		int i = 0;
		while(i < nums.length){
			diff = target - nums[i];
			if(hash.containsKey(nums[i])){
				return new int[] { hash.get(nums[i]), i};
			}else{
				hash.put(diff, i);
			}
			i++;
		}
		return null;
	}

	public static void main(String[] args) {
		E_001_TwoSum obj = new E_001_TwoSum();
		int[] arr = new int[] {-1,-2,-3,-4,-5};
		int[]res = obj.twoSum(arr,-8);
		System.out.println("Index::"+res[0]+":"+res[1]);
	}

}
