package Easy;
/*
 * https://oj.leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion_6 {

	public String convert(String s, int nRows) {
		if (nRows == 1)		return s;
		StringBuilder builder = new StringBuilder();
		int step = 2 * nRows - 2;
		for (int i = 0; i < nRows; i++) {
			if (i == 0 || i == nRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					builder.append(s.charAt(j));
				}
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (nRows - 1 - i);
				int step2 = step - step1;
				while (j < s.length()) {
					builder.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion_6 obj = new ZigZagConversion_6();
		System.out.println(obj.convert("PAYPALISHIRING", 3));
	}
}
