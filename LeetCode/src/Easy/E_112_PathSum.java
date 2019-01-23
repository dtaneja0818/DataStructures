package Easy;
/*
 * https://oj.leetcode.com/problems/path-sum/
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class E_112_PathSum {

	public boolean hasPathSum(TreeNode root, int x) {
		if(root == null) return false;
		return sum(root,x,0);
	}

	public boolean sum(TreeNode root, int x, int currentSum){

		if(root == null) return false;
		currentSum += root.val;

		if(root.left == null && root.right == null){
			if(currentSum == x)	return true;
		}
		else{
			return (sum(root.left, x,currentSum) || sum(root.right, x,currentSum));
		}
		return false;
	}

	public static void main(String[] args) {
		E_112_PathSum obj = new E_112_PathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		//root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		System.out.println(obj.hasPathSum(root,20));
	}
}
