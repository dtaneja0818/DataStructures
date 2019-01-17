package Tree_Graph;

import java.util.*;

public class TreeNode{
    public int data;
    public int size;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.size = 1;
    }
    
    public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	public void insertInOrder(int d){
		
		if (d <= data) {
			if (left == null) {
				System.out.println("inserting left:"+d);
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				System.out.println("inserting right:"+d);
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	// To insert data in BST, returns address of root node
    public TreeNode insert(TreeNode root, int input){
        // empty tree
        if(root == null){
            TreeNode newNode = new TreeNode(input);
            root = newNode;
         }
        else{
            // if data to be inserted is lesser, insert in left subtree.
            if(input <= root.data)
                root.left = insert(root.left,input);
            // else, insert in right subtree.
            else
                root.right = insert(root.right,input);
        }
        return root;
    }
}
