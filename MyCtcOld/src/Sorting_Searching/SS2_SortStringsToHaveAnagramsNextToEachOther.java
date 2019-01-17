package Sorting_Searching;

import java.util.*;

/*http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
 * 
 * 11.2 Write a method to sort an array of strings so that all the anagrams are next to each other.
 * 
 * One way to do this is to just apply any standard sorting algorithm, like merge sort or
 * quicksort, and modify the comparator. This comparator will be used to indicate that two
 * strings which are anagrams of each other are equivalent.
 * What's the easiest way of checking if two words are anagrams? We could count the
 * occurrences of the distinct characters in each string and return true if they match. Or,
 * we could just sort the string. After all, two words which are anagrams will look the same
 * once they're sorted
 * This algorithm will take 0(n log(n)) time.
 */
 
class AnagramComparator implements Comparator<String>{
	public String sortChars(String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}

public class SS2_SortStringsToHaveAnagramsNextToEachOther {

	public void SortApproach1(String[] arr){
		Arrays.sort(arr, new AnagramComparator());
	}

	/*
	 * This may be the best we can do for a general sorting algorithm, but we don't actually
	 * 	need to fully sort the array. We only need to group the strings in the array by anagram.
	 * 	We can do this by using a hash table which maps from the sorted version of a word to
	 * 	a list of its anagrams. So, for example, "acre" will map to the list {acre, race, care}.
	 * 	Once we've grouped all the words into these lists by anagram, we can then put them
	 * 	back into the array.
	 */
	public void SortApproach2(String[] arr){
		Hashtable<String,LinkedList<String>> table = new Hashtable<String,LinkedList<String>>();
		LinkedList<String> list = new LinkedList<String>();
		AnagramComparator sortString = new AnagramComparator();
		
		for(String s1 : arr){
			String s = sortString.sortChars(s1);
			if(!table.containsKey(s)){
				table.put(s,new LinkedList<String>());
			}
			list = table.get(s);
			list.push(s1);
		}
		int i = 0;
		for(String str : table.keySet()){
			list = table.get(str);
			for(String t : list){
				arr[i] = t;
				i++;
			}
		}
	}

	public static void main(String[] args) {
		SS2_SortStringsToHaveAnagramsNextToEachOther obj = new SS2_SortStringsToHaveAnagramsNextToEachOther();
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		//String[] array = {"cat","dog", "tac", "god", "act"};
		obj.SortApproach1(array);
		for(int i = 0 ; i < array.length; i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
		System.out.println("Approach2");
		obj.SortApproach2(array);
		for(int i = 0 ; i < array.length; i++){
			System.out.print(array[i]+",");
		}
	}
}
