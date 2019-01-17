package RecursionAndDynamicProgramming;

public class CountAllPossiblePathsFromXtoYinMaze_2b {
	
	public int[][] cache = new int[4][4];

	public int getPath(boolean[][] board, int source_x, int source_y, int dest_x, int dest_y){
		int x = source_x, y = source_y;
		int x_path, y_path;
		if(x == dest_x && y == dest_y)	return 1;
		else{
			if((x+1 > dest_x) || (!board[x+1][y]))	
				cache[x+1][y] = x_path = 0;
			else{
				if(cache[x+1][y] == -1)	
					cache[x+1][y] = x_path = getPath(board,x+1,y,dest_x,dest_y);
				else 
					x_path = cache[x+1][y];
			}
			
			if((y+1 > dest_y) || (!board[x][y+1]))	
					cache[x][y+1] = y_path = 0;
			else{
				if(cache[x][y+1] == -1)	
					cache[x][y+1] = y_path = getPath(board,x,y+1,dest_x,dest_y);
				else 
					y_path = cache[x][y+1];
			}
		}
		return (x_path + y_path);
	}
	
	public static void main(String[] args){
		CountAllPossiblePathsFromXtoYinMaze_2b m = new CountAllPossiblePathsFromXtoYinMaze_2b();
		boolean[][] maze = {	{true,true,true},  
								{true,true,true},  
								{true,true,true}
		};

		for(int i = 0;i<=2; i++)
			for(int j = 0;j<=2; j++)	
				m.cache[i][j] = -1;
				
		int paths = m.getPath(maze,0,0,2,2);
		System.out.println("Possible paths = "+Integer.toString(paths));
	}
}