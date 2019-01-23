package Easy;
/*
 * https://leetcode.com/problems/palindrome-number/
 */
public class E_009_PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}        
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	public static void main(String[] args) {
		E_009_PalindromeNumber obj = new E_009_PalindromeNumber();
		System.out.println(obj.isPalindrome(1211));
	}
}
