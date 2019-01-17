package RecursionAndDynamicProgramming;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 9.8	Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
 * and pennies (1 cent), write code to calculate the number of ways of representing n
 * cents.
 * 
 * Solution
 * here we frame a table inputarr X amount
 */
 
public class CoinChange_8 {

	private int countCoins(int[] arr, int amount){
		int len = arr.length;
		int[][] table = new int[len][amount+1];
		// Fill the enteries for 0 value case (n = 0)
    	for (int i = 0; i < len; i++)
        	table[i][0] = 1;
        
        for(int i = 1;i < amount+1;i++){
        	for(int j = 0;j < len;j++){
        		// Count of solutions including S[j]
        		int x = (i - arr[j]>=0)?table[j][i - arr[j]]:0;
        		// Count of solutions excluding S[j]
        		int y =(j >= 1)? table[j-1][i]: 0;
        		// total count
        		table[j][i] = x + y; 
        	}
        }
        return table[len-1][amount];
	}
	
	public static void main(String[] args) {
		CoinChange_8 obj = new CoinChange_8();
		int[] input = {1,5,10,25};
		System.out.println(obj.countCoins(input, 1));
	}

}
