package Easy;
/*
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class _101_SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }
    
    public boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(b == null || a == null) return false;
        
        if(a.val != b.val) return false;
        
        if(!isSymmetric(a.left,b.right)) return false;
        if(!isSymmetric(a.right,b.left)) return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		_101_SymmetricTree obj = new _101_SymmetricTree();
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(obj.isSymmetric(root));
	}
}
