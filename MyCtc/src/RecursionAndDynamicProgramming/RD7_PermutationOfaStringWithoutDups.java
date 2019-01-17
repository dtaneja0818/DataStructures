package RecursionAndDynamicProgramming;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * http://www.geeksforgeeks.org/permutations-of-a-given-string-using-stl/
 * http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
 * Algorithm Paradigm: Backtracking
 * Time Complexity: O(n*n!) 
 * Note that there are n! permutations and it requires O(n) time to print a a permutation.
 */
public class RD7_PermutationOfaStringWithoutDups {

	/* * A method exposed to client to calculate permutation of String in Java. */ 
	public static void getPermuteApproach1(String input){ 
		getPermuteApproach1("", input); 
	} 

	/* * Recursive method which actually prints all permutations 
	 * * of given String, but since we are passing an empty String 
	 * * as current permutation to start with, 
	 * * I have made this method private and didn't exposed it to client. 
	 * */ 
	private static void getPermuteApproach1(String perm, String word) { 
		if (word.isEmpty()) { 
			System.err.println(perm + word);
		} else { 
			for (int i = 0; i < word.length(); i++) { 
				getPermuteApproach1(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); 
			} 
		} 
	}
	
	public static ArrayList<String> getPermuteApproach2(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the first character
		ArrayList<String> words = getPermuteApproach2(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	// inserts a char c at position i and returns the new string
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public static void main(String[] args) {
		RD7_PermutationOfaStringWithoutDups obj = new RD7_PermutationOfaStringWithoutDups();
		ArrayList<String> list = obj.getPermuteApproach2("ABC");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("Approach 2");
		obj.getPermuteApproach1("ABC");
	}
}
