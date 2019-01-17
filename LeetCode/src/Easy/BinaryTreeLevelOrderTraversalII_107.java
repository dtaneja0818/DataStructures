package Easy;
import java.util.*;
/*
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII_107 {

	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        levelOrderBottomHelper(root, result, 1);
        return result;
    }
    
    public void levelOrderBottomHelper(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth) {
        if (root == null)  return;
        ArrayList<Integer> list;
        // means list already available for current level
        if (result.size() < depth) {
            list = new ArrayList<Integer>();
            result.add(0, list);
        } else {
            list = result.get(result.size() - depth);
        }
        list.add(root.val);
        levelOrderBottomHelper(root.left, result, depth+1);
        levelOrderBottomHelper(root.right, result, depth+1);
    }
    
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII_107 obj = new BinaryTreeLevelOrderTraversalII_107();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> result = obj.levelOrderBottom(root);
		for(ArrayList a : result){
			System.out.println(a);
		}
	}
}
