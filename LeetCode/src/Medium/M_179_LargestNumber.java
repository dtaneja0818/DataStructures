package Medium;
import java.util.*;
// https://leetcode.com/problems/largest-number/
public class M_179_LargestNumber {

	public String max(int[] num){
		int i = 0;
		for(i = 0;i < num.length;i++){
			if(num[i] == 0)i++;
			else break;
		}
		if(i == num.length) return "0";
		List<Integer> arr = new ArrayList<Integer>();
		for (int index = 0; index < num.length; index++)	arr.add(num[index]);
		String result = "";
		

		Collections.sort(arr, new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				String a = x.toString();
				String b = y.toString();
				String ab = a+b;
				String ba = b+a;
				return ba.compareTo(ab);
			}
		});

		for (i = 0; i < arr.size(); i++)result += arr.get(i);
		return result;
	}

	public static void main(String[] args) {
		M_179_LargestNumber obj = new M_179_LargestNumber();
		int[] arr1 = new int[]{7,776,7,7};
		int[] arr2 = new int[]{54,546,548,60};
		int[] arr3 = new int[]{1,34,3,98,9,76,45,4};
		System.out.println("Biggest num is:"+obj.max(arr1));
		System.out.println("Biggest num is:"+obj.max(arr2));
		System.out.println("Biggest num is:"+obj.max(arr3));
	}
}
