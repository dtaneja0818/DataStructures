package Tree;
import java.util.*;
/*http://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/*/

public class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){
		data = x;
		this.left = null;
		this.right = null;
	}
	
	public static int depth(TreeNode root){
		return 0;
	}
	/*  This function traverses tree in post order to 
    to delete each and every node of the tree */
	public void deleteTree(TreeNode node){
	    if (node == null)
	        return;
	
	    /* first delete both subtrees */
	    deleteTree(node.left);
	    deleteTree(node.right);
	
	    /* then delete the node */
	    System.out.println("The deleted node is " + node.data);
	    node = null;
	}
	
	public static void print(TreeNode root){
		if(root == null) return;
		System.out.print(root.data+",");
		print(root.left);
		print(root.right);
	}
	public static void inOrderTraversal(TreeNode root){
		// Base Case
		if (root == null)   return;

		//keep the nodes in the path that are waiting to be visited
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.data);
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
	}
}
