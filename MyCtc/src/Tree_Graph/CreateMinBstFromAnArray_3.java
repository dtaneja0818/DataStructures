package Tree_Graph;

/*
 * 4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm 
 * to create a binary search tree with minimal height.
 */
public class CreateMinBstFromAnArray_3 {

	public TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static void main(String[] args) {
		CreateMinBstFromAnArray_3 obj = new CreateMinBstFromAnArray_3();
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = obj.createMinimalBST(array,0,9);
	}

}
