package Tree_Graph;

public class treeOperations {
//below function inserts value in a bst using recur
	public static TreeNode insertBST(int data,TreeNode root){
		TreeNode ptr=root;
		TreeNode temp=new TreeNode(data);
		if(ptr==null){
			root=temp;
		}
		else if(data<=root.data)
			ptr.left=insertBST(data,ptr.left);
		else
			ptr.right=insertBST(data,ptr.right);
		return root;
	}
	//below function inserts value in a bst using iteration
	public static TreeNode insertBSTUsingItr(int data,TreeNode root){
		TreeNode temp=new TreeNode(data);
		if(root==null){
			root=temp;
		}
		else 
		{
			TreeNode parentPtr=null;
			TreeNode nodePtr=root;
			while(nodePtr!=null){
				parentPtr=nodePtr;//parentptr to store the node where temp needs to be inserted
				if(data<=nodePtr.data)
					nodePtr=nodePtr.left;//move the nodeptr till the end left or right
				else
					nodePtr=nodePtr.right;
			}
			if(data<=parentPtr.data)//we have the parent node of the new node compare and insert
				parentPtr.left=temp;
			else
				parentPtr.right=temp;
		}
		return root;
	}
	public static void delete(TreeNode root){
		
	}
	//searching a node in a BST
	public static boolean scrhBST(int data,TreeNode root){
		if(root==null)return false;
		else if(root.data==data)return true;
		else if(data<root.data)
				 return scrhBST(data,root.left);
			else
				return scrhBST(data,root.right);
	}
	// will chk 2 trees are identical
	/*Algorithm:
		sameTree(tree1, tree2)
		1. If both trees are empty then return 1.
		2. Else If both trees are non -empty
		     (a) Check data of the root nodes (tree1->data ==  tree2->data)
		     (b) Check left subtrees recursively  i.e., call sameTree( 
		          tree1->left_subtree, tree2->left_subtree)
		     (c) Check right subtrees recursively  i.e., call sameTree( 
		          tree1->right_subtree, tree2->right_subtree)
		     (d) If a,b and c are true then return 1.
		3  Else return 0 (one is empty and other is not)
	 * */
	public static boolean isIdentical(TreeNode root1,TreeNode root2){
		if(root1==null	&& root2==null)return true;
		else if(root1!=null && root2!=null)
		{
			return (root1.data==root2.data && isIdentical(root1.left,root2.left)&& isIdentical(root1.right,root2.right));
		}
		return false;
	}
	//will count number of nodes in a tree recursively
	public static int countNode(TreeNode root){
		if (root==null) 
		    return 0;
		  else    
		    return(countNode(root.left) + 1 + countNode(root.right));  
	}
	/* Compute the "maxDepth" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.
    Algorithm:

	 maxDepth()
	1. If tree is empty then return 0
	2. Else
	     (a) Get the max depth of left subtree recursively  i.e., 
	          call maxDepth( tree->left-subtree)
	     (a) Get the max depth of right subtree recursively  i.e., 
	          call maxDepth( tree->right-subtree)
	     (c) Get the max of max depths of left and right 
	          subtrees and add 1 to it for the current node.
	         max_depth = max(max dept of left subtree,max depth of right subtree) + 1
	     (d) Return max_depth
	*/
	public static int maxDepth(TreeNode root){
		
		if(root==null){
			return 0;
		}
		return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	public static int minDepth(TreeNode root){
		
		if(root==null){
			return 0;
		}
		return 1+ Math.min(maxDepth(root.left),maxDepth(root.right));
	}
	/*Algorithm - Mirror(tree):

		(1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
		(2)  Call Mirror for right-subtree  i.e., Mirror(left-subtree)
		(3)  Swap left and right subtrees.
		          temp = left-subtree
		          left-subtree = right-subtree
		          right-subtree = temp
	 	Change a tree so that the roles of the  left and 
	    right pointers are swapped at every node.
	 
	 	So the tree...
	       4
	      / \
	     2   5
	    / \
	   1   3
	 
	 is changed to...
	       4
	      / \
	     5   2
	        / \
	       3   1
	*/
	public static void mirror(TreeNode root){
		TreeNode temp;
		if(root==null)
			return;
		else
		{
			/* do the subtrees */
			mirror(root.left);
			mirror(root.right);
			/* swap the pointers in this node */
			temp=root.left;
			root.left=root.right;
			root.right=root.left;
		}
	}
	//below fun will print the nodes by preorder traveral
	public static void print(TreeNode root){
		if(root==null)return;
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}
}


