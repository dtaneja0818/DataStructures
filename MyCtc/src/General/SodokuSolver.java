package General;
/*RubyQuiz# Sodoku Solver (#43)
Sodokus are simple number puzzles that often appear in various sources of print. 
The puzzle you are given is a 9 x 9 grid of numbers and blanks, that might look something like this:
+-------+-------+-------+
| _ 6 _ | 1 _ 4 | _ 5 _ |
| _ _ 8 | 3 _ 5 | 6 _ _ |
| 2 _ _ | _ _ _ | _ _ 1 |
+-------+-------+-------+
| 8 _ _ | 4 _ 7 | _ _ 6 |
| _ _ 6 | _ _ _ | 3 _ _ |
| 7 _ _ | 9 _ 1 | _ _ 4 |
+-------+-------+-------+
| 5 _ _ | _ _ _ | _ _ 2 |
| _ _ 7 | 2 _ 6 | 9 _ _ |
| _ 4 _ | 5 _ 8 | _ 7 _ |
+-------+-------+-------+
 * */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class SodokuSolver {
	private static int size = 9;
	private static int rows = size * size * size;
	private static int cols = 4 * size * size;
		
	public static void main(String[] args) {
		//printMatrix();
		try {
			InputStream in = System.in;
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int noOfTestCases = Integer.parseInt(br.readLine());
			for (int tCase = 1; tCase <= noOfTestCases; tCase++) {
				SBoard game = new SBoard();
				for(int i=0;i<size;i++) {
					String[] values = br.readLine().split(" ");
					for(int j=0;j<size;j++) {
						int v = Integer.parseInt( values[j] ) ;
						game.board[i][j] = v;
						if( v!= 0) {
							int mr = i*size*size + j*size + v-1;
							ArrayList<Node> colList = getColFromRow(mr, game);
							for(Node n:colList) {
								deleteCol(n,game);
							}
							//printMatrix(game);
						}
					}
				}
				SodokuSolver s = new SodokuSolver();
				s.algoX(game,0);
				printSol(game);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void printSol(SBoard game) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				for(Node n: game.solSet) {
					if(n.row == i && n.col == j) {
						game.board[i][j] = n.value +1;
					}
				}
			}
		}
		game.printBoard();
	}
	
	boolean algoX(SBoard game, int ins) {
		String msg = "";
		for(int i=0;i<=ins;i++) {
			msg = msg + "    ";
		}
		//if thre is a col with valu 0, this cannot be solvee
		ins = ins + 1;
		ArrayList<Node> colList = getColWithLeastOnes(game);
		
		if(colList == null || colList.isEmpty() || game.solved) {
			return false;
		}
		
		for(Node col:colList) {
			ArrayList<Node> rowList = getRowListForCol(col, game);
			//every row is a possible candidate for a sol.
			String msg2 = "Possible candidates for sol r:";
			for(Node row:rowList) {
				msg2 = msg2 + row.kmr + " ";
			}
			
			for(Node row:rowList) {
				if(game.solved == true) {
					return true;
				}
				game.solSet.push(row);
				ArrayList<Node> cl = getColFromRow(row.kmr, game);
				for(Node co:cl) {
					coverCol(co, game, ins);
				}
				if(game.solved()) {
					return true;
				} else {
					if(game.canWeProceed()) {
						if( !algoX(game,ins) ) {
							//unroll
						} else {
							return true;
						}
					} else {
						//System.out.println("ALERT -- Cannot Proceed -- uncover wht we did : instance" + ins);
						
					}
				}
				game.solSet.pop();
				for(Node co:cl) {
					uncover(game, ins);
				}
			}
			break;
		}
		return false;
	}
	
	void uncover(SBoard game, int ins) {
		//1.pop the solution added to solution set
		//2.add the nodes deleted
		Node head = game.stackNodes.peek();
		if( head.header != true) {
			System.out.println("unrolling but did not get header -- is this error in logic?");
			System.exit(0);
		}
		head = game.stackNodes.pop();
		uncoverHead(game, head, ins);
		Node n;
		while((n = game.stackNodes.peek()) != null) {
			if(n.header == true) {
				break;
			}
			n = game.stackNodes.pop();
			uncoverNode(game, head, n);
		}
	}
	
	void uncoverHead(SBoard game, Node head, int ins) {
		String msg = "    ";
		for(int i=0;i<=ins;i++) {
			msg = msg + "    ";
		}
		head.left.right = head;
		head.right.left = head;
		game.mControlRow.add(head);
	}

	void uncoverNode(SBoard game, Node head, Node n) {
		//System.out.print("uncovr: " + n.kmr + "," + n.kmc + " ");
		n.left.right = n;
		n.right.left = n;
		n.top.bottom = n;
		n.bottom.top = n;
		for(int i=0;i<game.mControlRow.size();i++) {
			if(head.kmc == game.mControlRow.get(i).kmc) {
				game.mControlRow.get(i).count = game.mControlRow.get(i).count +1; 
			}
		}
	}
	
	static void coverCol(Node colIndex, SBoard game, int ins) {
		String msg = "";
		for(int i=0;i<=ins;i++) {
			msg = msg + "    " ;
		}
		ArrayList<Node> newContRow = new ArrayList<Node>();
		
		for(Node n : game.mControlRow) {
			if(n.kmc == colIndex.kmc) {
				//this is the one
				
				Node x = n.bottom;
				while(x != n) {
					coverRow(x, game);
					x=x.bottom;
				}
				game.stackNodes.push(n);
			} else {
				newContRow.add(n);
			}
		}
		game.mControlRow = newContRow; 
	}
	
	static void coverRow(Node n, SBoard game) {
		//delete the node and decrease their respective header value
		while(n.right != n) {
			n.right.left = n.left;
			n.left.right = n.right;
			n.top.bottom = n.bottom;
			n.bottom.top = n.top;
			game.stackNodes.push(n);
			decreaseHeaderCount(n, game);
			n = n.right;
		}
		n.top.bottom = n.bottom;
		n.bottom.top = n.top;
		game.stackNodes.push(n);
		decreaseHeaderCount(n,game);
	}
	
	
	
	static ArrayList<Node> getRowListForCol(Node col, SBoard game) {
		ArrayList<Node> l = new ArrayList<Node>();
		
		for(Node n:game.mControlRow) {
			if(n.kmc == col.kmc) {
				Node x = n.bottom;
				while( x != n ) {
					l.add(x);
					x = x.bottom;
				}
			}
		}
		
		return l;
	}
	
	
	static ArrayList<Node> getColWithLeastOnes(SBoard game) {
		int least = Integer.MAX_VALUE;
		ArrayList<Node> l = new ArrayList<Node>();
		
		for(Node x:game.mControlRow){
			if(x.count < least ){
				least = x.count;
				l.clear();
				l.add(x);
			} else if(x.count == least ) {
				l.add(x);
			}
		}
		if(least == 0) {
			return null;
		}
		return l;
	}

	/* the row number is of matrix not sudoku board*/
	static ArrayList<Node> getColFromRow (int row, SBoard game) {
		ArrayList<Node> colList = new ArrayList<Node>();
		
		for(Node n : game.mControlRow) {
			Node x = n.bottom;
			while(x != n) {
				if(x.kmr == row) {
					colList.add(x);
					break;
				}
				x = x.bottom;
			}
		}
		return colList;
	}
	
	//col index is the col no of knuth matrix
	static void deleteCol(Node node, SBoard game) {
		ArrayList<Node> newContRow = new ArrayList<Node>();
		
		for(Node n : game.mControlRow) {
			if(n.kmc == node.kmc) {
				//this is the one
				Node x = n.bottom;
				while(x != n) {
					deleteRow(x, game);
					x=x.bottom;
				}
			} else {
				newContRow.add(n);
			}
		}
		game.mControlRow = newContRow; 
	}
	
	static void deleteRow(Node n, SBoard game) {
		//delete the node and decrease their respective header value
		while(n.right != n) {
			n.right.left = n.left;
			n.left.right = n.right;
			n.top.bottom = n.bottom;
			n.bottom.top = n.top;
			decreaseHeaderCount(n, game);
			n = n.right;
		}
		n.top.bottom = n.bottom;
		n.bottom.top = n.top;
		decreaseHeaderCount(n,game);
	}
	
	static void decreaseHeaderCount(Node n, SBoard game) {
		for(int i=0;i<game.mControlRow.size();i++) {
			if(game.mControlRow.get(i).kmc == n.kmc) {
				game.mControlRow.get(i).count = game.mControlRow.get(i).count - 1; 
			}
		}
	}
	
	static class Node {
		Node top = null;
		Node bottom = null;
		Node left = null;
		Node right = null;
		boolean header = false;
		int count = -1;
		
		int kmr = -1;
		int kmc = -1;
		
		int value=-1;
		int row=-1, col=-1;
		
		Node(int row, int col, int val, int kmr, int kmc) {
			this.row = row;
			this.col = col;
			this.value = val;
			this.kmc = kmc;
			this.kmr = kmr;
		}
	}
	static class SBoard {
		private Node[][] init_matrix = new Node[rows][cols];
		
		int[][] board = new int[size][size];
		boolean solved = false;
		
		ArrayList<Node> mControlRow;
		Stack<Node> solSet = new Stack<Node>();
		Deque<Node> stackNodes = new ArrayDeque<Node>();
		
		SBoard() {
			mControlRow = new ArrayList<Node>();
			init();
			initContrlRow();
			
		}
		
		boolean solved() {
			if(mControlRow.size() == 0) {
				solved = true;
				}
			return solved;
		}
		boolean canWeProceed() {
			if(solved) {
				return false;
			}
			ArrayList<Node> colL = getColWithLeastOnes(this);
			if(colL == null) {
				return false;
			}
			return true;
		}
		
		void printBoard() {
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println("");
			}
		}
		
		private void init() {
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					for(int k=0;k<size;k++){
						int matrixRow = i* size*size + j*size + k ;
						//rule 1: every cell one value
						int matrixCol_r1 = i*size + j;
						Node cell = new Node(i,j,k,matrixRow, matrixCol_r1 );
						init_matrix[matrixRow][matrixCol_r1] = cell;
						
						//rule2: values 1-4 in each row
						int matrixCol_r2 = size*size + i*size +  k;
						Node row = new Node(i,j,k,matrixRow, matrixCol_r2);
						init_matrix[matrixRow][matrixCol_r2] = row;
						
						//rule3: values 1-4 in each colm
						int matrixCol_r3 = 2* size*size  + j*size + k ;
						Node col = new Node(i,j,k,matrixRow, matrixCol_r3);
						init_matrix[matrixRow][matrixCol_r3] = col;
						
						//rule4:block constraint b1v1, b1v2..b2v1...b9v9
						int boxSize = (int)Math.sqrt(size);
						int gr = i/boxSize;
						int gc = j/boxSize;
						int boxNo = gr*boxSize + gc;
						int matrixCol_r4 = 3*size*size + boxNo*size+k;
						Node block = new Node(i,j,k,matrixRow, matrixCol_r4) ;
						init_matrix[matrixRow][matrixCol_r4] = block;
						
						cell.right = row;
						row.left = cell;
						row.right = col;
						col.left = row;
						col.right = block;
						block.left = col;
						block.right = cell;
						cell.left = block;
					}
				}
			}
		}
		
		private void initContrlRow() {
			mControlRow = new ArrayList<Node>();
			//rows have already been linked
			//link all colms
			for(int j=0;j<cols;j++) {
				Node colHead = new Node(-1,-1,-1, -1, j);
				mControlRow.add(colHead);
				colHead.header=true;
				Node curr=null, prev=null, first=null;
				int count = 0;
				for(int i=0;i<rows;i++) {
					if(init_matrix[i][j] != null ) {
						count = count+1;
						if(prev == null) {
							first = prev = init_matrix[i][j]; 
						} else if(prev != null && curr == null){
							curr = init_matrix[i][j];
							prev.bottom = curr;
						} else {
							curr.top = prev;
							curr.bottom = init_matrix[i][j];
							
							prev = curr;
							curr = init_matrix[i][j];
							curr.top = prev;
						}
					}
				}
				if(curr != null && first != null) {
					curr.bottom = colHead;
					colHead.top = curr;
					colHead.bottom = first;
					first.top = colHead;
				}
				colHead.count = count;
			}
			for(int i=0;i<mControlRow.size();i++) {
				if(i==0) {
					mControlRow.get(i).right = mControlRow.get(i+1);
					mControlRow.get(i).left = mControlRow.get(mControlRow.size()-1);
				} else if(i==mControlRow.size()-1) {
					mControlRow.get(i).right = mControlRow.get(0);
					mControlRow.get(i).left = mControlRow.get(i-1);
				} else {
					mControlRow.get(i).right = mControlRow.get(i+1);
					mControlRow.get(i).left = mControlRow.get(i-1);
				}
			}
		}
	}
}
