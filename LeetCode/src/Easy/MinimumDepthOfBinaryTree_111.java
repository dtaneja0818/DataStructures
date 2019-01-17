package Easy;
/*
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */

public class MinimumDepthOfBinaryTree_111 {

	public int minDepth1(TreeNode root) {
	
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null) left = minDepth1(root.left);
        if(root.right != null) right = minDepth1(root.right);
        return (Math.min(left,right) + 1);
    }
    // clear solution
    public int minDepth2(TreeNode root) {
	
        if(root == null) return 0;
        if(root.left == null){
        	return 1+minDepth2(root.right);
        }
        if(root.right == null){
        	return 1+minDepth2(root.left);
        }
        return (Math.min(minDepth2(root.left),minDepth2(root.right)) + 1);
    }
    
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree_111 obj = new MinimumDepthOfBinaryTree_111();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);*/
		System.out.println("Min Depth:"+obj.minDepth2(root));
	}
}
