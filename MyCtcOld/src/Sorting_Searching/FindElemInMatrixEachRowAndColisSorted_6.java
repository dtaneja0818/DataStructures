package Sorting_Searching;

/*
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 * 
 * 11.6 Given an MX N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 * 
 * The observations are the	following:
• If the start of a column is greater than x, then x is to the left of the column.
• If the end of a column is less than x, then x is to the right of the column.
• If the start of a row is greater than x, then x is above that row.
• If the end of a row is less than x, then x is below that row.
We can begin in any number of places, but let's begin with looking at the starts of columns.
We need to start with the greatest column and work our way to the left.This means that our first element for comparison is array [0] [ c -1], 
where c is the number of columns.
By comparing the start of columns to x (which is 55), we'll find that x must be in columns 0,1, or 2. We will have stopped at array [0] [2].
This element may not be the end of a row in the full matrix, but it is an end of a row of
a submatrix.The same conditions apply. The value at array [0] [2], which is 40, is less than 55, so we know we can move downwards.
We now have a submatrix to consider that looks like the following (the gray squares have been eliminated).
 */
 
public class FindElemInMatrixEachRowAndColisSorted_6 {

	private boolean search(int[][] matrix, int elem){
		int row = 0;
		int col = matrix[0].length-1;
		
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == elem) return true;
			else if(matrix[row][col] > elem) col--;
			else	row++;
		}
		return false; 
	}
	
	private void printMatrix(int[][] matrix){
		System.out.println("Output Matrix");
				System.out.println("--------------------------------------");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
		System.out.println("----------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		FindElemInMatrixEachRowAndColisSorted_6 obj = new FindElemInMatrixEachRowAndColisSorted_6();
		int M = 5;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		obj.printMatrix(matrix);
		System.out.println("Mila ke nhi:"+obj.search(matrix,120));
	}

}
