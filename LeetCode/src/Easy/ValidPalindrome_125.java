package Easy;
/*
 * https://oj.leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome_125 {

	public boolean isPalindrome(String s) {
        if(s == null || s == "") return true;
        
        int n = s.length();
        
        for(int i = 0,j = n-1;i < j;i++,j--){
        	
        	while(i < j && !(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))))i++;
        	while(i < j && !(Character.isLetter(s.charAt(j)) || Character.isDigit(s.charAt(j))))j--;
        	
        	if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		ValidPalindrome_125 obj = new ValidPalindrome_125();
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panam"));
	}
}
