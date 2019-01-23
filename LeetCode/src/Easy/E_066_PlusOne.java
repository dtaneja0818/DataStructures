package Easy;
/*
 * https://oj.leetcode.com/problems/plus-one/
 */
public class E_066_PlusOne {

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int[] result = new int[n+1];
		if(n == 0)	return result;
		int carry = 1,i = n-1,j = n;
		while(i >= 0){
			result[j] = digits[i]+carry;
			carry = 0;
			if(result[j] == 10){
				result[j] = 0;
				carry = 1;
			}
			i--;
			j--;
		}
		if(carry == 1 && j == 0) result[0] = 1;
		else	result = java.util.Arrays.copyOfRange(result,1,n+1);
		return result;
	}

	public static void main(String[] args) {
		E_066_PlusOne obj = new E_066_PlusOne();
		int[] arr = {0};
		arr = obj.plusOne(arr);
		for(int i = 0;i < arr.length;i++)System.out.print(arr[i]);
	}
}
