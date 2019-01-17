package Hard;
import java.util.ArrayList;

public class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	
	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
	    	String suffix = s.substring(i);
	    	insertString(suffix, i);
		}
	}

	public void insertString(String s, int index) {
		root.indexes.add(index);
		SuffixTreeNode child;
		if (s != null && s.length() > 0) {
			root.value = s.charAt(0);
			SuffixTreeNode root = null;
			if (root.children.containsKey(root.value)) {
				child = root.children.get(root.value);
			} else {
				child = new SuffixTreeNode();
				root.children.put(root.value, child);
			}
			String remainder = s.substring(1);
			insertString(remainder, index);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		if (s == null || s.length() == 0) {
			return root.indexes;
		} else {
			char first = s.charAt(0);
			if (root.children.containsKey(first)) {
				String remainder = s.substring(1);
				//return root.children.get(first).search(remainder);
			}
		}
		return null;
	}
}
