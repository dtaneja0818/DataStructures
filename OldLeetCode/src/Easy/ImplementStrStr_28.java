package Easy;
/*
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr_28 {

	public int strStr(String haystack, String needle) {
		if(haystack == null && needle == null)return -1;
		if(haystack == "" && needle == "") return 0;
		
		int len1 = haystack.length();
		int len2 = needle.length();
		int i = 0,j = 0;
		for(i = 0;i < len1;i++){
			for(j = 0;j < len2;j++){
				if(((i+j) >= len1) || haystack.charAt(i+j) != needle.charAt(j)) break;
			}
			if(j == len2) return i;
		}
		return -1;
    }
    
	public static void main(String[] args) {
		ImplementStrStr_28 obj = new ImplementStrStr_28();
		System.out.println(obj.strStr("","nitin"));
	}
}
