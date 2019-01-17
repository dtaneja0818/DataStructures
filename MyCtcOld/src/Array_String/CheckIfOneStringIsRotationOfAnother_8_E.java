package Array_String;
/*
 * http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other-or-not/
 * 1.8
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check if s2 is
 * a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle"is a 
 * rotation of "erbottlewat").
*/
public class CheckIfOneStringIsRotationOfAnother_8_E {

	public boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		String temp = s1+s1;
		if(temp.contains(s2)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		CheckIfOneStringIsRotationOfAnother_8_E obj = new CheckIfOneStringIsRotationOfAnother_8_E();
		String s1 = "ABACD";
		String s2 = "CDAB";
		System.out.println("is rotation: "+obj.isRotation(s1,s2));
	}

}
