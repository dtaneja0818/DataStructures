package Array_String;
/*
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
 * 
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 */
public class SetEntireRowAndColTo_0_IfAnElemIs_0_InaMatrix_7 {


	private void setZero(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];	
		boolean[] col = new boolean[n];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(row[i] || col[j]) matrix[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		SetEntireRowAndColTo_0_IfAnElemIs_0_InaMatrix_7 obj =  new SetEntireRowAndColTo_0_IfAnElemIs_0_InaMatrix_7();
		int[][] matrix = {{1,2,3},{0,2,3},{1,2,0}} ;
		System.out.println("Input Matrix");
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print("|  "+matrix[i][j]+"   ");
			}
			System.out.print("|");
			System.out.println();
		System.out.println("----------------------");
		}
		obj.setZero(matrix);
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
	}
}
