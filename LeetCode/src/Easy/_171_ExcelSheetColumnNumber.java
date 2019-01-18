package Easy;
/*
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 */
public class _171_ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int res = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			res += (int)(c - 'A' + 1) * Math.pow(26, s.length()-i-1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		_171_ExcelSheetColumnNumber obj = new _171_ExcelSheetColumnNumber();
		System.out.println("Col Num corresponding to Z is: "+obj.titleToNumber("Z"));	
	}
}
