package DynamicProgramming;
/*
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 * http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
 * Time complexity: O ( n^2 )
 * Auxiliary Space: O ( n^2 )
 * https://www.youtube.com/watch?v=V-sEwsca1ak
 * 
 */
public class DP28_LongestPalindromicSubstring {

	// This function prints the longest palindrome substring of str[]. It also returns the length of the longest palindrome
	public int[] longestPalSubstrDynamic(String str){
		
		int n = str.length(); // get length of input string

		// table[i][j] will be false if substring str[i..j] is not palindrome. Else table[i][j] will be true
		int table[][] = new int[n][n];
		int result[] = new int[2];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for( int i = 0; i < n; ++i )
			table[i][i] = 1;

		// check for sub-string of length 2.
		int start = 0;
		for(int i = 0; i < n-1; ++i){
			if(str.charAt(i) == str.charAt(i+1)){
				table[i][i+1] = 1;
				start = i;
				maxLength = 2;
			}
		}

		// Check for lengths greater than 2. k is length of substring
		for(int k = 3; k <= n; ++k){
			// Fix the starting index
			for(int i = 0; i < n - k + 1 ; ++i){
				// Get the ending index of substring from starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to jth index iff str[i+1] to str[j-1] is a palindrome
				if(table[i+1][j-1] == 1 && str.charAt(i) == str.charAt(j)){
					table[i][j] = 1;

					if(k > maxLength){
						start = i;
						maxLength = k;
					}
				}
			}
		}
		
		result[0] = start;
		result[1] = start + maxLength - 1;
		//print(table);
		return result; // return length of LPS
	}
	
	private static void print(int[][] matrix){
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
	
	 /**
	  * O(N)
     * Linear time Manacher's algorithm to find longest palindromic substring.
     * There are 4 cases to handle
     * Case 1 : Right side palindrome is totally contained under current palindrome. In this case do not consider this as center.
     * Case 2 : Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrom will be found on right.
     * Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is proper prefix of current palindrome. Make largest such point as
     * next center.
     * Case 4 : Right side palindrome is proper suffix but its left corresponding palindrome is be beyond current palindrome. Do not consider this
     * as center because it will not extend at all.
     *
     * To handle even size palindromes replace input string with one containing $ between every input character and in start and end.
     */
    public int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        //preprocess the input to convert it into type abc -> $a$b$c$ to handle even length case.
        //Total size will be 2*n + 1 of this new array.
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }

        //create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;
        //here i is the center.
        for(int i=0; i < newInput.length; ) {
            //expand around i. See how far we can go.
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            //set the longest value of palindrome around center i at T[i]
            T[i] = end - start + 1;

            //this is case 2. Current palindrome is proper suffix of input. No need to proceed. Just break out of loop.
            if(end == T.length -1) {
                break;
            }
            //Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            int newCenter = end + (i%2 ==0 ? 1 : 0);

            for(int j = i + 1; j <= end; j++) {

                //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        //find the max palindrome in T and return it.
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
      /*      if(i%2 == 0) {
                val = (T[i] -1)/2;
            } else {
                val = T[i]/2;
            }*/
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }
    
    /*
     * Time complexity: O ( n^2 ) where n is the length of input string.
     * Auxiliary Space: O ( 1 )
     */
    public int longestPalSubstrApproach3(String str){
        int maxLength = 1;  // The result (length of LPS)
     
        int start = 0;
        int len = str.length();
     
        int low, high;
     
        // One by one consider every character as center point of even and length palindromes
        for (int i = 1; i < len; ++i){
            // Find the longest even length palindrome with center points
            // as i-1 and i.  
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                if (high - low + 1 > maxLength){
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
     
            // Find the longest odd length palindrome with center 
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                if (high - low + 1 > maxLength){
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }
        System.out.println("Longest palindrome substring is: "+str.substring(start, start + maxLength));
     
        return maxLength;
    }
    
	public static void main(String[] args) {
		DP28_LongestPalindromicSubstring obj = new DP28_LongestPalindromicSubstring();
		String s = "forgeeksskeegfor";
		int[] result = obj.longestPalSubstrDynamic(s);
		System.out.println(s.substring(result[0],result[1]+1)); 
		System.out.println(obj.longestPalindromicSubstringLinear(s.toCharArray()));
		System.out.println(obj.longestPalSubstrApproach3(s));
	}
}
