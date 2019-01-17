package RecursionAndDynamicProgramming;
/*9.9
 * Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess
 * board so that none of them share the same row, column or diagonal. In this case,
 * "diagonal" means all diagonals, not just the two that bisect the board.
*/
public class NQueen_9 {

	private boolean solveNQueen(int[][] board, int n){
		int row = board.length;
		int col = board[row-1].length;
		if(n > col) return false;
		if(solve(board,0,n))
			return true;
		return false;
	}
	// Here we are placing queen across the row keeping col constant
	private boolean solve(int[][] board, int col, int queen){
		int len = board.length;
		if(queen == 0) return true;
		if(col >= len && queen != 0) return false;
		for(int i = 0; i < len;i++){
			if(isSafe(board,i,col)){
				board[i][col] = 1;
				queen--;
				//System.out.println("placing 1 in:"+i+","+col+" queen count is:"+queen);
				boolean result = solve(board,col+1,queen);
				if(result) return true;
				else{
					System.out.println("Bactrack");
					board[i][col] = 0;
					queen++;
				}
			}
		}
		return false;
	}
	
	private boolean isSafe(int[][] board, int row, int col){
		//System.out.println("checking:"+row+","+col);
		int i,j;
		int len = board.length;
		//check for left side of the queen cordinates keeping row constant, starting from 0 to col
		for(i = 0; i < col; i++){
			if(board[row][i] == 1) return false;
		}
		
		//check for upper left diagonal
		for(i = row, j = col;i < len && j >= 0;i++,j--){
			if(board[i][j] == 1) return false;
		}
		
		//check for lower left diagonal
		for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
			if(board[i][j] == 1) return false;
		}
		return true;
	}
	
	private void printMatrix(int[][] temp){
		int row = temp.length;
		int col = temp[row-1].length;
		for(int i = 0;i < row;i++){
			for(int j = 0;j < col; j++){
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		NQueen_9 obj = new NQueen_9();
		int[][] input = {{0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						};
		System.out.println("Input Matrix:");
		obj.printMatrix(input);
		System.out.println("Output Matrix:");
		System.out.println("RESULT:"+obj.solveNQueen(input,8));
		if(obj.solveNQueen(input,5))
				obj.printMatrix(input);
	}
}
