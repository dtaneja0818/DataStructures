package General;
import java.util.Scanner;

/* RubyQuiz#124 Magic Squares
 * Generates a magic square of order N. A magic squares is an N-by-N
 * matrix of the integers 1 to N^2, such that all row, column, and diagonal sums are equal.
 *
 * MagicSquare 3
 *   4  9  2 
 *   3  5  7 
 *   8  1  6 
 *
 *  Limitations
 *  -----------
 *   - N must be odd*/

import java.util.*;
public class MagicSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter order of matrix(N must be odd)");
		int N=in.nextInt();
        if (N % 2 == 0) throw new RuntimeException("N must be odd");

        int[][] magic = new int[N][N];

        int row = N-1;
        int col = N/2;
        magic[row][col] = 1;

        for (int i = 2; i <= N*N; i++) {
            if (magic[(row + 1) % N][(col + 1) % N] == 0) {
                row = (row + 1) % N;
                col = (col + 1) % N;
            }
            else {
                row = (row - 1 + N) % N;
                // don't change col
            }
            magic[row][col] = i;
        }

        // print results
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
                if (magic[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }


	}

}
