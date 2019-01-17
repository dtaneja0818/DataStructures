package Strings;
/*
 * http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 * Time Complexity: O(n)
 * Space Complexity: O(1)  � Because we are using fixed space (Hash array) irrespective of input string size.
 */
public class S1_ReturnMaximumOccurringCharacterInaString {

	public char max(String str){
		int[] count  = new int[256];
		int max = 0;

		for(int i=0; i<str.length(); i++){
			int index = (int)str.charAt(i);
			count[index]++;
			if(count[max] < count[index]){
				max = index;
			}
		}
		return (char)max;
	}

	public static void main(String[] args) {
		S1_ReturnMaximumOccurringCharacterInaString obj = new S1_ReturnMaximumOccurringCharacterInaString();
		String s = "nitin";
		System.out.println("Max char is:"+obj.max(s));
	}
}
