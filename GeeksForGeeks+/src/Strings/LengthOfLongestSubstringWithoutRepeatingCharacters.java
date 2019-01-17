package Strings;
/*
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstringWithoutRepeatingCharacters {

	public String substr(String str){
		if(str == null || str.length() == 1) return str;
		int n = str.length();
		int cur_len = 1;  // To store the lenght of current substring
		int max_len = 1;  // To store the result
		int prev_index;  // To store the previous index
		int i = 0,start = 0,end = 0;
		int[] visited = new int[256];

		/* Initialize the visited array as -1, -1 is used to indicate that character has not been visited yet. */
		for (i = 0; i < 256;  i++)	visited[i] = -1;

		/* Mark first character as visited by storing the index of first character in visited array. */
		visited[str.charAt(0)] = 0;

		/* Start from the second character. First character is already processed (cur_len and max_len are initialized as 1, and visited[str[0]] is set */
		for (i = 1; i < n; i++){
			prev_index =  visited[str.charAt(i)];

			/* If the currentt character is not present in the already processed substring or it is not part of the current NRCS, then do cur_len++ */
			if (prev_index == -1 || i - cur_len > prev_index) cur_len++;

			/* If the current character is present in currently considered NRCS,then update NRCS to start from the next character of previous instance. */
			else{
				/* Also, when we are changing the NRCS, we should also check whether length of the previous NRCS was greater than max_len or not.*/
				if (cur_len > max_len){
					max_len = cur_len;
					//start = prev_index;
					//end = i;
				}
				cur_len = i - prev_index;
			}
			visited[str.charAt(i)] = i; // update the index of current character
		}
		// Compare the length of last NRCS with max_len and update max_len if needed
		if (cur_len > max_len){
			max_len = cur_len;
			start = i - cur_len;
			end = i;
		}
		String result = str.substring(start,end);
		return result;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstringWithoutRepeatingCharacters obj = new LengthOfLongestSubstringWithoutRepeatingCharacters();
		String text = "gee";
		System.out.println("pattern found at index: "+obj.substr(text));
	}
}
