package Tree_Graph;
/*
 * 4.1	Implement a function to check if a binary tree is balanced. For the purposes of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 */
public class ChkIsBlalaced_1 {

	/*
	 * On each node, we recurse through its entire subtree. This means that getHeight is 
	 * called repeatedly on the same nodes.The algorithm isthereforeO(N2 ).
	 */

	private int getHeight(TreeNode node){
		if(node == null) return 0;
		else{
			return Math.max(getHeight(node.left),getHeight(node.right))+1;
		}
	}
	
	private boolean isBalancedApproach1(TreeNode root){
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) return false;
		else return (isBalancedApproach1(root.left) && isBalancedApproach1(root.right));
	}
	/*
	 * If we inspect this method, we may notice that getHeight could actually check if the
	 * tree is balanced as the same time as it's checking heights. What do we do when we
	 * discover that the subtree isn't balanced? Just return -1.
	 * This improved algorithm works by checking the height of each subtree as we recurse
	 * down from the root. On each node, we recursively get the heights of the left and right
	 * subtrees through the checkHeight method. If the subtree is balanced, then checkHeight 
	 * will return the actual height of the subtree. If the subtree is not balanced, then
	 * checkHeight will return -1. We will immediately break and return -1 from the current call.
	 * 
	 * This code runs in 0(N) time and 0(H) space, where H is the height of the tree.
	 */

	private int checkHeight(TreeNode root){

		if(root == null) return 0;

		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;

		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;

		int diff = (leftHeight - rightHeight);
		if(Math.abs(diff) > 1) return -1;
		else return (Math.max(rightHeight,rightHeight)+1);
	}

	private boolean isBalancedApproach2(TreeNode root){
		if(checkHeight(root) == -1) return false;
		else return true;
	}

	public static void main(String[] args) {
		ChkIsBlalaced_1 obj = new ChkIsBlalaced_1();
		// Create balanced tree
		CreateMinBstFromAnArray_3 obj2 = new CreateMinBstFromAnArray_3();
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = obj2.createMinimalBST(array,0,9);
		System.out.println("Root: " + root.data);
		System.out.println("Is balanced: " + obj.isBalancedApproach2(root));

		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(unbalanced.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + obj.isBalancedApproach2(unbalanced));
	}
}
