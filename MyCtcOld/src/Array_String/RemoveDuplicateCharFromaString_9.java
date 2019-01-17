package Array_String;
/*
 * 1.9 Remove duplicate char from a string without using additional buffer
 */
public class RemoveDuplicateCharFromaString_9 {
	 /* Here we have taken 3 pointers tail,i,j
	 * tail increments only when we get a diff char basically the char are compared in a backward direction such that there is no duplicate char
	 * before the indexed char.
	 */
	private String removeDuplicates(String s){
		char[] str = s.toCharArray();
		if(str == null) return null;
		int len = str.length;
		if(len < 2) return s;
		
		int tail = 1;
		for(int i = 1;i < len ; i++){
			int j;
			for(j = 0;j<tail;j++){
				if(str[i] == str[j]) break;
			}
			if(j == tail){
				str[tail] = str[i];
				tail++;
			}
		}
		str[tail] = 0;
		return new String(str);
	}
	
	public static void main(String[] args) {
		RemoveDuplicateCharFromaString_9 obj = new RemoveDuplicateCharFromaString_9();
		String result = obj.removeDuplicates("aabbbbbdefa");
		System.out.println(result);
	}

}
