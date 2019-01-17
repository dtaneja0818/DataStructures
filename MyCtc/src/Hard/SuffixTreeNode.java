package Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class SuffixTreeNode {

	HashMap<Character, SuffixTreeNode> children;
	char value;
	ArrayList<Integer> indexes;
	
	public SuffixTreeNode() {
		children = new HashMap<Character, SuffixTreeNode>();
		indexes = new ArrayList<Integer>();
	}	
}

