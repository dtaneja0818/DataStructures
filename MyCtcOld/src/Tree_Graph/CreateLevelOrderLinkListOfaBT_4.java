package Tree_Graph;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * 
 * Here we have checked at each level if the level list already exists then add node to that list otherwise
 * create a new list
 */
 
public class CreateLevelOrderLinkListOfaBT_4 {

	private void getLevelOrderLL(ArrayList<LinkedList<TreeNode>> lists, TreeNode root, int level){
		if(root == null) return;
		LinkedList<TreeNode> list = null;
		
		if(lists.size() == level){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else{
			list = lists.get(level);
		}
		list.add(root);
		getLevelOrderLL(lists,root.left,level+1);
		getLevelOrderLL(lists,root.right,level+1);
	}

	private ArrayList levelOrderLL(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		if(root != null) 
			getLevelOrderLL(lists,root,0);
		return lists;
	}

	public static void main(String[] args) {
		CreateLevelOrderLinkListOfaBT_4 obj = new CreateLevelOrderLinkListOfaBT_4();
		
		CreateMinBstFromAnArray_3 obj2 = new CreateMinBstFromAnArray_3();
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = obj2.createMinimalBST(array,0,9);
		ArrayList<LinkedList<TreeNode>> lists = obj.levelOrderLL(root);
		
		for(int i = 0; i < lists.size(); i++){
			LinkedList<TreeNode> list = lists.get(i);
			System.out.print("Level-"+i+":");
			for(int j = 0; j < list.size(); j++){
				System.out.print(list.get(j).data+",");
			}
			System.out.println();
		}
	}
}
