package Array_String;
/*
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * Solution:
 * APPROACH1:
 * Here i have taken approach using bits first we have subtracted the char value with 'a' to make it in range 0-32 and then right shifted 1 with 
 * that value of the elem present and then AND with the checker(which stores value of the last operation) any variable that is a duplicate will 
 * result in checker & (1 << val) > 0
 * example:
 * if val = 1
 * checker is 0000
 * 1 << val = 0010
 * checker & (1 << val) = 0
 * saving checker to 0010 by checker |= (1 << val)
 * if val = 2
 * checker is 0010
 * 1 << val = 0100
 * checker & (1 << val) = 0
 * saving checker to 0110 by checker |= (1 << val)
 * if again we have val = 2
 * checker is 0110
 * 1 << val = 0100
 * checker & (1 << val) = 100 ie > 0
 */
public class E6_1c_DetermineIfaStringHasAllUniqueCharacters {

	public static boolean isUniqueCharsApproach1(String str){
		if (str.length() > 128) {
		return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i) - 'a';
		if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	/*
	 *Here we have taken an array of boolean type with size 128. So whenever we encounter a char we set the vlue in the array to true and check
	 *if alreadythe value was set or not if it was set it means the char was already present.
	 */
	public static boolean isUniqueCharsApproach2(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcdeABCD", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueCharsApproach1(word) + " " + isUniqueCharsApproach2(word));
		}
	}
}
