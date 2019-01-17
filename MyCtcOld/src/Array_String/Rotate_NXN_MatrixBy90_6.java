package Array_String;

/* http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * 1.6 
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 * Solution
 * Learn it difficult question
 * The rotation can be performed in layers when we perform a cyclic swap on the edges on 
 * each layer. In the first for loop,we rotate the first layer(outermost edge).
 * we rotate the edges by doing a four way swap first on the corners then on the elem clockwise
 * from the edges then on the element three steps away.
 *
 */

public class Rotate_NXN_MatrixBy90_6 {

//	private void rotateMatrix(int[][] mat, int flag){
//		// An Inplace function to rotate a n x n matrix
//		// by 90 degrees in anti-clockwise direction
//		int n = mat.length;
//		if(flag == 0){
//			// Consider all squares one by one
//			for (int x = 0; x < n / 2; x++){
//				// Consider elements in group of 4 in 
//				// current square
//				for (int y = x; y < n-x-1; y++){
//					// store current cell in temp variable
//					int temp = mat[x][y];
//
//					// move values from right to top
//					mat[x][y] = mat[y][n-1-x];
//
//					// move values from bottom to right
//					mat[y][n-1-x] = mat[n-1-x][n-1-y];
//
//					// move values from left to bottom
//					mat[n-1-x][n-1-y] = mat[n-1-y][x];
//
//					// assign temp to left
//					mat[n-1-y][x] = temp;
//				}
//			}
//		}else{
//			// clockwise
//			for (int i = 0; i < n / 2; i++) {
//				for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
//					int temp = mat[i][j];
//					mat[i][j] = mat[n-1-j][i];
//					mat[n-1-j][i] = mat[n-1-i][n-1-j];
//					mat[n-1-i][n-1-j] = mat[j][n-1-i];
//					mat[j][n-1-i] = temp;
//				}
//			}
//		}
//	}
//	int [][] rotate(int [][] input){
//
//		int n =input.length;
//		int m = input[0].length;
//		int [][] output = new int [m][n];
//
//		for (int i=0; i<n; i++)
//			for (int j=0;j<m; j++)
//				output [j][n-1-i] = input[i][j];
//		return output;
//		}
//	int [][] rotateanti(int [][] input){
//
//		int n =input.length;
//		int m = input[0].length;
//		int [][] output = new int [m][n];
//
//		for (int i=0; i<n; i++)
//			for (int j=0;j<m; j++)
//				output [j][n-1-i] = input[i][j];
//		return output;
//		}
	private static void transpose(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }
	public static void swapRows(int[][] m) {
	    for (int i = 0, k = m.length - 1; i < k; ++i, --k) {
	        int[] x = m[i];
	        m[i] = m[k];
	        m[k] = x;
	    }
	}

	public static void rotateByNinetyToLeft(int[][] m) {
	    transpose(m);
	    swapRows(m);
	}

	public static void rotateByNinetyToRight(int[][] m) {
	    swapRows(m);
	    transpose(m);
	}
	
	public static void main(String[] args) {
		Rotate_NXN_MatrixBy90_6 obj = new Rotate_NXN_MatrixBy90_6();
		int[][] matrix = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}} ;
		System.out.println("Input Matrix");
		System.out.println("MXN");
		System.out.println("Input Matrix");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("----------------------");
		}
		obj.rotateByNinetyToLeft(matrix);
		System.out.println("Output Matrix");
		System.out.println("----------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("----------------------");
		}
		System.out.println("Input Matrix");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("----------------------");
		}
		obj.rotateByNinetyToRight(matrix);
		System.out.println("Output Matrix");
		System.out.println("----------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
			System.out.println("----------------------");
		}
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[0].length; j++){
//				System.out.print("|  "+matrix[i][j]+"   ");
//			}
//			System.out.print("|");
//			System.out.println();
//			System.out.println("----------------------");
//		}
//		obj.rotateMatrix(matrix, 0);
//		System.out.println("Output Matrix");
//		System.out.println("----------------------");
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[0].length; j++){
//				System.out.print("|  "+matrix[i][j]+"   ");
//			}
//			System.out.print("|");
//			System.out.println();
//			System.out.println("----------------------");
//		}
//
//		System.out.println("CLOCKWISE");
//		System.out.println("Input Matrix");
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[0].length; j++){
//				System.out.print("|  "+matrix[i][j]+"   ");
//			}
//			System.out.print("|");
//			System.out.println();
//			System.out.println("----------------------");
//		}
//		obj.rotateMatrix(matrix, 1);
//		System.out.println("Output Matrix");
//		System.out.println("----------------------");
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[0].length; j++){
//				System.out.print("|  "+matrix[i][j]+"   ");
//			}
//			System.out.print("|");
//			System.out.println();
//			System.out.println("----------------------");
//		}
	}
}
