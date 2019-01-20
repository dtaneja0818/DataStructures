package Array_String;
/*CTC
 * 1.2 Given two strings, write a method to decide if one is a permutation of the other.
 * http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 */

public class E6_2_ChkOneStringPermutationOfAnother{

    /*
     * Here we have taken XOR of both the strings as if the char in the string are
     * same the XOR will result in 0 otherwise it would give the missing char 
     * ex: 1234 XOR 1234 gives 0 and 12345 XOR 1234 will give you 5(in binary)
     */
    public boolean chkPermutationApproach1(String s1, String s2){
        char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int result=0;
		for(int i = 0;i < s1.length();i++) result=result^arr1[i];
		for(int i = 0;i < s2.length();i++) result=result^arr2[i];
        if(result != 0) return false;
        else return true;
    }

/*This method assumes that the set of possible characters in both strings is small. In the following implementation, it is assumed 
 * that the characters are stored using 8 bit and there can be 256 possible characters.
1) Create count array of size 128 for all char in string. Initialize all values in count array as 0.
2) Iterate through every character of both strings and increment the count of character in one array and decrement for other.
3) If count array contains any num !=0 then it means it has different set of char
*/
     public boolean chkPermutationApproach2(String s, String t){
        if (s.length() != t.length())
			return false;
		int[] letters = new int[128];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it's a match if t has been processed completely
					return true;
					//return i == t.length() - 1;
				}
			}
        }
        return false;
     }
     
     /*
      * Here we have taken a array of size 128 and incremented position of char from first string i the array taken if for the second second sting we
      * have the same set of char then it wud result in 0 value at that index otherwise the index value would become -ve.
      */
     public static boolean chkPermutationApproach3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;  
		}
		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
		    if (--letters[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}
	
     /*
      * Here we have just sorted both the arrays and matched if the sorted arrays 
      * are equal or not.
      */
     public boolean chkPermutationApproach4(String s, String t){
        return sort(s).equals(sort(t));
     }
        
     public static String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
     }

	public static void main(String[] args) {
        E6_2_ChkOneStringPermutationOfAnother obj = new E6_2_ChkOneStringPermutationOfAnother();
        String[][] pairs = {{"apple", "papel"}, {"carrot", "taarroc"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
            boolean approach1 = obj.chkPermutationApproach1(word1, word2);
			boolean approach2 = obj.chkPermutationApproach2(word1, word2);
            boolean approach3 = obj.chkPermutationApproach3(word1, word2);
            boolean approach4 = obj.chkPermutationApproach3(word1, word2);
			System.out.println("Approach1:"+word1 + ", " + word2 + ": " + approach1);
            System.out.println("Approach2:"+word1 + ", " + word2 + ": " + approach2);
            System.out.println("Approach3:"+word1 + ", " + word2 + ": " + approach3);
            System.out.println("Approach4:"+word1 + ", " + word2 + ": " + approach4);
        }
    }
}