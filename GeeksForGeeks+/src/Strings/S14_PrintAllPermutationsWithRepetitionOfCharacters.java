package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 * 
 */
public class S14_PrintAllPermutationsWithRepetitionOfCharacters {
	
	public Set<String> permute(String str){
		Set<String> permutations = new HashSet<String>();
		int len = str.length();
		char[] inputArr = str.toCharArray();
		Arrays.sort(inputArr);
		char[] data = new char[str.length()];
		helper(inputArr,data,len-1,0,permutations);
		return permutations;
	}

	public void helper(char[] strArr, char[] data, int last, int start, Set<String> permutations){
		int i, len = strArr.length;
		
		// One by one fix all characters at the given index and recur for the subsequent indexes
		for (i = 0; i < len; i++){
			// Fix the ith character at index and if this is not the last index then recursively call for higher indexes
			data[start] = strArr[i];
			// If this is the last index then print the string stored in data[]
			if (start == last){
				String temp = "";
				temp = temp.copyValueOf(data);
				System.out.print(temp+", ");
				permutations.add(temp);
			}
			else // Recur for higher indexes
				helper(strArr, data,last, start+1, permutations);
		}
	}
	
	public static void main(String[] args) {
		S14_PrintAllPermutationsWithRepetitionOfCharacters obj = new S14_PrintAllPermutationsWithRepetitionOfCharacters();
		String text = "ABC";
		System.out.println("Permutations are: "+obj.permute(text));
	}
}
