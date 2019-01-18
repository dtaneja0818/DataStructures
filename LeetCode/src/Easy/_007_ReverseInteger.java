package Easy;
/*
 * https://oj.leetcode.com/problems/reverse-integer/
 * very good question
 */
public class _007_ReverseInteger {

	 public int reverse(int x) {
        int max = 1<<31; // 000000000......01 to 100000000......00
        int ret = 0;
    
        for (; x != 0; x/=10) { 
            if (ret != 0 && max/ret < 10 && max/ret > -10) return 0;
            ret = ret*10 + x%10; 
        }
        return ret;
    }

	public static void main(String[] args) {
		_007_ReverseInteger obj = new _007_ReverseInteger();
		System.out.println("Reversed number is: "+obj.reverse(-2147483412));
	}
}
