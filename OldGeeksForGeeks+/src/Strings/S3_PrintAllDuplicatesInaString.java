package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 * Time Complexity: O(n)
 */
public class S3_PrintAllDuplicatesInaString {

	public String printDuplicateString(final String s){
		int  i = 0;
		HashMap<Character,Boolean> h = new HashMap<Character,Boolean>();
		StringBuilder sb = new StringBuilder();
		
		while(i < s.length()){
		
			char c = s.charAt(i);
			if(h.containsKey(c)){
				sb.append(c);
			}
			else h.put(c,true);
			i++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		S3_PrintAllDuplicatesInaString obj = new S3_PrintAllDuplicatesInaString();
		String s = "geeksforgeeks";
		System.out.println("dup string is: "+obj.printDuplicateString(s));
	}
}
