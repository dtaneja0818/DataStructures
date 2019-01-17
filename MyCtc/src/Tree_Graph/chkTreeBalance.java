/*For a tree to be balanced the difference between the max and min depth shud not exceed by 1
 * */
package Tree_Graph;

public class chkTreeBalance {

	public static treeOperations t=new treeOperations();
	public static void main(String[] args) {
		TreeNode root=null;
		root=t.insertBST(2,root);
		root=t.insertBST(1,root);
		root=t.insertBST(3,root);
		root=t.insertBST(0,root);
		root=t.insertBST(4,root);
		t.print(root);
		//System.out.println(t.maxDepth(root));
		boolean res=isBalanced(root);
		if(res)System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
	
	public static boolean isBalanced(TreeNode root){
		if(t.maxDepth(root)-t.minDepth(root)>=1)return false;
		else
			return true;
	}

}
