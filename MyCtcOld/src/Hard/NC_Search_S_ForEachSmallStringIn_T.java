package Hard;

import java.util.*;

public class NC_Search_S_ForEachSmallStringIn_T {

	public static void main(String[] args) {
		String testString = "mississippi";
		String[] stringList = {"is", "sip", "hi", "sis"};
		SuffixTree tree = new SuffixTree(testString);
		for (String s : stringList) {
			ArrayList<Integer> list = tree.search(s);
			if (list != null) {
				System.out.println(s + ": " + list.toString());
			}
		}
	}
}
