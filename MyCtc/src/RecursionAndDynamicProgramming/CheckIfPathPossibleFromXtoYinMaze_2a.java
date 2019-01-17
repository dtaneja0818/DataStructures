package RecursionAndDynamicProgramming;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;
public class CheckIfPathPossibleFromXtoYinMaze_2a {

	public static int size = 4;
	public static int[][] maze;
	
	public static boolean isFree(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//Check using recursion
	public static boolean getPath(int x, int y, ArrayList<Point> path) {
		// If out of bounds or not available, return.
		if (y < 0 || x < 0 || !isFree(x, y)) {
			return false;
		}
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		
		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)) { 
			Point p = new Point(x, y);
			path.add(p);
			return true;
		}	
		return false;
	}	
	
	// check using DP
	public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		/* If out of bounds or not available, return.*/
		if (y < 0 || x < 0 || !isFree(x, y)) {
			return false;
		}
		Point p = new Point(x, y);
		
		/* If we've already visited this cell, return. */
		if (cache.containsKey(p)) { 
			return cache.get(p);
		}	
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		boolean success = false;
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(x, y - 1, path, cache) || getPath(x - 1, y, path, cache)) {
			path.add(p);
			success = true;
		}
		
		cache.put(p, success); // Cache result
		return success;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static String listOfPointsToString(ArrayList<Point> list) {
		StringBuilder buffer = new StringBuilder();
		for (Point p : list) {
			buffer.append("(" + p.x + "," + p.y + ")");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		maze  =  new int[][]{{1, 1, 1, 1},{1, 1, 0, 1},{0, 1, 0, 1},{1, 1, 1, 1}};
		CheckIfPathPossibleFromXtoYinMaze_2a.printMatrix(maze);
		ArrayList<Point> path = new ArrayList<Point>();
		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		boolean success = getPath(size - 1, size - 1, path, cache);
		
		if (success) {
			String s = CheckIfPathPossibleFromXtoYinMaze_2a.listOfPointsToString(path);
			System.out.println("Path: " + " " + s);			
		} else {
			System.out.println("No path exists.");
		}
	}
}
