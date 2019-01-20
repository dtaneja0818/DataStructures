package Array_String;
/*
 * http://www.geeksforgeeks.org/run-length-encoding/
 * 1.5 Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 */
public class E6_6_PerformBasicStringCompression {

	public String compress(String str){
	
		int len = str.length();
		// advantage of getting compressed size before hand is that we initialize sb with appropriate capacity
		int finalLength = compressedSize(str);
		if(finalLength >= str.length()) return str;
		
		StringBuffer sb = new StringBuffer(finalLength);
		int countConsecutive = 0;
		for(int i = 0; i<str.length();i++){
			countConsecutive++;
			// if next char is diff than current, append this char to result
			if(i+1>=str.length() || str.charAt(i) != str.charAt(i+1)){
				sb.append(str.charAt(i));
				sb.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return sb.toString();
	}
			
	private int compressedSize(String str){
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for(int i = 0; i<str.length();i++){
			countConsecutive++;
			// if next char is diff than current, append this char to result
			if(i+1>=str.length() || str.charAt(i) != str.charAt(i+1)){
				compressedLength += 1+String.valueOf(countConsecutive).length(); 
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
	
	public static void main(String[] args) {
		E6_6_PerformBasicStringCompression obj = new E6_6_PerformBasicStringCompression();
		String result = obj.compress("wwwwaaadexxxxxx");
		System.out.println(result);
	}
}
