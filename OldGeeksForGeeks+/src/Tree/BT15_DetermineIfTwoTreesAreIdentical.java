package Tree;
/*
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * Complexity of the identicalTree() will be according to the tree with lesser number of nodes. 
 * Let number of nodes in two trees be m and n then complexity of sameTree() is O(m) where m < n
 */

public class BT15_DetermineIfTwoTreesAreIdentical {

	public static boolean isIdentical(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null) return true;
		if(root1 != null && root2 != null){
			return ((root1.data == root2.data) && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right));
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(2);
		root1.left.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(5);
		//root1.right.right = new TreeNode(6);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(6);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.right.left = new TreeNode(5);
		root2.right.right = new TreeNode(6);

		System.out.println("Identical:"+isIdentical(root1,root2));
	}

}
