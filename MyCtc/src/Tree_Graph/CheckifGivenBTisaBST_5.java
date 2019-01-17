package Tree_Graph;
import java.util.*;
/*not working*/

/*class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

public class CheckifGivenBTisaBST_5{

	
	/* Approach:1 In-OrderTraversal
	 * 
	 */
	 
	private boolean isBstApproach1(TreeNode root){
		return false;
	}
	
	/*
	 * Approach:2	The Min / Max Solution
	 * When we branch left, the max gets updated. When we branch right, the min gets updated. 
	 * If anything fails these checks, we stop and return false.The time complexity for this 
	 * solution is 0(N), where N is the number of nodes in the tree. We can prove that this is 
	 * the best we can do, since any algorithm must touch all N nodes.Due to the use of recursion, 
	 * the space complexity is 0( log N) on a balanced tree.There are up to 0(log N) recursive calls 
	 * on the stack since we may recurse up to the depth of the tree
	 */
	private boolean isBstApproach2(TreeNode root){
		return chkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean chkBst(TreeNode root, int min, int max){
		if(root == null) return true;
		if(root.data > max || root.data <= min) return false;
		if(!chkBst(root.left, min, root.data) || !chkBst(root.right, root.data, max)) return false;
		return true;
	}
	
	/*
	 * Approach:3
	 */
	private boolean isBstApproach3(TreeNode root){
		if(root == null) return true;
		if(isSubTreeLesser(root.left,root.data) 
				&& isSubTreeGreater(root.right,root.data)
				&& isBstApproach3(root.left) 
				&& isBstApproach3(root.right))
			return true;
		else
			return false;
	}        

	private boolean isSubTreeLesser(TreeNode root, int value){
		if(root == null) return true;
		if(root.data <= value 
				&& isSubTreeLesser(root.left,value) 
				&& isSubTreeLesser(root.right,value))
			return true;
		else
			return false;
	}

	private boolean isSubTreeGreater(TreeNode root, int value){
		if(root == null) return true;
		if(root.data > value 
				&& isSubTreeGreater(root.left,value) 
				&& isSubTreeGreater(root.right,value))
			return true;
		else
			return false;

	}

	private void printTree(TreeNode root){
		if(root == null) return;
		System.out.print(root.data+"->");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args){
		/*Code To Test the logic
	    Creating an example tree
	            F
			  /   \
			 D     J
		    / \    /\
		   B   E  G  K
          /\       \ 
         A  C       I
                   /
                  H 
		 */
		CheckifGivenBTisaBST_5 chkBst = new CheckifGivenBTisaBST_5();
		TreeNode root = new TreeNode(1);
		TreeNode leftNode = new TreeNode(0);
		TreeNode rightNode = new TreeNode(3);
		root.left = leftNode;
		root.right = rightNode;
		chkBst.printTree(root);
		System.out.println();
		System.out.println("Is BST:"+chkBst.isBstApproach2(root));
	}
}
