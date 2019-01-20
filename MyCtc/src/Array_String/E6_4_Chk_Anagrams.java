/*This method assumes that the set of possible characters in both strings is small. In the following implementation, 
 * it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
1) Create count array of size 256 for strings. Initialize all values in count array as 0.
2) Iterate through every character of both strings and increment the count of character in one array and decrement for other.
3) If count array contains any num !=0 then it means it has different set of char
*/
package Array_String;

import java.util.Scanner;

public class E6_4_Chk_Anagrams {

	public static void main(String[] args) {
		String str1,str2;			//Declaring 2 input strings
		int arr[]=new int[256];		//declaring array to store all char of a string
		int flag=1;
		System.out.println("enter string1");
		Scanner in=new Scanner(System.in);
		str1=in.nextLine();					//input string1
		System.out.println("enter string2");
		str2=in.nextLine();				//input string2
		int len1=str1.length();			//calculating length of string1
		int len2=str2.length();		//calculating length of string2
		if(len1!=len2){				//chk condition if length of string not equal terminate as we need to chk anagrams of equal lengths
			System.out.println("enter String of equal lengths");
			System.exit(0);
		}
		for(int i=0;i<len1;i++){
			int val1=str1.charAt(i);
			int val2=str2.charAt(i);
			arr[val1]++;		//incrementing count arr for string1
			arr[val2]--;		//decrementing count arr for string2
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){		//chk if arr has num !=0
				System.out.println("not anagrams");
				flag=0;break;
			}
		}

		if(flag==1)
			System.out.println("Anagrams");
	}

}
