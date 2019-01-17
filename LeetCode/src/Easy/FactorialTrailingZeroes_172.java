package Easy;
/*
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 */
public class FactorialTrailingZeroes_172 {

	public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
	public static void main(String[] args) {
		FactorialTrailingZeroes_172 obj = new FactorialTrailingZeroes_172();
		System.out.println("Trailing zereos:"+obj.trailingZeroes(1808548329));
	}

}
