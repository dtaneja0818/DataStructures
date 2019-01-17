package Strings;
import DynamicProgramming.DP28_LongestPalindromicSubstring;
/*
 * http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
 */
public class S33_CheckIfStringIsRotationOfaPalindrome {

	public boolean isRotation(String s){
		int n = s.length();
		String temp = s+s;
		DP28_LongestPalindromicSubstring obj = new DP28_LongestPalindromicSubstring();
		int[] result = obj.longestPalSubstrDynamic(temp);
		System.out.println(temp.substring(result[0],result[1]+1)); 
		if((result[1] - result[0]+1) > n) return true;
		return false;
	}
	
	public static void main(String[] args) {
		S33_CheckIfStringIsRotationOfaPalindrome obj = new S33_CheckIfStringIsRotationOfaPalindrome();
		System.out.println("Palindrome: "+obj.isRotation("abcd"));
		System.out.println("Palindrome: "+obj.isRotation("aaaad"));
		System.out.println("Palindrome: "+obj.isRotation("aab"));
		System.out.println("Palindrome: "+obj.isRotation("abcde"));
		
	}
}
