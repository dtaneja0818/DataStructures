package BitManipulation;
/*5.1
You are given two 32-bit numbers, N and M, and two bit positions, land j. Write
a method to insert M into N such that M starts at bit j and ends at bit i. You can
assume that the bits j through i have enough space to fit all of M. That is, if
M = 10011, you can assume that there are at least 5 bits between j and i. You
would not, for example, have j = 3 and i = 2, because M could not fully fit
between bit 3 and bit 2.
EXAMPLE
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100

Solution:
This problem can be approached in three key steps:
1. Clear the bits j through i in N
2. Shift M so that it lines up with bits j through i
3. Merge M and N.
*/

public class InsertMintoN_NC_1 {

	public static void main(String[] args) {
		
	}

}
