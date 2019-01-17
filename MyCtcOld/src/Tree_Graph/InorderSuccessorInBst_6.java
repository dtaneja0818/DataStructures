package Tree_Graph;
import java.util.*;

public class InorderSuccessorInBst_6{
    
/*
 * 4.6 Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 * 
 * Answer:
 * Here we are trying to find the inorder successor we can do so by simple
 * traversing too but that wud give us a complexity of O(n). We can reduce the 
 * complexity by having 3 cases.
 * 
 * case 1: If the node to be visited has a right subtree: then we need to find the
 * min in the right subtree or we can go deep to leftmost node in right subtree.
 * 
 * case 2: If there is no right subtree: then we need to go to the parent which 
 * also has 2 cases;
 *      case a: If we are going to parent from left: In this case the parent is not
 *      visited yet so it wud be the inorder successor.
 *      
 *      case b: If we are going to parent from right: In this case the parent is
 *      already visited so we need to go to the parent of parent.(ie go to the
 *      nearest ancestor for which given node would be in left subtree.)
 */

    public TreeNode getInorderSuccessor(TreeNode root, int input){
        //search the node = O(h)
        TreeNode current = find(root,input);
        if(current == null) return current;
        //case 1: TreeNode has right subtree
        if(current.right != null) return min(current.right); // O(h)
        //case 2: No right subtree  O(h)
        else{
            TreeNode successor = null;
            TreeNode ancestor = root;
            while(ancestor != current){
                if(ancestor.data > current.data){
                  //so far this is the deepest node for which current node is in left
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
                else
                    ancestor = ancestor.right;
            }
            return successor;
        }
   }

    public TreeNode min(TreeNode root) throws IllegalStateException{
        if(root == null) return null;
        TreeNode ptr = root;
        while(ptr.left != null) ptr = ptr.left;
        return ptr;
    }

    public TreeNode find(TreeNode root, int input){
        if(root == null) return null;
        else if(input == root.data) return root;
        else if(input < root.data) return find(root.left, input);
        else return find(root.right, input);
    }

    //Function to visit nodes in Inorder
    public void inorder(TreeNode root) {
    	if(root == null) return;
 	    inorder(root.left);       //Visit left subtree
	    System.out.print(root.data+",");  //Print data
	    inorder(root.right);      // Visit right subtree
    }

    public void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.data+"->");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){
        /*Code To Test the logic
	        Creating an example tree
	            30
			  /    \
			20      40
		   /  \    /  \
		 15    25 35  45
     
       */
       	
        InorderSuccessorInBst_6 insucc = new InorderSuccessorInBst_6();
        CreateMinBstFromAnArray_3 obj = new CreateMinBstFromAnArray_3();
		int[] array = {15,20,25,30,35,40,45};
		TreeNode root = obj.createMinimalBST(array,0,6);
		
        System.out.println("Tree is:");
        insucc.printTree(root);
        System.out.println();
        System.out.println("Inorder Traversal is:");
        insucc.inorder(root);
        System.out.println();
        if(insucc.getInorderSuccessor(root,30) == null)
            System.out.println("InorderSuccessor is:null");
        else
            System.out.println("InorderSuccessor is:"+insucc.getInorderSuccessor(root,30).data);
    }
}
