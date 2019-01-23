package Easy;
/*
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class E_058_LengthOfLastWord {

	public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        int i = n-1,len = 0;
        
        while(i >= 0){
        	if(s.charAt(i) == ' ') break;
        	len++;
        	i--;
        }
        return len;
    }
    
	public static void main(String[] args) {
		E_058_LengthOfLastWord	obj = new E_058_LengthOfLastWord();
		System.out.println("Length is: "+obj.lengthOfLastWord("a "));
	}
}
