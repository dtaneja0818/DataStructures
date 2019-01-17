package Array_String;

/*
 * 1.4 Write a method to replace all spaces in a string with'%20'. You may assume that the 
 * string has sufficient space at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string. (Note: if implementing in Java, 
 * please use a character array so that you can perform this operation in place)
 * EXAMPLE
 * Input:
 * "Mr John Smith    "
 * Output: "Mr%20Dohn%20Smith"
 * 
 * A common approach in string manipulation problems is to edit the string starting from
	the end and work backwards. This is useful because we have extra buffer at the end,
	which allows us to change characters without worrying about what we're overwriting.
	We will use this approach in this problem. The algorithm works through a two scan
	approach. In the first scan, we count how many spaces there are in the string. This is
	used to compute how long the final string should be. In the second pass, which is done
	in reverse order, we actually edit the string. When we see a space, we copy %20 into the
	next spots. If there is no space, then we copy the original character.
 */
 
public class ReplaceAllSpacesInaStringWith3Chars_4 {


	public String replace(String s, int n){
		if(s == null || n <= 1){
			System.out.println("String is null or length is less than 1");
			return null;
		}
		int lenStr = n; 
		char[] arr = s.toCharArray();
		int len = arr.length;
		int  i = 0,spaceCount = 0,j = 0;
		while(i != lenStr-1){
			if(arr[i] == ' ') spaceCount++;
			i++;
		}
		int extraSpace = 2*spaceCount;
		int newIndex = lenStr + extraSpace;
		if(newIndex != s.length()){
			System.out.println("length of string is not sufficient");
			return null;
		}
		for(i = lenStr-1,j = newIndex-1;i >= 0 ; i--,j--){
			if(arr[i] == ' '){
				arr[j] = '0';
				arr[--j] = '2';
				arr[--j] = '%';	
			}
			else
				arr[j] = arr[i];
		}
		s = new String(arr);
		return s;
	}
	
	public static void main(String[] args) {
		ReplaceAllSpacesInaStringWith3Chars_4 obj = new ReplaceAllSpacesInaStringWith3Chars_4();
		String result = obj.replace("Mr John Smith    ",13); 
		System.out.println(result);
	}

}
