package Easy;
import java.util.*;
/*
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal_102 {

	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
		if(root == null) return result;
		Queue q1 = new LinkedList();
		Queue q2 = new LinkedList();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		q1.add(root);

		while(!q1.isEmpty() || !q2.isEmpty()){

			while(!q1.isEmpty()){
				TreeNode temp =	(TreeNode)q1.poll();
				list.add(temp.val);
				if(temp.left != null) q2.add(temp.left);
				if(temp.right != null) q2.add(temp.right);
			}
			if(list.size() > 0)result.add(0,new ArrayList<Integer>(list));
			list.clear();
			while(!q2.isEmpty()){
				TreeNode temp =	(TreeNode)q2.poll();
				list.add(temp.val);
				if(temp.left != null) q1.add(temp.left);
				if(temp.right != null) q1.add(temp.right);
			}
			if(list.size() > 0)result.add(0,new ArrayList<Integer>(list));
			list.clear();
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_102 obj = new BinaryTreeLevelOrderTraversal_102();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);*/
		ArrayList<ArrayList<Integer>> result = obj.levelOrder(root);
		for(ArrayList a : result){
			System.out.println(a);
		}
	}
}
