package Easy;

//https://leetcode.com/problems/excel-sheet-column-title/

public class E_168_ExcelSheetColumnTitle {
	
	public String convertToTitle(int n) {
		StringBuilder sb  = new StringBuilder();
		while(n > 0){
			int rem = n%26;
			if(rem == 0){
				sb.append('Z');
				n = n/26 -1;
			}else{
				sb.append(Character.toChars((rem-1)+'A'));
				n = n/26;
			}
		}
		return new String(sb.reverse());
	}
	
	public static void main(String[] args) {
		E_168_ExcelSheetColumnTitle obj = new E_168_ExcelSheetColumnTitle();
		System.out.println(obj.convertToTitle(26));
		System.out.println(obj.convertToTitle(28));
	}
	
}
