package Medium;
/*
 * S_026: http://www.geeksforgeeks.org/write-your-own-atoi/
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class M_008_StringToIntegerAtoI {

	public static int atoi(String str) {
		if (str == null || str.length() < 1) return 0;
		// trim white spaces
		str = str.trim();
		char flag = '+';
		int i = 0;
		double result = 0;

		// check negative or positive
		if (str.charAt(0) == '-'){
			flag = '-';
			i++;
		}else if (str.charAt(0) == '+') {
			i++;
		}

		// calculate value
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-')	result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)	return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)	return Integer.MIN_VALUE;

		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(atoi("123"));
	}
}
